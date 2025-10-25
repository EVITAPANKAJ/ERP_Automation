package com.erp.qa.commsalepage;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

    // ---------------- Page Elements ----------------

    @FindBy(xpath = "//*[@id=\"null\"]/ul/li[4]/a")
    private WebElement commSaleListLink;

    @FindBy(id = "Challandate")
    private WebElement challanDateInput;

    @FindBy(xpath = "//div[@class='filter-option-inner-inner']")
    private WebElement deliverymanDropdown;

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement deliverymanSearchInput;

    @FindBy(id = "btnSubmit")
    private WebElement getDataButton;

    @FindBy(xpath = "//tr[@class='odd']//a[contains(text(),'Edit')]")
    private WebElement editButton;

    @FindBy(xpath = "//button[@title='DINESH']")
    private WebElement deliverymanInEditPage;

    @FindBy(xpath = "//div[@class='dropdown bootstrap-select form-control bs3 dropup open']//input[@aria-label='Search']")
    private WebElement editDeliverymanSearch;

    @FindBy(xpath = "//div[contains(text(),'KAILASH HOTEL')]")
    private WebElement partyDropdown;

    @FindBy(xpath = "//div[@class='dropdown bootstrap-select form-control bs3 open']//input[@aria-label='Search']")
    private WebElement partySearchInput;

    @FindBy(xpath = "//input[@id='Deldate']")
    private WebElement deliveryDateInput;

    @FindBy(id = "txtChallanNo")
    private WebElement challanNumberInput;

    @FindBy(xpath = "//button[@title='VIRAR']")
    private WebElement areaDropdown;

    @FindBy(xpath = "//div[@class='dropdown bootstrap-select form-control bs3 dropup open']//input[@aria-label='Search']")
    private WebElement areaSearchInput;

    @FindBy(xpath = "//div[contains(text(),'19 KG(COM)')]")
    private WebElement productDropdown;

    @FindBy(xpath = "//div[@class='dropdown bootstrap-select form-control bs3 open']//input[@aria-label='Search']")
    private WebElement productSearchInput;

    @FindBy(xpath = "//input[@id='txtDiscount']")
    private WebElement discountInput;

    @FindBy(id = "txtFullQty")
    private WebElement fullQtyInput;

    @FindBy(id = "txtEmptyCylRecived")
    private WebElement emptyQtyInput;

    @FindBy(id = "btnSubmit")
    private WebElement updateButton;

    // ---------------- Actions ----------------

    public void clickOnCommSaleList() {
        commSaleListLink.click();
    }

    /** ✅ Fixed version: sets date correctly via JS */
    public void enterDate(String dateValue) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
            "arguments[0].value=''; arguments[0].value=arguments[1]; arguments[0].dispatchEvent(new Event('change'));",
            challanDateInput, dateValue
        );
    }

    public void clickOnDeliveryman() {
        deliverymanDropdown.click();
    }

    public void searchOnDeliveryman(String del) {
        deliverymanSearchInput.sendKeys(del);
    }

    public void clickOnGetData() {
        getDataButton.click();
    }

    public void clickOnEditButton() {
        editButton.click();
        switchToNewTab();
    }

    /** Switch to newly opened tab after clicking Edit */
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

    public void clickDeliveryman() {
        deliverymanInEditPage.click();
    }

    public void enterDeliverymanName(String del) {
        editDeliverymanSearch.sendKeys(del);
        editDeliverymanSearch.sendKeys(Keys.ENTER);
    }

    public void clickParty() {
        partyDropdown.click();
    }

    public void enterParty(String party) {
        partySearchInput.sendKeys(party);
        partySearchInput.sendKeys(Keys.ENTER);
    }

    /** ✅ Fixed version for Edit page date */
    public void enterOnDate(String dateValue) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
            "arguments[0].value=''; arguments[0].value=arguments[1]; arguments[0].dispatchEvent(new Event('change'));",
            deliveryDateInput, dateValue
        );
    }

    public void changeChallanNo(String chal) {
        challanNumberInput.clear();
        challanNumberInput.sendKeys(chal);
    }

    public void clickOnAreaDropdown() {
        areaDropdown.click();
    }

    public void enterAreaName(String area) {
        areaSearchInput.sendKeys(area);
        areaSearchInput.sendKeys(Keys.ENTER);
    }

    public void clickOnProduct() {
        productDropdown.click();
    }

    public void searchOnProduct(String product) {
        productSearchInput.sendKeys(product);
        productSearchInput.sendKeys(Keys.ENTER);
    }

    public void enterOnDiscount(String discount) {
        discountInput.clear();
        discountInput.sendKeys(discount);
    }

    public void updateFullQty(String full) {
        fullQtyInput.clear();
        fullQtyInput.sendKeys(full);
    }

    public void updateEmptyQty(String empty) {
        emptyQtyInput.clear();
        emptyQtyInput.sendKeys(empty);
    }

    public void clickOnUpdateButton() {
        updateButton.click();
    }
}
