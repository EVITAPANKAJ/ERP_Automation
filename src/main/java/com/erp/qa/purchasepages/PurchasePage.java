package com.erp.qa.purchasepages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.erp.qa.pages.BasePage;

public class PurchasePage extends BasePage {
	
	
	public PurchasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	Actions action = new Actions(driver);
	

	@FindBy(id="menuPurchase")
	WebElement purchaseLink;
	public void clickOnPurchaseLink() {
		purchaseLink.click();
	}
	
	@FindBy(xpath="//li[2][@id=\"menuPurchase\"]/ul/li[1]/a")
	WebElement puchaseformLink;
	public void clickOnPurchaseFormLink() {
		puchaseformLink.click();
	}
	@FindBy(id="txtInvoiceNumber")
	WebElement invoiceNumber;
	public void enterInvoiceNumber(String invNumber) {
		invoiceNumber.sendKeys(invNumber);
	}
	@FindBy(id="txtERVNumber")
	WebElement ervNumber;
	public void enterERVNumber(String ervNum) {
		ervNumber.sendKeys(ervNum);
	}
	@FindBy(xpath="//div[text()='--Select--']")
	WebElement godownDropdown;
	
	public void selectGodown() {
		godownDropdown.click();
	}
	@FindBy(xpath="//span[text()='MAIN GODOWN']")
	WebElement godown;
	
	public void searchGodown() {
		godown.click();
	}
	@FindBy(xpath="//button[@data-id='ddlSupplierID']/div/div/div")
	WebElement supplierDropdown;
	public void selectSupplier() {
		supplierDropdown.click();		
	}
	@FindBy(xpath="//span[text()='SUP_BHARAT PETROLEUM CORPORATION LIMITED_1']")
	WebElement supplier;
	public void searchSupplier() {
		supplier.click();
	}
	@FindBy(xpath="//button[@data-id='ddlVehicalID']/div/div/div" )
	WebElement vehicleDropdown;
	public void selectVehicle() {
		vehicleDropdown.click();
	}
	@FindBy(xpath="//span[text()='MH 04 EY 7088']")
	WebElement vehicle;
	public void searchVehicle() {
		vehicle.click();
	}	
	@FindBy(id="txtAccount")
	WebElement accountDropdown;
	public void EnterAccount(String account) {
		accountDropdown.sendKeys(account);	
	}
	@FindBy(id="txtProduct")
	WebElement productDropdown;
	public void EnterProduct(String product) {
		productDropdown.sendKeys(product);
	}
	@FindBy(id="txtQunatity")
	WebElement quantity;
	public void EnterQuantity(String qty) {
		quantity.clear();
		quantity.sendKeys(qty);
	}
	@FindBy(id="txtLost")
	WebElement lost;
	public void EnterLost(String Lost) {
		lost.sendKeys(Lost);
	}
	@FindBy(id="txtDefective")
	WebElement defective;
	public void EnterDefective(String Defective) {
		defective.sendKeys(Defective);
	}
	@FindBy(id="txtReplace")
	WebElement replace;
	public void EnterReplace(String Replace) {
		replace.sendKeys(Replace);
	}
	@FindBy(id="txtsubTotal")
	WebElement subtotal;
	public void EnterSubTotal(String subTotal) {
		subtotal.clear();
		subtotal.sendKeys(subTotal);
	}
	@FindBy(xpath="//button[@id='btnClear']")
	WebElement clearButton;
	public void clickonClearbutton() {
		action.scrollToElement(clearButton).perform();
		clearButton.click();
	}
	
	@FindBy(id="btnSubmit")
	WebElement submitButton;
	public void clickonSubmitbutton() {
		submitButton.click();
	}
	public void acceptAlert() {
	    try {
	        // Switch to the alert
	        Alert alert = driver.switchTo().alert();

	        // Print alert message (optional)
	        System.out.println("Alert text: " + alert.getText());

	        // Click OK
	        alert.accept();

	        System.out.println("Alert accepted successfully.");
	    } catch (Exception e) {
	        System.out.println("No alert found or error handling alert: " + e.getMessage());
	    }
	}
	
	public void FillDetails(String invNumber, String ervNum, String account, String product, String qty, String Lost, String Defective, String Replace, String subTotal) throws Exception {
		enterInvoiceNumber(invNumber);	
		enterERVNumber(ervNum);
		selectGodown();
		searchGodown();
		selectSupplier();
		searchSupplier();
		selectVehicle();
		searchVehicle();
		EnterAccount(account);
		EnterProduct(product);
		EnterQuantity(qty);
		EnterLost(Lost);
		EnterDefective(Defective);
		EnterReplace(Replace);
		EnterSubTotal(subTotal);
		clickonSubmitbutton();
		acceptAlert();
		
	}
}
	
	