package com.erp.qa.GodownPage;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.erp.qa.pages.BasePage;

public class ERVPage extends BasePage {

    public ERVPage(WebDriver driver) {
        super(driver);
    }

    /* -------------------- Wait Utilities -------------------- */
    private static final Duration TIMEOUT = Duration.ofSeconds(15);

    private WebDriverWait getWait() {
        return new WebDriverWait(driver, TIMEOUT);
    }
    

    /* -------------------- FIRST SECTION -------------------- */
    @FindBy(xpath = "//*[@id='menuGodowntrn']/ul/li[3]/a")
    private WebElement ervLink;

    public void clickOnERVLink() {
        getWait().until(ExpectedConditions.elementToBeClickable(ervLink)).click();
    }

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchBox;

    public void enterSearchBox(String text) {
        getWait().until(ExpectedConditions.visibilityOf(searchBox)).clear();
        searchBox.sendKeys(text);
    }

    @FindBy(id = "btnEdit")
    private WebElement editButton;

    public void clickOnEditButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(editButton)).click();
    }

    public boolean acceptAlert() {
        try {
            getWait().until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    @FindBy(xpath = "//div[contains(text(),'MAIN GODOWN')]")
    private WebElement mainGodownText;

    public void verifyMainGodownText() {
        getWait().until(ExpectedConditions.visibilityOf(mainGodownText)).click();
    }

    @FindBy(xpath = "(//input[@aria-label='Search'])[1]")
    private WebElement searchBox1;

    public void enterSearchBox1(String text) {
        getWait().until(ExpectedConditions.elementToBeClickable(searchBox1)).clear();
        searchBox1.sendKeys(text, Keys.ENTER);
    }

    @FindBy(id = "chkOtherVehicle")
    private WebElement otherVehicleCheckbox;

    public void clickOnOtherVehicleCheckbox() {
        getWait().until(ExpectedConditions.elementToBeClickable(otherVehicleCheckbox));
        if (!otherVehicleCheckbox.isSelected()) otherVehicleCheckbox.click();
    }

    @FindBy(id = "txtPCO_Vehical_Id")
    private WebElement pcoVehicleId;

    public void enterPCOVehicleId(String id) {
        getWait().until(ExpectedConditions.visibilityOf(pcoVehicleId)).clear();
        pcoVehicleId.sendKeys(id);
    }

    @FindBy(id = "txtProduct")
    private WebElement productField;

    public void enterProduct(String product) {
        getWait().until(ExpectedConditions.visibilityOf(productField)).clear();
        productField.sendKeys(product);
    }

    @FindBy(id = "txtSoundQunatity")
    private WebElement soundQuantity;

    public void enterSoundQuantity(String qty) {
        getWait().until(ExpectedConditions.visibilityOf(soundQuantity)).clear();
        soundQuantity.sendKeys(qty);
    }

    @FindBy(id = "txtDefective")
    private WebElement defectiveQuantity;

    public void enterDefectiveQuantity(String qty) {
        getWait().until(ExpectedConditions.visibilityOf(defectiveQuantity)).clear();
        defectiveQuantity.sendKeys(qty);
    }

    @FindBy(id = "imgProductAdd")
    private WebElement addButton;

    public void clickOnAddButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    @FindBy(id = "txtProduct_1")
    private WebElement productField1;

    public void enterProduct1(String product) {
        getWait().until(ExpectedConditions.visibilityOf(productField1)).clear();
        productField1.sendKeys(product);
    }

    @FindBy(id = "txtSoundQunatity_1")
    private WebElement soundQuantity1;

    public void enterSoundQuantity1(String qty) {
        getWait().until(ExpectedConditions.visibilityOf(soundQuantity1)).clear();
        soundQuantity1.sendKeys(qty);
    }

    @FindBy(id = "txtDefective_1")
    private WebElement defectiveQuantity1;

    public void enterDefectiveQuantity1(String qty) {
        getWait().until(ExpectedConditions.visibilityOf(defectiveQuantity1)).clear();
        defectiveQuantity1.sendKeys(qty);
    }

    @FindBy(id = "btnSubmit")
    private WebElement submitButton;

    public void clickOnSubmitButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    /* -------------------- SECOND SECTION -------------------- */
    @FindBy(id="tb2")
    private WebElement table2Element;
    public void openSecondSection() {
		table2Element.click();
	}
    @FindBy(xpath="//*[@id=\"tab2\"]/div[1]/div[1]/div/div/div/button/div/div/div")
    private WebElement godownDropdown;
    public void selectGodown() {		
    	godownDropdown.click();
	}
    @FindBy(xpath="//div[@class='dropdown bootstrap-select form-control bs3 open']//input[@aria-label='Search']")
    private WebElement godownSearchBox;
    public void searchAndSelectGodown(String godownName) {
    			getWait().until(ExpectedConditions.visibilityOf(godownSearchBox)).clear();
    			godownSearchBox.sendKeys(godownName);
    			godownSearchBox.sendKeys(Keys.ENTER);
    }
         
   
    @FindBy(id = "tb2ERVdate")
    private WebElement ervDate;

    public void enterERVDate(String date) {
        getWait().until(ExpectedConditions.visibilityOf(ervDate)).clear();
        ervDate.sendKeys(date);
        ervDate.sendKeys(Keys.TAB);
    }

    @FindBy(id = "tb2chkOtherVehicle")
    private WebElement otherVehicleCheckbox1;

    public void clickOnOtherVehicleCheckbox1() {
        getWait().until(ExpectedConditions.elementToBeClickable(otherVehicleCheckbox1));
        if (!otherVehicleCheckbox1.isSelected()) otherVehicleCheckbox1.click();
    }

    @FindBy(id = "tb2txtPCO_Vehical_Id")
    private WebElement pcoVehicleId1;

    public void enterPCOVehicleId1(String id) {
        getWait().until(ExpectedConditions.visibilityOf(pcoVehicleId1)).clear();
        pcoVehicleId1.sendKeys(id);
    }

    @FindBy(id = "tb2txtProduct")
    private WebElement productField2;

    public void enterProduct2(String product) {
        getWait().until(ExpectedConditions.visibilityOf(productField2)).clear();
        productField2.sendKeys(product);
    }

    @FindBy(id = "tb2txtSoundQunatity")
    private WebElement soundQuantity2;

    public void enterSoundQuantity2(String qty) {
        getWait().until(ExpectedConditions.visibilityOf(soundQuantity2)).clear();
        soundQuantity2.sendKeys(qty);
    }

    @FindBy(id = "tb2txtDefective")
    private WebElement defectiveQuantity2;

    public void enterDefectiveQuantity2(String qty) {
        getWait().until(ExpectedConditions.visibilityOf(defectiveQuantity2)).clear();
        defectiveQuantity2.sendKeys(qty);
    }

    @FindBy(id = "tb2imgProductAdd")
    private WebElement addButton2;

    public void clickOnAddButton2() {
        getWait().until(ExpectedConditions.elementToBeClickable(addButton2)).click();
    }

    @FindBy(id = "tb2txtProduct_1")
    private WebElement productField3;

    public void enterProduct3(String product) {
        getWait().until(ExpectedConditions.visibilityOf(productField3)).clear();
        productField3.sendKeys(product);
    }

    @FindBy(id = "tb2txtSoundQunatity_1")
    private WebElement soundQuantity3;

    public void enterSoundQuantity3(String qty) {
        getWait().until(ExpectedConditions.visibilityOf(soundQuantity3)).clear();
        soundQuantity3.sendKeys(qty);
    }

    @FindBy(id = "tb2txtDefective_1")
    private WebElement defectiveQuantity3;

    public void enterDefectiveQuantity3(String qty) {
        getWait().until(ExpectedConditions.visibilityOf(defectiveQuantity3)).clear();
        defectiveQuantity3.sendKeys(qty);
    }

    @FindBy(id = "tb2btnSubmit")
    private WebElement submitButton2;

    public void clickOnSubmitButton2() {
        getWait().until(ExpectedConditions.elementToBeClickable(submitButton2)).click();
    }
}
