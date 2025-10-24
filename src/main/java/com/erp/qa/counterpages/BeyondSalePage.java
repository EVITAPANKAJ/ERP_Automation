package com.erp.qa.counterpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.erp.qa.pages.BasePage;

public class BeyondSalePage extends BasePage {
	
	public BeyondSalePage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//*[@id=\"menuCounterSales\"]/ul/li[6]/a")
	WebElement beyondSalesLink;
	public void clickOnBeyondSalesLink() {
		beyondSalesLink.click();
	}
	@FindBy(id="txtConsumerNoSearch")
	WebElement consumerNoSearch;
	public void enterConsumerNo(String consumerNo) {
		consumerNoSearch.sendKeys(consumerNo);
	}
	@FindBy(id="btnGetConsumerData")
	WebElement getConsumerDataBtn;
	public void clickOnGetConsumerDataBtn() {
		getConsumerDataBtn.click();
	}
	@FindBy(id="txtInvoiceNo")
	WebElement invoiceNo;
	public void enterInvoiceNo(String invNo) {
		invoiceNo.sendKeys(invNo);
	}
	@FindBy(id="txtGSTIN")
	WebElement gstin;
	public void enterGSTIN(String gstinNo) {
		gstin.sendKeys(gstinNo);
	}
	@FindBy(xpath="//div[contains(text(),'Select State')]")
	WebElement stateDropdown;
	public void selectState() {
		stateDropdown.click();
	}
	@FindBy(xpath="//span[normalize-space()='MAHARASHTRA']")
	WebElement state;
	public void searchState() {
		state.click();
	}
	@FindBy(id="txtCity")
	WebElement city;
	public void enterCity(String cityName) {
		city.sendKeys(cityName);
	}
	@FindBy(id="txtEmail")
	WebElement email;
	public void enterEmail(String emailId) {
		email.sendKeys(emailId);
	}
	@FindBy(id="txtProduct")
	WebElement product;
	public void enterProduct(String productName) {
		product.sendKeys(productName);
	}
	@FindBy(id="btnSubmit")
	WebElement submitBtn;
	public void clickOnSubmitBtn() {
		submitBtn.click();
	}
	public void FillDetails(String consumerNo,String invNo,String gstinNo,String cityName,String emailId,String productName)throws Exception {
		enterConsumerNo(consumerNo);
		clickOnGetConsumerDataBtn();
		enterInvoiceNo(invNo);
		enterGSTIN(gstinNo);
		selectState();
		searchState();
		enterCity(cityName);
		enterEmail(emailId);
		enterProduct(productName);		
		clickOnSubmitBtn();
	}	

}
