package com.erp.qa.tvoutpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.qa.pages.BasePage;


public class PartialTvoutPage extends BasePage {
	
	public PartialTvoutPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//span[normalize-space()='TV Module']")
	WebElement tvModuleLink;
	public void clickOnTvModuleLink() {
		tvModuleLink.click();
	}
	@FindBy(xpath="//*[@id=\"menuTVOUT\"]/ul/li[3]/a")
	WebElement partialTvoutLink;
	public void clickOnPartialTvoutLink() {
		partialTvoutLink.click();
	}
	@FindBy(id="chkNewConsumer")
	WebElement newConsumerCheckbox;
	public void checkNewConsumerCheckbox() {
		if (!newConsumerCheckbox.isSelected()) {
			newConsumerCheckbox.click();
		}
	}
	@FindBy(id="txtNewConsumerNo")
	WebElement newConsumerNo;
	public void enterNewConsumerNo(String newConsumerNumber) {
		newConsumerNo.sendKeys(newConsumerNumber);
	}
	@FindBy(id="Newdatepicker")
	WebElement newDatepicker;
	public void enterNewDate(String newDate) {
		newDatepicker.clear();
		newDatepicker.sendKeys(newDate);
	}
	@FindBy(xpath="//div[@class='filter-option-inner-inner']")
	WebElement consumerTypeDropdown;
	public void selectConsumerType() {
		consumerTypeDropdown.click();
	}
	@FindBy(xpath="//span[normalize-space()='14.2 KG (S-DOM)']")
	WebElement consumerTypeOption;
	public void chooseConsumerType() {
		consumerTypeOption.click();
	}
	@FindBy(id="txtNewnumberofcylinder")
	WebElement numberOfCylinders;
	public void enterNumberOfCylinders(String numOfCylinders) {
		numberOfCylinders.sendKeys(numOfCylinders);
	}		
	@FindBy(xpath="//span[@id='select2-ddlNewGodownID-container']")
	WebElement newGodownDropdown;
	@FindBy(xpath="//input[@type='search']")
	WebElement godownSearch;
	public void selectNewGodownByName(String godownName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(newGodownDropdown));
		wait.until(ExpectedConditions.elementToBeClickable(newGodownDropdown));
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newGodownDropdown);
		try {
			newGodownDropdown.click();
		} catch (Exception e) {
			((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", newGodownDropdown);
		}
		wait.until(ExpectedConditions.visibilityOf(godownSearch));
		godownSearch.clear();
		godownSearch.sendKeys(godownName);
		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
			By.xpath("//li[contains(@class,'select2-results__option') and text()='" + godownName + "']")
		));
		option.click();
	}
	@FindBy(xpath="//span[@id='select2-ddlGodownID-container']")
	WebElement existingGodownDropdown;
	public void selectExistingGodownByName(String godownName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(existingGodownDropdown));
		wait.until(ExpectedConditions.elementToBeClickable(existingGodownDropdown));
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", existingGodownDropdown);
		try {
			existingGodownDropdown.click();
		} catch (Exception e) {
			((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", existingGodownDropdown);
		}
		wait.until(ExpectedConditions.visibilityOf(godownSearch));
		godownSearch.clear();
		godownSearch.sendKeys(godownName);
		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
			By.xpath("//li[contains(@class,'select2-results__option') and text()='" + godownName + "']")
		));
		option.click();
	}
	@FindBy(id="NewbtnSubmit")
	WebElement submitButton;
	public void clickOnSubmitButton() {
		submitButton.click();
	}	
	@FindBy(id="txtConsumerNoSearch")
	WebElement consumerNoSearch;
	public void enterConsumerNo(String consumerNo) {
		consumerNoSearch.sendKeys(consumerNo);
	}
	@FindBy(id="btnGetConsumerData")
	WebElement getConsumerDataButton;
	public void clickOnGetConsumerDataButton() {
		getConsumerDataButton.click();
	}
	@FindBy(id="btnSubmit")
	WebElement existingSubmitButton;
	public void clickOnExistingSubmitButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(existingSubmitButton));
		try {
			existingSubmitButton.click();
		} catch (Exception e) {
			((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", existingSubmitButton);
		}
	}
	
	
	}