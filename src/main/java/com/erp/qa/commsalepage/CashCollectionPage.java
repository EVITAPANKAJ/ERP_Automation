package com.erp.qa.commsalepage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.erp.qa.pages.BasePage;

public class CashCollectionPage extends BasePage{
	public CashCollectionPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//*[@id=\"null\"]/ul/li[2]/a")
	private WebElement cashcollection;
	public void clickOnCashCollectionlink() {
		cashcollection.click();
	}
	@FindBy(xpath="//button[@data-id='ddlDeliveryMan']//div[@class='filter-option-inner-inner'][normalize-space()='--Select--']")
	private WebElement deliveryman;
	public void clickonDeliverymandropdown() {
	 deliveryman.click();
	}
	@FindBy(xpath="//div[@class='dropdown bootstrap-select form-control bs3 open']//input[@aria-label='Search']")
	private WebElement enterdeliveryman;
	public void enterOndeliverymanname(String del) {
		enterdeliveryman.sendKeys(del);
		enterdeliveryman.sendKeys(Keys.ENTER);
	}
	@FindBy(xpath="//button[@data-id='ddlParty']//div[@class='filter-option-inner-inner'][normalize-space()='--Select--']")
	private WebElement selectparty;
	public void clickOnselectParty() {
		selectparty.click();
	}
	@FindBy(xpath="//div[@class='dropdown bootstrap-select form-control bs3 open']//input[@aria-label='Search']")
	private WebElement searchparty;
	public void enterParty(String party) {
		searchparty.sendKeys(party);
		searchparty.sendKeys(Keys.ENTER);
	}
	@FindBy(id="date")
	private WebElement datefield;
	public void changedate(String date) {
		datefield.clear();
		datefield.sendKeys(date);
	}
	@FindBy(id="txtChallanNo")
	private WebElement challanNumber;
	public void enterOnchallanNumber(String chall) {
		challanNumber.sendKeys(chall);
	}
	@FindBy(id="txtCashAmount")
	private WebElement amount;
	public void enterAmount(String amt) {
		amount.sendKeys(amt);
	}
	@FindBy(id="btnSubmit")
	private WebElement submit;
	public void clickOnSubmit() {
		submit.click();
	}
	//Wait for and accept alert(s)
	public void acceptAlert() {
	    try {        
	        Alert alert = driver.switchTo().alert();
	        System.out.println("Alert text: " + alert.getText());
	        alert.accept();
	        System.out.println("Alert accepted successfully.");
	    } catch (Exception e) {
	        System.out.println("No alert found or error handling alert: " + e.getMessage());
	    }
	}

}
