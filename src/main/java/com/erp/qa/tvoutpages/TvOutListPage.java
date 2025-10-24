package com.erp.qa.tvoutpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.qa.pages.BasePage;

public class TvOutListPage extends BasePage {
	public TvOutListPage(WebDriver driver) {
	super(driver);
}
	@FindBy(xpath="//*[@id=\"menuTVOUT\"]/ul/li[2]/a")
	WebElement tvoutlist;
	public void clickOnTvoutList() {
		tvoutlist.click();
	}
	@FindBy(xpath="//input[@type='search']")
	WebElement serchconsumer;
	public void enterConsumernumber(String consumerno) {
		serchconsumer.sendKeys(consumerno);
	}
	public void selectOnConsumer(String consumerNumber) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Dynamic XPath for consumer number
	    String xpath = "//*[@id='tblmain']/tbody//tr/td[2]/a[text()='" + consumerNumber + "']";

	    WebElement consumerLink = wait.until(
	        ExpectedConditions.elementToBeClickable(By.xpath(xpath))
	    );

	    consumerLink.click();
	}
	@FindBy(id="Invoicedate") 
	WebElement updatedate;
	public void changeDate(String date) {
		updatedate.clear();
		updatedate.sendKeys(date);
	}
	@FindBy(id="ddlDPR_Recieved")
	WebElement updateDPR;
	public void changeDPRReseved() {
		updateDPR.click();
	}
	@FindBy(xpath="//*[@id=\"ddlDPR_Recieved\"]/option[3]")
	WebElement selectdpr;
	public void selectDPRReseved() {
		selectdpr.click();
	}
	@FindBy(id="ddlcyl_Recieved")
	WebElement updateProduct;
	public void changeProductReceived() {
		updateProduct.click();
	}
	@FindBy(xpath="//select[@id='ddlcyl_Recieved']//option[@value='2'][normalize-space()='NO']")
	WebElement selectProduct;
	public void selectProductRecevied() {
	selectProduct.click();
	}
	@FindBy(xpath="//*[@id=\"Detail_form\"]/div[1]/div[3]/div[2]/div/div/button")
	WebElement clickreason;
	public void clickOnreasonforTvOut() {
		clickreason.click();
	}
	@FindBy(xpath="//span[normalize-space()='For Cancellation of SV']")
	WebElement selectReason;
	public void selectReasonforTVOut() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(selectReason));
	    ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectReason);
	    selectReason.click();
	}
	@FindBy(id="txtTotal_Deposite_Amount")
	WebElement enterDepositamt;
	public void enterDepositAmount(String amt) {
		enterDepositamt.clear();
		enterDepositamt.sendKeys(amt);
	}
	@FindBy(xpath="//button[@title='NORMAL SURRENDER']")
	WebElement TVType;
	public void clickOnTvType() {
	TVType.click();
	}
	@FindBy(xpath="//span[normalize-space()='NORMAL TV']")
	WebElement changeTvtype;
	public void ChangeTvtypefield() {
		changeTvtype.click();
	}
	@FindBy(xpath="//button[@title='MAHARASHTRA']")
	WebElement state;
	public void changestate() {
		state.click();
	}
	@FindBy(xpath="//span[normalize-space()='GUJARAT']")
	WebElement selectState;
	   public void clickOnselectState() {
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	       By stateLocator = By.xpath("//span[normalize-space()='GUJARAT']");
	       WebElement stateElement = wait.until(ExpectedConditions.elementToBeClickable(stateLocator));
	       stateElement.click();
	   }

	@FindBy(xpath="//button[@title='Kachchh']")
	WebElement changeDist;
	public void changedistrict() {
		changeDist.click();
	}
	@FindBy(xpath="//span[normalize-space()='Surat']")
	WebElement selectdis;
	public void clickOnDis() {
		selectdis.click();
	}
	@FindBy(xpath="//button[@title='Olpad']")
	WebElement tehsil;
	public void updateTehsil() {
		tehsil.click();
	}
	@FindBy(xpath="//span[normalize-space()='Surat City']")
	WebElement changeTehsil;
	public void clickonTehsil() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    By tehsilLocator = By.xpath("//span[normalize-space()='Surat City']");
	    WebElement tehsilElement = wait.until(ExpectedConditions.elementToBeClickable(tehsilLocator));
	    tehsilElement.click();
	}

	@FindBy(id="txtCity")
	WebElement city;
	public void enterCity(String cit) {
		city.clear();
		city.sendKeys(cit);
	}
	@FindBy(id="txtServices")
	WebElement service;
	public void enterservice(String ser) {
		service.sendKeys(ser);
	}
	@FindBy(id="txtQunatity")
	WebElement qty;
	public void enterqty(String qt) {
		qty.clear();
		qty.sendKeys(qt);
	}
	@FindBy(id="txtUnitCost")
	WebElement unit;
	public void enterUnitCost(String unitcost) {
		unit.sendKeys(unitcost);
	}
	@FindBy(id="txtTaxRate")
	WebElement tax;
	public void enterTaxRate(String taxrat) {
		tax.sendKeys("5");
	}
	@FindBy(id="imgbtnVLAdd")
	WebElement add;
	public void clickOnaddbutton() {
		add.click();
	}
	@FindBy(id="txtServices_1")
	WebElement service1;
	public void enterservice1(String sar) {
		service1.sendKeys(sar);
	}
	@FindBy(id="txtUnitCost_1")
	WebElement unitcost1;
	public void enterunitcost1(String unit) {
		unitcost1.sendKeys("1100");
	}
	@FindBy(id="btnSubmit")
	WebElement sub;
	public void clickOnSubmit() {
		sub.click();
	}
	public void Fillings(String consumerno,String consumerNumber,String date,String amt,String cit,String ser,String qt,
			String unitcost,String taxrat,String sar,String unit) {
		enterConsumernumber(consumerno);
		selectOnConsumer(consumerNumber);
		changeDate(date);
		changeDPRReseved();
		selectDPRReseved();
		changeProductReceived();
		selectProductRecevied();
		clickOnreasonforTvOut(); // Open the dropdown/modal first
		selectReasonforTVOut();  // Then select the reason
		enterDepositAmount(amt);
		clickOnTvType();
		ChangeTvtypefield();
		changestate();
		clickOnselectState();
		changedistrict();
		clickOnDis();
		updateTehsil();
		clickonTehsil();
		enterCity(cit);
		enterservice(ser);
		enterqty(qt);
		enterUnitCost(unitcost);
		enterTaxRate(taxrat);
		clickOnaddbutton();
		enterservice1(sar);
		enterunitcost1(unit);
		clickOnSubmit();
	}

}
