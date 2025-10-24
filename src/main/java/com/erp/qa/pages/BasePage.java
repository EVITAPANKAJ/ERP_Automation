package com.erp.qa.pages;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	public void captureDebugInfo(By locator, String tag) {
	    try {
	        WebElement el = null;
	        try { el = driver.findElement(locator); } catch (Exception e) { /* ignore */ }

	        System.out.println("=== Debug Info: " + tag + " ===");
	        if (el != null) {
	            System.out.println("isDisplayed=" + el.isDisplayed()
	                + ", isEnabled=" + el.isEnabled()
	                + ", readonly=" + el.getAttribute("readonly")
	                + ", type=" + el.getAttribute("type")
	                + ", class=" + el.getAttribute("class")
	                + ", value='" + el.getAttribute("value") + "'");
	            // computed style & bounding rect
	            String rectJs = "var e = arguments[0]; var r = e.getBoundingClientRect();" +
	                    "return [window.getComputedStyle(e).display, window.getComputedStyle(e).visibility, r.x, r.y, r.width, r.height];";
	            Object rect = ((JavascriptExecutor) driver).executeScript(rectJs, el);
	            System.out.println("computed/display/visibility/bbox = " + rect);
	        } else {
	            System.out.println("Element not present in DOM.");
	        }

	        // topmost element at element center
	        String topJs = "var el = arguments[0]; var r = el.getBoundingClientRect();" +
	                       "var cx = r.left + r.width/2; var cy = r.top + r.height/2;" +
	                       "return document.elementFromPoint(cx, cy).outerHTML;";
	        try {
	            Object top = ((JavascriptExecutor) driver).executeScript(topJs, el);
	            System.out.println("Topmost element at center: " + top);
	        } catch (Exception e) {
	            System.out.println("Unable to get topmost element: " + e.getMessage());
	        }

	        // screenshot
	        try {
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            byte[] png = ts.getScreenshotAs(OutputType.BYTES);
	            String filename = "./debug_" + tag + "_" + System.currentTimeMillis() + ".png";
	            Files.write(Paths.get(filename), png, StandardOpenOption.CREATE);
	            System.out.println("Saved screenshot: " + filename);
	        } catch (Exception e) {
	            System.out.println("Screenshot failed: " + e.getMessage());
	        }

	        // page source snapshot
	        try {
	            String html = driver.getPageSource();
	            String fname = "./debug_" + tag + "_" + System.currentTimeMillis() + ".html";
	            Files.writeString(Paths.get(fname), html);
	            System.out.println("Saved page source: " + fname);
	        } catch (Exception e) {
	            System.out.println("Save page source failed: " + e.getMessage());
	        }

	    } catch (Exception e) {
	        System.out.println("captureDebugInfo failed: " + e.getMessage());
	    }
	}
	public void SendKeys(By locator, String value, String tagForDebug) throws InterruptedException {
	    try {
	        // 1) Wait for visibility & clickable
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	        wait.until(ExpectedConditions.elementToBeClickable(locator));

	        WebElement el = driver.findElement(locator);

	        // 2) Scroll into view
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});", el);

	        // 3) Try Actions click -> clear -> sendKeys
	        try {
	            new Actions(driver).moveToElement(el).click().perform();
	            el.clear();
	            el.sendKeys(value);
	            return; // success
	        } catch (Exception e) {
	            System.out.println("Actions sendKeys failed: " + e.getMessage());
	        }

	        // 4) JS focus + remove readonly + set value + dispatch events
	        try {
	            String js = "var el = arguments[0];" +
	                        "el.removeAttribute('readonly');" +
	                        "el.removeAttribute('disabled');" +
	                        "el.focus();" +
	                        "el.value = arguments[1];" +
	                        "el.dispatchEvent(new Event('input', { bubbles: true }));" +
	                        "el.dispatchEvent(new Event('change', { bubbles: true }));" +
	                        "return true;";
	            ((JavascriptExecutor) driver).executeScript(js, el, value);
	            // small pause to let app react (use explicit wait instead of Thread.sleep if needed)
	            Thread.sleep(200);
	            return;
	        } catch (Exception e) {
	            System.out.println("JS fallback failed: " + e.getMessage());
	        }

	        // 5) If still not done, attempt to click a parent or preceding element that may unlock inputs
	        try {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
	            el.clear();
	            el.sendKeys(value);
	            return;
	        } catch (Exception e) {
	            System.out.println("Click fallback failed: " + e.getMessage());
	        }

	        // 6) Final fallback: set value via id (in case original element isn't the one to type into)
	        try {
	            String id = el.getAttribute("id");
	            if (id != null && !id.isEmpty()) {
	                String js2 = "var e = document.getElementById(arguments[0]); if(e){ e.value = arguments[1]; e.dispatchEvent(new Event('input', { bubbles: true })); e.dispatchEvent(new Event('change', { bubbles: true })); return true;} return false;";
	                Object ok = ((JavascriptExecutor) driver).executeScript(js2, id, value);
	                if (Boolean.TRUE.equals(ok)) return;
	            }
	        } catch (Exception e) {
	            System.out.println("Final id-js fallback failed: " + e.getMessage());
	        }

	        // If we reached here, capture debug info and throw
	        captureDebugInfo(locator, tagForDebug);
	        throw new org.openqa.selenium.ElementNotInteractableException("safeSendKeys failed for: " + locator.toString());

	    } catch (Exception ex) {
	        captureDebugInfo(locator, tagForDebug);
	        throw new RuntimeException("safeSendKeys exception: " + ex.getMessage(), ex);
	    }
	}

}
