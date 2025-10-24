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

public class TainPage extends BasePage {

    public TainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"menuCounterSales\"]/ul/li[3]/a")
    WebElement tainLink;

    public void clickOnTainLink() {
        tainLink.click();
    }

    @FindBy(id = "txtGSTIN")
    WebElement gstin;

    public void enterGSTIN(String gstinNumber) {
        gstin.sendKeys(gstinNumber);
    }

    @FindBy(id = "txtDocNo")
    WebElement docNo;

    public void enterDocNo(String docNumber) {
        docNo.sendKeys(docNumber);
    }

    @FindBy(id = "txtConsumerNo")
    WebElement consumerNo;

    public void enterConsumerNo(String consumerNumber){
        consumerNo.sendKeys(consumerNumber);
    }

    @FindBy(xpath = "//div[contains(text(),'--Select--')]")
    WebElement stateDropdown;

    public void selectProduct() {
        stateDropdown.click();
    }

    @FindBy(xpath = "//span[normalize-space()='14.2 KG (S-DOM)']")
    WebElement product;

    public void searchProduct() {
        product.click();
    }

    @FindBy(id = "txtRegistrationNo")
    WebElement regNo;

    public void enterRegNo(String registrationNumber) {
        regNo.sendKeys(registrationNumber);
    }

    @FindBy(id = "txtConsumerName")
    WebElement consumerName;

    public void enterConsumerName(String name) {
        consumerName.sendKeys(name);
    }

    @FindBy(id = "txtAddress")
    WebElement address;

    public void enterAddress(String addr){
        address.sendKeys(addr);
    }

    @FindBy(id = "txtCity")
    WebElement city;

    public void enterCity(String cityName) {
       city.sendKeys(cityName);
    }

    @FindBy(xpath = "//div[contains(text(),'Select State')]")
    WebElement state;

    public void selectState() {
        state.click();
    }

    @FindBy(xpath = "//span[normalize-space()='MAHARASHTRA']")
    WebElement stateName;

    public void searchState() {
        stateName.click();
    }

    @FindBy(id = "txtContact")
    WebElement contact;

    public void enterContact(String contactNumber) {
        contact.sendKeys(contactNumber);
    }

    @FindBy(id = "txtEmail")
    WebElement email;

    public void enterEmail(String emailAddress)  {
        email.sendKeys(emailAddress);
    }

    @FindBy(id = "txtPreDistributerCode")
    WebElement preDistributerCode;

    public void enterPreDistributerCode(String code){
        preDistributerCode.sendKeys(code);
    }

    @FindBy(id = "txtPreConsumerNo")
    WebElement preConsumerNo;

    public void enterPreConsumerNo(String preConsumerNumber){
       preConsumerNo.sendKeys(preConsumerNumber);
    }

    @FindBy(id = "txtNumberofCylinder")
    WebElement numberOfCylinder;

    public void enterNumberOfCylinder(String number){
    	numberOfCylinder.sendKeys(number);
    }

    @FindBy(id = "txtNumberofDPR")
    WebElement numberOfDPR;

    public void enterNumberOfDPR(String dprNumber) {
       numberOfDPR.sendKeys(dprNumber);
    }

    @FindBy(id = "btnSubmit")
    WebElement submitButton;

    public void clickOnSubmitButton() {
        submitButton.click();
    }

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

    @FindBy(id = "btnback")
    WebElement backButton;

    public void clickonBackbutton() {
        backButton.click();
    }

    @FindBy(xpath = "//a[normalize-space()='Update TAIN']")
    WebElement updatetainLink;

    public void clickOnUpdateTAINLink() {
        updatetainLink.click();
    }

    @FindBy(id = "txtMDLDocumentNo")
    WebElement mdlDocumentNumber;

    public void enterMDLDocumentNumber(String billNo) {
        mdlDocumentNumber.sendKeys(billNo);
    }

    @FindBy(id = "btnMDLGet")
    WebElement mdlGetButton;

    public void clickOnMDLGetButton() {
        mdlGetButton.click();
    }

    public String FillDetails(String gstinNumber, String docNumber, String consumerNumber, String registrationNumber,
			String name, String addr, String cityName, String contactNumber, String emailAddress, String code,
			String preConsumerNumber, String number, String dprNumber) {

        enterGSTIN(gstinNumber);
        enterDocNo(docNumber);
        enterConsumerNo(consumerNumber);
        selectProduct();
        searchProduct();
        enterRegNo(registrationNumber);
        enterConsumerName(name);
        enterAddress(addr);
        enterCity(cityName);
        selectState();
        searchState();
        enterContact(contactNumber);
        enterEmail(emailAddress);
        enterPreDistributerCode(code);
        enterPreConsumerNo(preConsumerNumber);
        enterNumberOfCylinder(number);
        enterNumberOfDPR(dprNumber);

        // Use the robust submit implementation
        clickonSubmitbutton();
        acceptAlert();
        acceptAlert();        

        return getBillNumber();
        
        
    }   

}
