package com.erp.qa.tvoutpages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.qa.pages.BasePage;


public class TvOutPage extends BasePage {
	
	public TvOutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//*[@id=\"menuTVOUT\"]/ul/li[1]/a")
	WebElement tvModuleLink;
	public void clickOnTvModuleLink() {
		tvModuleLink.click();
	}
	@FindBy(id="txtConsumer_No")
	WebElement consumerNo;
	public void enterConsumerNo(String conNo) {
		consumerNo.sendKeys(conNo);
	}
	@FindBy(id="btnGetConsumerData")
	WebElement btnGetConsumerData;
	public void btnGetConsumerData() {
		btnGetConsumerData.click();
	}
	@FindBy(xpath="//select[@id='ddlDPR_Recieved']")
	WebElement dprRecievedBy;
	public void selectDprRecievedBy() {
		Select select = new Select(dprRecievedBy);
		// Select the first option other than the default (index 1)
		select.selectByIndex(1);
	}
	@FindBy(xpath="//select[@id='ddlcyl_Recieved']")
	WebElement cylinderRecievedBy;
	public void selectCylinderRecievedBy() {
		Select select = new Select(cylinderRecievedBy);
		// Select the first option other than the default (index 1)
		select.selectByIndex(1);
	}
	@FindBy(xpath="//button[@data-id='ddlRecieved_At']")
	WebElement recievedAt;
	public void selectRecievedAt() {
		recievedAt.click();
	}
	@FindBy(xpath="//span[normalize-space()='MAIN GODOWN']")
	WebElement selectgodown;
	public void clickOnSelectGodown() {
		selectgodown.click();
	}
	@FindBy(xpath="//button[@data-id='ddlRecieved_By']//div[@class='filter-option-inner-inner'][normalize-space()='--Select--']")
	WebElement recievedBy;
	public void selectRecievedBy() {
		recievedBy.click();
	}
	@FindBy(xpath="//span[normalize-space()='MANOHAR']")
	WebElement selectRecievedBy;
	public void clickOnSelectRecievedBy() {
		selectRecievedBy.click();
	}
	@FindBy(xpath="//button[@data-id='ddlReson']//div[@class='filter-option-inner-inner'][normalize-space()='--Select--']")
	WebElement reason;
	public void selectReason() {
		reason.click();
	}
	@FindBy(xpath="//span[normalize-space()='Deposit rate correction code for SO']")
	WebElement selectReason;
	public void ClickonReason() {
		selectReason.click();
	}
	@FindBy(xpath="//input[@id='txtTotal_Deposite_Amount']")
	WebElement totalDepositeAmount;
	public void getTotalDepositeAmount(String amount) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(totalDepositeAmount));
	    totalDepositeAmount.clear();
	    totalDepositeAmount.sendKeys(amount);
	}
	@FindBy(xpath="//div[contains(text(),'--Select--')]")
	WebElement selectTvModel;
	public void clickOnSelectTvModel() {
		selectTvModel.click();
	}
	@FindBy(xpath="//span[normalize-space()='NORMAL SURRENDER']")
	WebElement selectTvModelOption;
	public void selectTvModelOption() {
		selectTvModelOption.click();
	}
	@FindBy(xpath="//button[@title='Select State']")
	WebElement selectState;
	public void clickOnSelectState() {
		selectState.click();
	}
	@FindBy(xpath="//span[normalize-space()='MAHARASHTRA']")
	WebElement selectStateOption;
	public void selectStateOption() {
		selectStateOption.click();
	}
	@FindBy(xpath="//select[@id='ddldistrict']")
	WebElement districtDropdown;
	public void selectDestrictOption() {
	Select select = new Select(districtDropdown);
	select.selectByVisibleText("Palghar");   
	}
	@FindBy(xpath="//select[@id='ddlTahsil']")
	WebElement tehsilDropdwon;
	public void selectTehsilOption() {
		Select select =new Select(tehsilDropdwon);
		select.selectByVisibleText("Vasai");
	}
	@FindBy(id="txtCity")
	WebElement city;
	public void enterCity(String cityName) {
		city.sendKeys(cityName);
	}
	@FindBy(id="btnSubmit")
	WebElement clicksubmit;
	public void clickOnSubmitButton() {
		clicksubmit.click();
	}
	public void Filling(String conNo,String amount,String cityName) throws Exception{
		enterConsumerNo(conNo);
		btnGetConsumerData();
		selectDprRecievedBy();
		selectCylinderRecievedBy();
		selectRecievedAt();
		clickOnSelectGodown();
		selectRecievedBy();
		clickOnSelectRecievedBy();
		selectReason();
		ClickonReason();
		getTotalDepositeAmount(amount);
		Thread.sleep(2000);
		clickOnSelectTvModel();
		selectTvModelOption();
		clickOnSelectState();
		selectStateOption();
		selectDestrictOption();
		selectTehsilOption();
		enterCity(cityName);
		clickOnSubmitButton();
	}	

}