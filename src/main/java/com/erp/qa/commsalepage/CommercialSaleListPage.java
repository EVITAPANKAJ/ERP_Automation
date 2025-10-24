package com.erp.qa.commsalepage;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.qa.pages.BasePage;

public class CommercialSaleListPage extends BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CommercialSaleListPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
    @FindBy(xpath="//*[@id=\"null\"]/ul/li[4]/a")
    private WebElement commsalelist;
    public void clickOnCommSaleList() {
    	commsalelist.click();
    }
    @FindBy(id="Challandate")
    private WebElement date;
    public void enterDate(WebDriver driver, String date) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    
	    // Clear any auto-filled date
	    js.executeScript("arguments[0].value='';", date);
	    
	    // Set the new date and trigger change event
	    js.executeScript("arguments[0].value='" + date + "'; arguments[0].dispatchEvent(new Event('change'));", date);
	}
    @FindBy(xpath="//div[@class='filter-option-inner-inner']")
    private WebElement deliveryman;
    public void clickOnDeliveryman() {
    	deliveryman.click();
    }
    @FindBy(xpath="//input[@aria-label='Search']")
    private WebElement searchDeliveryman;
    public void searchOnDeliveryman(String del) {    	
    	searchDeliveryman.sendKeys(del);
    }
    @FindBy(xpath="")
    private WebElement getdata;


}