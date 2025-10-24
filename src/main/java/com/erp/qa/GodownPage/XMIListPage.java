package com.erp.qa.GodownPage;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.qa.pages.BasePage;

public class XMIListPage extends BasePage{
	public XMIListPage(WebDriver driver) {
		// Constructor implementation
		super(driver);
	}
	@FindBy(xpath = "//*[@id=\"menuGodowntrn\"]/ul/li[8]/a")
	private WebElement xmiList;
	public void clickOnXMIList() {
		xmiList.click();
	}
	@FindBy(xpath="//*[@id=\"tblmain\"]/tbody/tr/td[2]/a")
	private WebElement viewIcon;
	public void clickOnViewIcon() {
		viewIcon.click();
		switchToNewTab();  
	}
	// --- Switch to new tab after Edit click ---
		public void switchToNewTab() {
			String parentWindow = driver.getWindowHandle();
			Set<String> allWindows = driver.getWindowHandles();
			for (String handle : allWindows) {
				if (!handle.equals(parentWindow)) {
					driver.switchTo().window(handle);
					break;
				}
			}
		}
		@FindBy(id="txtInvoiceNumber")
		private WebElement invoiceNumber;
		public void getInvoiceNumber(String value) {
			invoiceNumber.sendKeys(value);
		}
		@FindBy(id="btnSubmit")
		private WebElement submitBtn;
		private WebDriverWait getWait() {
	        return new WebDriverWait(driver, Duration.ofSeconds(15));
	    }

	    public void clickonSubmitbutton() {
	        try {
	            // Wait until clickable and re-find the element (avoid stale)
	            getWait().until(ExpectedConditions.elementToBeClickable(By.id("btnSubmit")));
	            WebElement btn = driver.findElement(By.id("btnSubmit"));
	            // scroll into view to avoid overlays
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
	            btn.click();
	        } catch (NoSuchElementException ne) {
	            System.out.println("submit button not found: " + ne.getMessage());
	            throw ne;
	        } catch (Exception e) {
	            System.out.println("Error clicking submit button: " + e.getMessage());
	            throw e;
	        }
	    } 

	 // Wait for and accept alert(s)
	    public void acceptAlert() {
	        try {
	            getWait().until(ExpectedConditions.alertIsPresent());
	            Alert alert = driver.switchTo().alert();
	            System.out.println("Alert text: " + alert.getText());
	            alert.accept();
	            System.out.println("Alert accepted successfully.");
	        } catch (Exception e) {
	            System.out.println("No alert found or error handling alert: " + e.getMessage());
	        }
	    }

		
	}
	


