package com.erp.qa.GodownPage;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.qa.pages.BasePage;

public class UpdateAcceptedLoadPage extends BasePage{
	public UpdateAcceptedLoadPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[normalize-space()='Update Accepted Loads']")
	WebElement updateaccepted;
	public void clickOnupdateaccepted() {
		updateaccepted.click();
	}
	@FindBy(id="datepicker")
	WebElement datepicker;
	public void changedate(String date) {
		datepicker.clear();
		datepicker.sendKeys(date);		
	}
	@FindBy(id="txtInvoiceNumber")
	WebElement invoicenumber;
	public void enterInvoice(String inv) {
		invoicenumber.sendKeys(inv);
	}
	@FindBy(id="btnSearch")
	WebElement search;
	public void clickOnSearch() {
		search.click();
		switchToNewTab();
		 try {
	            // Step 2: Wait a moment for the alert to appear
	            Thread.sleep(2000); // Optional: replace with WebDriverWait if preferred

	            // Step 3: Switch to the JavaScript alert
	            Alert alert = driver.switchTo().alert();

	            // Step 4: (Optional) Print alert message for debugging
	            System.out.println("Alert Message: " + alert.getText());

	            // Step 5: Click the OK button on the alert
	            alert.accept();

	            System.out.println("Alert handled successfully.");

	        } catch (Exception e) {
	            System.out.println("No alert appeared or alert could not be handled: " + e.getMessage());
	        }		 
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
	@FindBy(id = "txtInvoiceDate")
    private WebElement invoiceDateInput;   

    // Method to clear old date and select new date
    public void setInvoiceDate(String date1) {
        invoiceDateInput.clear();             // Clear existing date
        invoiceDateInput.sendKeys(date1);      // Type new date (format: yyyy-mm-dd)
    }

	@FindBy(xpath="//span[@id='select2-ddlGODOWNCODE-container']")
	WebElement godown;
	public void clickOnGodown() {
		godown.click();
	}
	@FindBy(xpath="//input[@role='textbox']")
	WebElement entergodown;
	public void enterOngodown(String godown){
		entergodown.sendKeys(godown);
		entergodown.sendKeys(Keys.ENTER);		
	}
	@FindBy(xpath="//span[@id='select2-ddlProduct-container']")
	WebElement product;
	public void clickOnProduct() {
		product.click();
	}
	@FindBy(xpath="//input[@role='textbox']")
	WebElement enterproduct;
	public void enterOnProduct(String product) {
		enterproduct.sendKeys(product);
		enterproduct.sendKeys(Keys.ENTER);		
	}
	@FindBy(id="txtQuantity")
	WebElement quantity;
	public void enterQuantity(String qty) {
		quantity.clear();
		quantity.sendKeys(qty);
	}
	@FindBy(id="txtLost")
	WebElement lost;
	public void enterLost(String lostQty) {
		lost.clear();
		lost.sendKeys(lostQty);
	}
	@FindBy(id="txtDefective")
	WebElement defective;
	public void enterDefective(String defectiveQty) {
		defective.clear();
		defective.sendKeys(defectiveQty);
	}
	@FindBy(xpath="//input[@id='imgbtnVLAdd']")
	WebElement addButton;
	public void clickOnAddButton() {
		addButton.click();
		try {
			Thread.sleep(2000); // Wait for the alert to appear
			Alert alert = driver.switchTo().alert();
			alert.accept(); // Accept the alert
		} catch (Exception e) {
			System.out.println("No alert appeared or alert could not be handled: " + e.getMessage());
		}
	}
	@FindBy(id="select2-ddlProduct_1-container")
	WebElement product1;
	public void clickOnProduct1() {
		product1.click();
	}	
	@FindBy(xpath="//input[@role='textbox']")
	WebElement enterproduc;
	public void enterOnProduc(String product1) {
		enterproduct.sendKeys(product1);
		enterproduct.sendKeys(Keys.ENTER);
}
	@FindBy(id="txtQuantity_1")
	WebElement quantity1;
	public void enterQuantity1(String qty1) {
		quantity1.clear();
		quantity1.sendKeys(qty1);
	}
	@FindBy(id="txtLost_1")
	WebElement lost1;
	public void enterLost1(String lostQty1) {
		lost1.clear();
		lost1.sendKeys(lostQty1);
	}
	@FindBy(id="txtDefective_1")
	WebElement defective1;
	public void enterDefective1(String defectiveQty1) {
		defective1.clear();
		defective1.sendKeys(defectiveQty1);
	}
	
	@FindBy(id="btnSubmit")
	WebElement submitButton;
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
	    @FindBy(id="datepicker")
		WebElement datepicker1;
		public void changedate1(String date2) {
			datepicker.clear();
			datepicker.sendKeys(date2);		
		}
		@FindBy(id="txtInvoiceNumber")
		WebElement invoicenumber1;
		public void enterInvoice1(String inv2) {
			invoicenumber.sendKeys(inv2);
		}
	    @FindBy(id="btnDelete")
	    WebElement deleteButton;
	    public void clickOnDeleteButton() {
	    	deleteButton.click();
	    }
	    public void Filling(String date,String inv,String date1,String godownname,String productname,String qty,String lostqty,String defectiveqty,String productname1, String qty1,String lostqty1,String defectiveqty1) throws InterruptedException {
	    	changedate(date);
			enterInvoice(inv);
			clickOnSearch();
			Thread.sleep(2000);
			acceptAlert();
			setInvoiceDate(date1);
			clickOnGodown();
			enterOngodown(godownname);
			clickOnProduct();
			enterOnProduct(productname);
			enterQuantity(qty);
			enterLost(lostqty);
			enterDefective(defectiveqty);
			clickOnAddButton();
			clickOnProduct1();
			enterOnProduc(productname1);
			enterQuantity1(qty1);
			enterLost1(lostqty1);
			enterDefective1(defectiveqty1);
			
			
			
			
	    }
}


