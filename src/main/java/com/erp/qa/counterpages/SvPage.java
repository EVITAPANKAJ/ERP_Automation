package com.erp.qa.counterpages;

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

public class SvPage extends BasePage {
    public SvPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//span[normalize-space()='Counter Sales']")
    WebElement counterSalesLink;

    public void clickOnCounterSalesLink() {
        counterSalesLink.click();
    }

    @FindBy(xpath="//a[normalize-space()='Subscription Voucher']")
    WebElement svLink;

    public void clickOnSvLink() {
        svLink.click();
    }

    @FindBy(id="txtInvoiceNo")
    WebElement invoiceNumber;
    public void enterInvoiceNumber(String invNumber) {
        invoiceNumber.sendKeys(invNumber);
    }

    @FindBy(id="txtGSTIN")
    WebElement gstin;
    public void enterGSTIN(String gstinNumber) {
        gstin.sendKeys(gstinNumber);
    }

    @FindBy(id="txtDocNo")
    WebElement docNumber;
    public void enterDocNumber(String docNum) {
        docNumber.sendKeys(docNum);
    }

    @FindBy(id="txtSVNo")
    WebElement svNumber;
    public void enterSVNumber(String svNum) {
        svNumber.sendKeys(svNum);
    }

    @FindBy(id="txtConsumerNo")
    WebElement consumerNumber;
    public void enterConsumerNumber(String consumerNum) {
        consumerNumber.sendKeys(consumerNum);
    }

    @FindBy(id="txtRegistrationNo")
    WebElement registrationNumber;
    public void enterRegistrationNumber(String regNum) {
        registrationNumber.sendKeys(regNum);
    }

    @FindBy(id="txtConsumerName")
    WebElement consumerName;
    public void enterConsumerName(String consName) {
        consumerName.sendKeys(consName);
    }

    @FindBy(id="txtContact")
    WebElement contactNumber;
    public void enterContactNumber(String contactNum) {
        contactNumber.sendKeys(contactNum);
    }

    @FindBy(id="txtAddress")
    WebElement address;
    public void enterAddress(String addr) {
        address.sendKeys(addr);
    }

    @FindBy(id="txtCity")
    WebElement city;
    public void enterCity(String cityName) {
        city.sendKeys(cityName);
    }

    @FindBy(id="txtBlueBookNo")
    WebElement blueBookNumber;
    public void enterBlueBookNumber(String blueBookNum) {
        blueBookNumber.sendKeys(blueBookNum);
    }

    @FindBy(id="txtEmail")
    WebElement email;
    public void enterEmail(String emailAddr) {
        email.sendKeys(emailAddr);
    }

    @FindBy(id="btnSubmit")
    WebElement submitButton;

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

    // Return bill number so caller can reuse it
    public String getBillNumber() {
        try {
            WebElement billNoElement = getWait().until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='tblmain']//tbody//tr[1]//td[4]"))
            );
            String billNo = billNoElement.getText().trim();
            System.out.println("Bill Number: " + billNo);
            return billNo;
        } catch (Exception e) {
            System.out.println("Unable to retrieve bill number: " + e.getMessage());
            return null;
        }
    }

    @FindBy(id="btnback")
    WebElement backButton;
    public void clickonBackbutton() {
        backButton.click();
    }

    @FindBy(xpath="//a[normalize-space()='Update NewConnection']")
    WebElement updateNewConnectionLink;
    public void clickOnUpdateNewConnectionLink() {
        updateNewConnectionLink.click();
    }

    @FindBy(id="txtMDLDocumentNo")
    WebElement mdlDocumentNumber;
    public void enterMDLDocumentNumber(String billNo) {
        mdlDocumentNumber.sendKeys(billNo);
    }
    @FindBy(id="btnMDLGet")
    WebElement mdlGetButton;
    public void clickOnMDLGetButton() {
		mdlGetButton.click();
	}
    @FindBy(id="btnDelete")
    WebElement deleteButton;
    public void clickOnDeleteButton() {
    	deleteButton.click();
    }

    public String FillDetails(String invNumber,String gstinNumber,String docNum,String svNum,String consumerNum,String regNum,
            String consName,String contactNum,String addr,String cityName,String blueBookNum,String emailAddr) throws Exception{
        enterInvoiceNumber(invNumber);
        enterGSTIN(gstinNumber);
        enterDocNumber(docNum);
        enterSVNumber(svNum);
        enterConsumerNumber(consumerNum);
        enterRegistrationNumber(regNum);
        enterConsumerName(consName);
        enterContactNumber(contactNum);
        enterAddress(addr);
        enterCity(cityName);
        enterBlueBookNumber(blueBookNum);
        enterEmail(emailAddr);

        // Submit once
        clickonSubmitbutton();

        // Handle expected alerts
        acceptAlert(); // confirm
        acceptAlert(); // success

        // Capture and return bill number
        return getBillNumber();
    }
}
