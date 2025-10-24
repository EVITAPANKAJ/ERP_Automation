package com.erp.qa.purchasepages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.qa.pages.BasePage;

public class PurchaseServiceLIstPage extends BasePage{
	public PurchaseServiceLIstPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//*[@id=\"menuPurchase\"]/ul/li[4]/a")
	WebElement clickservice;
	public void clickOnPurchaseService() {
		clickservice.click();
	}
	@FindBy(id="Invoicedate")
	WebElement selectdate;
	public void selectOndatefield(String date) {
		selectdate.clear();
		selectdate.sendKeys(date);
	}
	@FindBy(id="btnSubmit")
	WebElement clicksubmit;
	public void clickOnsubmitbutton() {
		clicksubmit.click();
	}
	@FindBy(xpath="//input[@type='search']")
	WebElement searchinv;
	public void enterinvoice(String inv) {
		searchinv.sendKeys(inv);
	}
	@FindBy(xpath="//a[normalize-space()='Edit']")
	WebElement edit;
	public void clickOnEditbutton() {
	    edit.click();
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
		@FindBy(xpath="//button[@title='ANITA GAS SERVICES']")
		WebElement company;
		public void waitForcompanyField() {
			new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(company));
		}
	
		@FindBy(id="txtInvoiceNumber")
		WebElement invo;
		public void waitForInvoiceField() {
		    new WebDriverWait(driver, Duration.ofSeconds(10))
		            .until(ExpectedConditions.visibilityOf(invo));
		}
		public void changeInvoice(String invc) {
		    invo.clear();
		    invo.sendKeys(invc);
		}
	@FindBy(id="Invoicedate")
	WebElement updatedate;
	public void changedate(String date1) throws InterruptedException {
		updatedate.clear();
		Thread.sleep(2000);
		updatedate.sendKeys(date1);
	}
	@FindBy(xpath="//div[contains(text(),'SUP_BHARAT PETROLEUM CORPORATION LIMITED_1')]")
	WebElement suppler;
	public void changesuppler() {
		suppler.click();
	}
	@FindBy(xpath="//span[normalize-space()='SUP_HPCL_2']")
	WebElement selectsupp;
	public void selecOnsuppler() {
		selectsupp.click();
	}
	@FindBy(id="txtNarration")
	WebElement narration;
	public void changenarration(String narr) {
		narration.clear();
		narration.sendKeys(narr);		
	}
	@FindBy(id="txtService")
	WebElement service;
	public void changeservice(String ser) {
		service.clear();
		service.sendKeys(ser);
	}
	@FindBy(id="txtSrvQunatity")
	WebElement quantity;
	public void changequantity(String qty) {
		quantity.clear();
		quantity.sendKeys(qty);
	}
	@FindBy(id="txtSrvUnitCost")
	WebElement unitcost;
	public void changeUnitCost(String unit) {
		unitcost.clear();
		unitcost.sendKeys(unit);		
	}
	@FindBy(id="btnSubmit")
	WebElement updatebutton;
	public void clickonUpdatebutton() {
		updatebutton.click();
	}
	public void FillDetails(String date,String inv,String invc,String date1,String narr,String ser,String qty,
			String unit) {
		selectOndatefield(date);
		clickOnsubmitbutton();
		enterinvoice(inv);
		clickOnEditbutton();		
		waitForcompanyField();
		waitForInvoiceField();
		changeInvoice(invc);		
		changesuppler();
		selecOnsuppler();
		changenarration(narr);
		changeservice(ser);
		changequantity(qty);
		changeUnitCost(unit);
		clickonUpdatebutton();
				
	}
	

}
