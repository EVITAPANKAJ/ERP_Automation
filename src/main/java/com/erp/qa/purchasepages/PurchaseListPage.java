package com.erp.qa.purchasepages;


import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.qa.pages.BasePage;



public class PurchaseListPage extends BasePage{
	
	public PurchaseListPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//*[@id=\"menuPurchase\"]/ul/li[2]/a")
	WebElement purchaselist;
	public void clickOnPurchaselist() {
		purchaselist.click();
	}
	@FindBy(id="Invoicedate")
	WebElement selectdate;
	public void enterOnselectdate(String date) {
		selectdate.clear();
		selectdate.sendKeys(date);
	}
	@FindBy(id="btnSubmit")
	WebElement sub;
	public void clickOnsubmitbutton() {
		sub.click();
	}
	@FindBy(xpath="//input[@type='search']")
	WebElement serch;
	public void enterserchInvoice(String inv) {
		serch.sendKeys(inv);
	}
	@FindBy(xpath="//a[normalize-space()='Edit']")
	WebElement editbutton;
	public void clickOnEditButton() {
		editbutton.click();
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
	WebElement invoice;
	public void waitForInvoiceField() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.visibilityOf(invoice));
	}
	public void changeInvoiceNo(String invc) throws InterruptedException {
	 	    invoice.clear();
	    invoice.sendKeys(invc);
	}
	@FindBy(xpath="//input[@id='txtERVNumber']")
	WebElement ervnumber;
	public void changeErvNo(String ervno) {
		ervnumber.clear();
		ervnumber.sendKeys(ervno);
	}
	@FindBy(id="Invoicedate")
	WebElement godowndate;		
	public void changegodown(String godate) {
		 try {
		        // Step 1: Handle any old alert
		        handleAlertIfPresent();

		        // Step 2: Set value via JavaScript to avoid auto current-date overwrite
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("arguments[0].value='" + godate + "';", godowndate);

		        // Step 3: Trigger change event (important for form validation)
		        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", godowndate);

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
	@FindBy(id="CompanInvoicedate")
	WebElement invocedate;
	public void changeinvdate(String invdate) {
		try {
	        // Step 1: Handle any old alert
	        handleAlertIfPresent();

	        // Step 2: Set value via JavaScript to avoid auto current-date overwrite
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].value='" + invdate + "';", invocedate);

	        // Step 3: Trigger change event (important for form validation)
	        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", invocedate);

	        // Step 4: Small wait
	        Thread.sleep(500);

	    } catch (Exception e) {
	        System.out.println("Error while setting date: " + e.getMessage());
	    }
	}
	@FindBy(xpath="//div[contains(text(),'MAIN GODOWN')]")
	WebElement godown;
	public void changeGodown() {
		godown.click();
	}
	@FindBy(xpath="//span[normalize-space()='EAST GODOWN']")
	WebElement selectgodown;
	public void updategodown() {
		selectgodown.click();
	}
	@FindBy(xpath="//div[contains(text(),'SUP_BHARAT PETROLEUM CORPORATION LIMITED_1')]")
	WebElement supp;
	public void changesupp() {
		supp.click();
	}
	@FindBy(xpath="//span[normalize-space()='SUP_HPCL_2']")
	WebElement supplier;
	public void updatesupp() {
		supplier.click();
	}
	@FindBy(xpath="//input[@id='chkOtherVehicle']")
	WebElement vehicl;
	public void othervehicl() {
		vehicl.click();
	}
	@FindBy(xpath="//input[@id='txtPCO_Vehical_No']")
	WebElement entervehicl;
	public void enterNewvehiclNo(String veh) {
		entervehicl.sendKeys(veh);
	}
	@FindBy(id="txtProduct")
	WebElement product;
	public void changeProduct(String pro) {
		product.clear();
		product.sendKeys(pro);
	}
	@FindBy(id="txtQunatity")
	WebElement quantity;
	public void changeqty(String qty) {
		quantity.clear();
		quantity.sendKeys(qty);
	}
	@FindBy(id="txtLost")
	WebElement lost;
	public void changeLost(String los) {
		lost.clear();
		lost.sendKeys(los);
	}
	@FindBy(id="txtDefective")
	WebElement defective;
	public void changeDefective(String def) {
		defective.clear();
		defective.sendKeys(def);
	}
	@FindBy(id="txtReplace")
	WebElement replace;
	public void changereplace(String rep) {
		replace.clear();
		replace.sendKeys(rep);
	}
	@FindBy(id="txtsubTotal")
	WebElement subtotal;
	public void chageSubtotal(String sub) {
		subtotal.clear();
		subtotal.sendKeys(sub);
	}
	@FindBy(id="btnSubmit")
	WebElement update;
	public void updatebutton() {
		update.click();
	}
	public void FillDetails(String date,String inv,String invc,String ervno,String godate,String invdate,String veh,String pro, 
			String qty,String los,String def,String rep,String sub) throws Exception{
		enterOnselectdate(date);
		clickOnsubmitbutton();
		enterserchInvoice(inv);
		clickOnEditButton();		
		waitForcompanyField();	
		Thread.sleep(3000);
		changeInvoiceNo(invc);
		Thread.sleep(2000);
		changeErvNo(ervno);
		handleAlertIfPresent();
		changegodown(godate);		
		changeinvdate(invdate);
		changeGodown();
		updategodown();
		changesupp();
		updatesupp();
		othervehicl();
		enterNewvehiclNo(veh);
		changeProduct(pro);
		changeqty(qty);
		changeLost(los);
		changeDefective(def);
		changereplace(rep);
		chageSubtotal(sub);
		updatebutton();		
		Thread.sleep(2000);
		
	}
	
	
	
}

	

