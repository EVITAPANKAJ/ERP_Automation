package com.erp.qa.purchasepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.erp.qa.pages.BasePage;

public class PurchaseServicePage extends BasePage{
	
	public PurchaseServicePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="menuPurchase")
	WebElement purchaseLink;
	public void clickOnPurchaseLink() {
		purchaseLink.click();
	}
	@FindBy(xpath="//*[@id=\"menuPurchase\"]/ul/li[3]/a")
	WebElement purchaseServiceLink;
	public void clickOnPurchaseServiceLink() {
		purchaseServiceLink.click();
	}
	@FindBy(xpath="//button[@data-id='ddlCompanyID']") 
	WebElement companyDropdown;
	public void selectCompany() {
		companyDropdown.click();		
	}
	@FindBy(xpath="//span[@class='text'][normalize-space()='ANITA GAS SERVICES']")
	WebElement company;
	public void searchCompany() {
		company.click();
	}
	@FindBy(id="txtInvoiceNumber" )
	WebElement invoiceNumber;
		public void enterInvoiceNumber(String invNumber) {
		invoiceNumber.sendKeys(invNumber);
	}
	@FindBy(xpath="//button[@data-id='ddlSupplierID']")
	WebElement supplierDropdown;
	public void selectSupplier() {
		supplierDropdown.click();		
	}
	@FindBy(xpath="//span[normalize-space()='SUP_BHARAT PETROLEUM CORPORATION LIMITED_1']")
	WebElement supplier;
	public void searchSupplier() {
		supplier.click();
	}
	@FindBy(id="txtNarration" )
	WebElement narration;
		public void enterNarration(String narr) {
		narration.sendKeys(narr);
	}
	@FindBy(id="txtService" )
	WebElement service;
		public void enterService(String serv) {
		service.sendKeys(serv);
	}
	@FindBy(id="txtSrvQunatity")
	WebElement quantity;
		public void enterQuantity(String qty) {
		quantity.clear();
		quantity.sendKeys(qty);
	}
		@FindBy(id="btnSubmit" )
		WebElement submitButton;
		public void clickonSubmitbutton() {
			submitButton.click();
		}
		public void FillDetails(String invNumber,String narr,String serv,String qty) throws Exception{
			selectCompany();
			searchCompany();
			enterInvoiceNumber(invNumber);	
			selectSupplier();
			searchSupplier();
			enterNarration(narr);
			enterService(serv);
			enterQuantity(qty);
			clickonSubmitbutton();
			
		}

}
