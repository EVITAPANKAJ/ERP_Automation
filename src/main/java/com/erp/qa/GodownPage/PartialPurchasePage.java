package com.erp.qa.GodownPage;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.qa.pages.BasePage;

public class PartialPurchasePage extends BasePage{
	public PartialPurchasePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//span[normalize-space()='Godown Transactions']")
	WebElement godown;
	public void clickOnGodown() {
		godown.click();
	}
	@FindBy(xpath="//a[normalize-space()='Partial Purchase']")
	WebElement partialpurchase;
	public void clickOnPartialPurchase() {
		partialpurchase.click();
	}
	@FindBy(id="txtInvoiceNumber")
	WebElement invoice;
	public void enterInvoice(String inv) {
		invoice.sendKeys(inv);
	}
	@FindBy(id="txtERVNumber")
	WebElement ervno;
	public void enterERV(String erv) {
		ervno.sendKeys(erv);
	}
	@FindBy(id="chkOneWay")
	WebElement oneway;
	public void clickOnoneway() {
		oneway.click();
	}
	@FindBy(id="ddlGodownID")
	WebElement selectgodown;
	public void clickOnselectgodown() {
		selectgodown.click();
	}
	@FindBy(xpath="//option[normalize-space()='MAIN GODOWN']")
	WebElement searchgodown;
	public void clickOnSearchGodown() {
		searchgodown.click();
	}
	@FindBy(id = "ddlVehicalID")
	WebElement vehicalDropdown;
	public void selectVehical() {
		vehicalDropdown.click();
	}
	@FindBy(xpath="//option[normalize-space()='MH 04 GG 2368']")
	WebElement searchVehical;
	public void clickOnSearchVehical() {
		searchVehical.click();
	}
	@FindBy(id="chkOtherVehicle")
	WebElement checkvehical;
	public void clickOncheckVehical() {
		checkvehical.click();
	}
	@FindBy(id="txtPCO_Vehical_No")
	WebElement vehicle;
	public void enterVehical(String veh) {
		vehicle.sendKeys(veh);
	}
	@FindBy(id="txtProduct")
	WebElement product;
	public void enterProduct(String pro) {
		product.sendKeys(pro);
	}
	@FindBy(id="txtSoundQunatity")
	WebElement quantity;
	public void enterQty(String qty) {
		quantity.sendKeys(qty);
	}
	@FindBy(id="txtLost")
	WebElement lost;
	public void eneterLostqty(String lq) {
		lost.sendKeys(lq);
	}
	@FindBy(id="txtDefect_Cyl")
	WebElement defective;
	public void enterdefectiveqty(String dfq) {
		defective.sendKeys(dfq);
	}
	@FindBy(id="imgProductAdd")
	WebElement add;
	public void clickOnadd() {
		add.click();
	}
	@FindBy(id="btnSubmit")
	WebElement submit;
	 // Helper renamed to avoid clash with Object.wait()
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

