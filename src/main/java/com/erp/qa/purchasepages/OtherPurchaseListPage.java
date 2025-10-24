package com.erp.qa.purchasepages;


import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.qa.pages.BasePage;



public class OtherPurchaseListPage extends BasePage{
	public OtherPurchaseListPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//*[@id=\"menuPurchase\"]/ul/li[6]/a")
	WebElement otherpurchaselist;
	public void clickOnotherpurchaselist() {
		otherpurchaselist.click();
	}
	@FindBy(id="Invoicedate")
	WebElement enterdate;
	public void selectdate(String date) {
		enterdate.clear();
		enterdate.sendKeys(date);
	}
	@FindBy(id="btnSubmit")
	WebElement submit;
	public void clickOnsubmitbutton() {
		submit.click();
	}
	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	public void enterinvoicno(String inv) {
		search.sendKeys(inv);
	}
	@FindBy(xpath="//a[normalize-space()='Edit']")
	WebElement edit;
	public void clilckOnEditButton() {
	edit.click();
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
		@FindBy(xpath="//div[contains(text(),'ANITA GAS SERVICES')]")
		WebElement company;
		public void waitForcompanyField() {
			new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(company));
		}
	@FindBy(id="txtInvoiceNumber")
	WebElement invo;
	public void waitForInvoiceField() {
	    new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.visibilityOf(invo));
	}
	public void changeinvoice(String invc) {
		invo.clear();
		invo.sendKeys(invc);
	}
	@FindBy(id="Invoicedate")
	WebElement updatedate;
	public void chanagedate(String date1){
		 try {
		        // Step 1: Handle any old alert
		        handleAlertIfPresent();
		        // Step 2: Set value via JavaScript to avoid auto current-date overwrite
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].value='" + date1 + "';", updatedate);
		        // Step 3: Trigger change event (important for form validation)
		        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", updatedate);
		        // Step 4: Small wait
		        Thread.sleep(500);
		    } catch (Exception e) {
		        System.out.println("Error while setting date: " + e.getMessage());
		    }
		}
		public void handleAlertIfPresent() {
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		        System.out.println("Alert Found: " + alert.getText());
		        alert.accept();
		    } catch (Exception e) {
		        System.out.println("No alert present");
		    }
		}
		@FindBy(xpath="//div[contains(text(),'SUP_BHARAT PETROLEUM CORPORATION LIMITED_1')]")
		WebElement clicksup;

		@FindBy(xpath="//span[normalize-space()='SUP_HPCL_2']")
		WebElement changesup;
		
		public void clickOnsupp() {
		    clicksup.click();
		    
		    handleAlertIfPresent();
		}
		
		public void selectSupplier() {
		    changesup.click();
		    
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		        System.out.println("Alert message: " + alert.getText());
		        alert.accept(); 
		    } catch (Exception e) {
		        System.out.println("No alert appeared after selecting supplier");
		    }
		}
		
		public void handleAlertIfPresent1() {
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		        System.out.println("Alert handled: " + alert.getText());
		        alert.accept();
		    } catch (Exception e) {
		        
		    }
		}
		@FindBy(id="txtNarration")
		WebElement narration;
		public void changenarration(String narr) {
			narration.clear();
			narration.sendKeys(narr);
		}
		@FindBy(id="txtProduct")
		WebElement product;		

		    public void ProductPage(WebDriver driver) {
		        this.driver = driver;
		    }
		    public void enterProduct(String productName) {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        int attempts = 0;

		        while (attempts < 2) {
		            try {
		               
		                handleAlertIfPresent(1);		               
		                wait.until(ExpectedConditions.elementToBeClickable(product));		              
		                product.clear();
		                product.sendKeys(productName);		                
		                product.sendKeys(Keys.TAB);		                
		                handleAlertIfPresent(3);

		                System.out.println("✅ Product entered successfully: " + productName);
		                return;

		            } catch (UnhandledAlertException e) {
		                System.out.println("⚠️ Alert appeared — handling it now.");
		                handleAlertIfPresent(3);
		                attempts++;
		            } catch (Exception e) {
		                System.out.println("❌ Error while entering product: " + e.getMessage());
		                break;
		            }
		        }

		        System.out.println("⚠️ Product entry failed after multiple attempts.");
		    }		   
		    private void handleAlertIfPresent(int timeoutSeconds) {
		        try {
		            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
		            Alert alert = shortWait.until(ExpectedConditions.alertIsPresent());
		            System.out.println("⚡ Alert Found: " + alert.getText());
		            alert.accept();
		            System.out.println("✅ Alert accepted successfully.");
		        } catch (TimeoutException e) {
		            System.out.println("⏱️ No alert present within " + timeoutSeconds + " seconds.");
		        } catch (NoAlertPresentException e) {
		            System.out.println("ℹ️ No alert found to handle.");
		        } catch (Exception e) {
		            System.out.println("❌ Error while handling alert: " + e.getMessage());
		        }
		    }		
				

	@FindBy(id="txtQunatity")
	WebElement quanity;
	public void quantity(String qty) {
		quanity.clear();
		quanity.sendKeys(qty);
	}
	@FindBy(id="btnSubmit")
	WebElement updatebutton;
	public void clickOnUpdatebutton() {
		updatebutton.click();
	}
	public void FillDetails(String date,String inv,String invc,String date1,String narr,String productName,
			String qty) {
		selectdate(date);
		clickOnsubmitbutton();
		enterinvoicno(inv);
		clilckOnEditButton();
		waitForcompanyField();
		changeinvoice(invc);
		chanagedate(date1);
		handleAlertIfPresent();
		clickOnsupp();
		selectSupplier();
		handleAlertIfPresent1();
		changenarration(narr);		
		enterProduct(productName);			
		quantity(qty);
		clickOnUpdatebutton();
		
	}
	
}