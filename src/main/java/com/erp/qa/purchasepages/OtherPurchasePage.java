package com.erp.qa.purchasepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.erp.qa.pages.BasePage;

public class OtherPurchasePage extends BasePage {
	public OtherPurchasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
	}
	@FindBy(id="menuPurchase")
	WebElement purchaseLink;
	public void clickOnPurchaseLink() {
		purchaseLink.click();
	}
	@FindBy(xpath="//*[@id=\"menuPurchase\"]/ul/li[5]/a")
	WebElement otherPurchaseLink;
	public void clickOnOtherPurchaseLink() {
		otherPurchaseLink.click();
	}
	@FindBy(xpath="//div[contains(text(),'--Select--')]")
	WebElement godownDropdown;
	public void selectGodown() {
		godownDropdown.click();
	}
	@FindBy(xpath="//span[@class='text'][normalize-space()='ANITA GAS SERVICES']")
	WebElement godown;
	public void searchGodown() {
		godown.click();
	}
	@FindBy(id="txtInvoiceNumber")
	WebElement invoiceNumber;
	public void enterInvoiceNumber(String invNumber) {
		invoiceNumber.sendKeys(invNumber);
	}
	@FindBy(xpath="//div[contains(text(),'--Select--')]")
	WebElement supplierDropdown;
	public void selectSupplier() {
		supplierDropdown.click();
	}
	@FindBy(xpath="//span[normalize-space()='SUP_BHARAT PETROLEUM CORPORATION LIMITED_1']")
	WebElement supplier;
	public void searchSupplier() {
		supplier.click();
	}
	@FindBy(id="txtNarration")
	WebElement narration;
	public void enterNarration(String note) {
		narration.sendKeys(note);
	}
	@FindBy(id="txtAccount" )
	WebElement accountField;
	public void EnterAccount(String account) {
		accountField.sendKeys(account);
	}
	@FindBy(id="txtProduct")
	WebElement productField;
	public void EnterProduct(String product) {
		productField.sendKeys(product);
	}
	@FindBy(xpath="//input[@id='txtQunatity']")
	WebElement quantityField;
	public void EnterQuantity(String quantity) {
		quantityField.clear();
		quantityField.sendKeys(quantity);
	}
	@FindBy(id="btnSubmit")
	WebElement submitButton;
	public void clickonSubmitbutton() {
		submitButton.click();
	}
	public void FillDetails(String invNumber,String note,String account,String product,String quantity) {
		selectGodown();
		searchGodown();
		enterInvoiceNumber(invNumber);
		selectSupplier();
		searchSupplier();
		enterNarration(note);
		EnterAccount(account);
		EnterProduct(product);
		EnterQuantity(quantity);
		clickonSubmitbutton();
		
	}	

}
