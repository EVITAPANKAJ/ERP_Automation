package com.erp.qa.GodownPage;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.qa.pages.BasePage;

public class UpdateCommDeliveryPage extends BasePage {
	
	public UpdateCommDeliveryPage(WebDriver driver) {
        super(driver);
    }
	@FindBy(xpath = "//*[@id=\"menuGodowntrn\"]/ul/li[7]/a")
	private WebElement upcommercialDeliveryLink;
 
	public void clickOnupCommercialDelivery() {
		upcommercialDeliveryLink.click();		
	}
	@FindBy(id = "datepicker")
	private WebElement dateField;

	public void enterDate(WebDriver driver, String date) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    
	    // Clear any auto-filled date
	    js.executeScript("arguments[0].value='';", dateField);
	    
	    // Set the new date and trigger change event
	    js.executeScript("arguments[0].value='" + date + "'; arguments[0].dispatchEvent(new Event('change'));", dateField);
	}
	@FindBy(xpath="//button[@id='btnGetdata']")
	private WebElement showButton;
	public void clickOnShowButton() {
		showButton.click();
	}
	@FindBy(xpath="//span[@id='select2-ddlGodown-container']")
	private WebElement godownDropdown;
	public void selectGodown() {
		godownDropdown.click();		
	}
	@FindBy(xpath="//input[@role='textbox']")
	private WebElement godownInput;
	public void enterGodown(String godown) {
		godownInput.sendKeys(godown);	
		godownInput.sendKeys(Keys.ENTER);
	}
	@FindBy(xpath="//tr[@class='odd']//span[@id='select2-ddlProductType-container']")
	private WebElement productTypeDropdown;
	public void selectProductType() {
		productTypeDropdown.click();		
	}
	@FindBy(xpath="//input[@role='textbox']")
	private WebElement productTypeInput;
	public void enterProductType(String productType) {
		productTypeInput.sendKeys(productType);	
		productTypeInput.sendKeys(Keys.ENTER);
	}
	@FindBy(id="txtFullCylinder")
	private WebElement fullCylinderField;
	public void enterFullCylinder(String fullCylinder) {
		fullCylinderField.clear();
		fullCylinderField.sendKeys(fullCylinder);
	}
	@FindBy(id="txtEmptyCylinder")
	private WebElement emptyCylinderField;
	public void enterEmptyCylinder(String emptyCylinder) {
		emptyCylinderField.clear();
		emptyCylinderField.sendKeys(emptyCylinder);
	}
	@FindBy(id="txtSV")
	private WebElement svField;
	public void enterSV(String sv) {
		svField.clear();
		svField.sendKeys(sv);
	}
	@FindBy(id="txtDBC")
	private WebElement dbcField;
	public void enterDBC(String dbc) {
		dbcField.clear();
		dbcField.sendKeys(dbc);
	}
	@FindBy(id="txtDefective")
	private WebElement defectiveField;
	public void enterDefective(String defective) {
		defectiveField.clear();
		defectiveField.sendKeys(defective);
	}
	@FindBy(id="txtLostCylinder")
	private WebElement lostCylinderField;
	public void enterLostCylinder(String lostCylinder) {
		lostCylinderField.clear();
		lostCylinderField.sendKeys(lostCylinder);
	}
	@FindBy(id="txtReturnFullCylinder")
	private WebElement returnFullCylinderField;
	public void enterReturnFullCylinder(String returnFullCylinder) {
		returnFullCylinderField.clear();
		returnFullCylinderField.sendKeys(returnFullCylinder);
	}
	@FindBy(id="btnSubmit")
	private WebElement updateButton;
	private WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void clickonSubmitbutton() {
        try {
            // Wait until clickable and re-find the element (avoid stale)
            getWait().until(ExpectedConditions.elementToBeClickable(By.id("btnSubmit")));
            WebElement btn = driver.findElement(By.id("btnSubmit"));
            // scroll into view to avoid overlays
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
            btn.click();
        } catch (NoSuchElementException ne) {
            System.out.println("submit button not found: " + ne.getMessage());
            throw ne;
        } catch (Exception e) {
            System.out.println("Error clicking submit button: " + e.getMessage());
            throw e;
        }
    }


 // Wait for and accept alert(s)
    public void acceptAlert() {
        try {
            getWait().until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
            System.out.println("Alert accepted successfully.");
        } catch (Exception e) {
            System.out.println("No alert found or error handling alert: " + e.getMessage());
        }
    }

}
