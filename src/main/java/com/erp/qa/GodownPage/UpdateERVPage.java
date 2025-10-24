package com.erp.qa.GodownPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.erp.qa.pages.BasePage;

public class UpdateERVPage extends BasePage{
	public UpdateERVPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//*[@id=\"menuGodowntrn\"]/ul/li[4]/a")
	WebElement updateERVLink;
	public void clickOnUpdateERVLink() {
		updateERVLink.click();
	}
	
	@FindBy(id="datepicker")
	WebElement datePicker;
	public void selectDate(String date) {
		datePicker.clear();
		datePicker.sendKeys(date);
	}
	@FindBy(id="txtERVNumber")
	WebElement ervNumber;
	public void enterERVNumber(String ervNum) {
		ervNumber.sendKeys(ervNum);
	}
	@FindBy(id="btnSearch")
	WebElement searchButton;
	public void clickOnSearchButton() {
		searchButton.click();
	}
	@FindBy(id="btnDelete")
	WebElement deleteButton;
	public void clickOnDeleteButton() {
		deleteButton.click();
	}
	// Wait for and accept alert(s)
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
