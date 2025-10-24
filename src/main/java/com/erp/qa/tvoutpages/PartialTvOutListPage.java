package com.erp.qa.tvoutpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.qa.pages.BasePage;

public class PartialTvOutListPage extends BasePage{
	
	public PartialTvOutListPage(WebDriver driver) {
		super(driver);
	}
	public void clickOnTvModuleLink() {
		// TODO Auto-generated method stub
		
	}
	@FindBy(xpath="//*[@id=\"menuTVOUT\"]/ul/li[4]/a")
	WebElement partialtvoutlist;
	public void clickonPartialtvoutlist() {
		partialtvoutlist.click();
	}
	@FindBy(xpath="//input[@type='search']")
	WebElement searchbox; 
		public void enterConosumernumber(String cons) {
			searchbox.sendKeys(cons);
		}
		public void clickOnConsumerNumber(String consumerNumber) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    // Dynamic XPath using the passed consumerNumber
		    String xpath = "//a[text()='" + consumerNumber + "']";

		    WebElement consumerLink = wait.until(
		        ExpectedConditions.elementToBeClickable(By.xpath(xpath))
		    );
		    
		    consumerLink.click();
		}

	@FindBy(id="txtConsumerName")
	WebElement enterconsName;
	public void enterConsumerName(String con) {
		enterconsName.sendKeys(con);
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
	@FindBy(xpath="//button[@class='btn dropdown-toggle btn-default bs-placeholder']//div[@class='filter-option-inner-inner'][normalize-space()='Nothing selected']")
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
	@FindBy(xpath="//button[@data-id='ddlTVtype']//div[@class='filter-option-inner-inner'][normalize-space()='--Select--']")
	WebElement selectTvModel;
	public void clickOnSelectTvModel() {
		selectTvModel.click();
	}
	@FindBy(xpath="//span[normalize-space()='NORMAL SURRENDER']")
	WebElement selectTvModelOption;
	public void selectTvModelOption() {
		selectTvModelOption.click();
	}
	@FindBy(xpath="//button[@data-id='ddlstate']//div[@class='filter-option-inner-inner'][normalize-space()='Nothing selected']")
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
	@FindBy(xpath="//select[@id='ddlDPR_Recieved']")
	WebElement dprRecievedBy1;
	public void selectDprRecievedBy1() {
		Select select = new Select(dprRecievedBy);
		// Select the first option other than the default (index 1)
		select.selectByIndex(2);
	}
	@FindBy(xpath="//select[@id='ddlcyl_Recieved']")
	WebElement cylinderRecievedBy1;
	public void selectCylinderRecievedBy1() {
		Select select = new Select(cylinderRecievedBy);
		// Select the first option other than the default (index 1)
		select.selectByIndex(2);
	}
	@FindBy(id="txtServices")
	WebElement selectServices;
	public void selectonService(String servic) {
		selectServices.sendKeys(servic);
	}
	@FindBy(id="txtUnitCost")
	WebElement enterUnitcost;
	public void enterOnUnitCost(String unitcost) {
		enterUnitcost.sendKeys(unitcost);
	}
	@FindBy(id="imgbtnVLAdd")
	WebElement clickadd;
	public void clickOnAddbutton() {
		clickadd.click();
	}
	@FindBy(id="txtServices_1")
	WebElement enterservice;
	public void enterOnservic(String service) {
		enterservice.sendKeys(service);
	}
	@FindBy(id="txtUnitCost_1")
	WebElement enterUnitcost1;
	public void enterOnUnitcost1(String Unitcos) {
		enterUnitcost1.sendKeys(Unitcos);
	}
		
	}


