package com.erp.qa.counterpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.erp.qa.pages.BasePage;

public class ConnectionSwapPage extends BasePage {
	
	public ConnectionSwapPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
	}
	@FindBy(xpath="//*[@id=\"menuCounterSales\"]/ul/li[7]/a")
	WebElement connectionSwapLink;
	public void clickOnConnectionSwapLink() {
		connectionSwapLink.click();
	}
	@FindBy(id="txtConsumer_No")
	WebElement consumerNo;
	public void enterConsumerNo(String consNo) {
		consumerNo.sendKeys(consNo);
	}
	@FindBy(id="btnGetConsumerData")
	WebElement getConsumerDataBtn;
	public void clickOnGetConsumerDataBtn() {
		getConsumerDataBtn.click();
	}
	@FindBy(xpath="//button[@data-id='ddlRecieved_At']//div[@class='filter-option-inner-inner'][normalize-space()='--Select--']")
	WebElement receivedAtDropdown;
	public void selectReceivedAt() {
		receivedAtDropdown.click();
	}
	@FindBy(xpath="//span[normalize-space()='MAIN GODOWN']")
	WebElement receivedAt;
	public void searchReceivedAt() {
		receivedAt.click();
	}
	@FindBy(xpath="//div[@class='form-group has-feedback']//div[@class='filter-option-inner-inner'][normalize-space()='--Select--']")
	WebElement swapTypeDropdown;
	public void selectSwapType() {
		swapTypeDropdown.click();
	}
	@FindBy(xpath="//a[@class='active']//span[@class='text'][normalize-space()='19 KG(COM)']")
	WebElement swapType;
	public void searchSwapType() {
		swapType.click();
	}
	@FindBy(id="btnSubmit")
	WebElement submitBtn;
	public void clickOnSubmitBtn() {
		submitBtn.click();
	}
	public void FillDetails(String consNo) throws Exception{
		enterConsumerNo(consNo);
		clickOnGetConsumerDataBtn();
		selectReceivedAt();
		searchReceivedAt();
		selectSwapType();
		searchSwapType();
		clickOnSubmitBtn();
	}
}
