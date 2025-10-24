package com.erp.qa.GodownPage;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.erp.qa.pages.BasePage;

public class AcceptedLoadPage extends BasePage{
	public AcceptedLoadPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[normalize-space()='Accepted Loads']")
	WebElement acceptedload;
	public void clickOnAcceptedload() {
		acceptedload.click();
	}
	@FindBy(id="reportrange")
	WebElement date;
	public void selectdate() {
		date.click();
	}
	@FindBy(xpath="//li[normalize-space()='Last 30 Days']")
	WebElement sevendays;
	public void clickOnSeven() {
		sevendays.click();
	}
	@FindBy(id="btnSubmit")
	WebElement submit;
	public void clickonsumt() {
		submit.click();
	}
	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	public void clickOnSearch(String sear) {
		search.sendKeys(sear);
	}
	@FindBy(xpath="//*[@id=\"tblmain\"]/tbody/tr/td[2]/a")
	WebElement clickinv;
	public void clickOnclickinv() {
		clickinv.click();
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
	@FindBy(id="CompanInvoicedate")
	WebElement invdate;
	public void enterinvdate(String invd) {
		invdate.sendKeys(invd);
	}
	@FindBy(xpath="//button[@title='Nothing selected']")
	WebElement suppler;
	public void selectsup() {
		suppler.click();
	}
	@FindBy(xpath="//span[normalize-space()='SUP_BHARAT PETROLEUM CORPORATION LIMITED_1']")
	WebElement selctsup;
	public void SelectOnsupp() {
		selctsup.click();
	}
	@FindBy(id="txtAccount")
	WebElement account;
	public void enteraccount(String acc) {
		account.sendKeys(acc);
	}
	@FindBy(id="txtsubTotal")
	WebElement subtotal;
	public void enterSubtotal(String sub) {
		subtotal.sendKeys(sub);
	}
	@FindBy(id="btnSubmit")
	WebElement submitbutton;
	public void clickOnSubmit() {
		submitbutton.click();
	}

}
