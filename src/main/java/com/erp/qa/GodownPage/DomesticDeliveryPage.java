package com.erp.qa.GodownPage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import com.erp.qa.pages.BasePage;

public class DomesticDeliveryPage extends BasePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public DomesticDeliveryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // ====== NAV ======
    @FindBy(xpath = "//*[@id='menuGodowntrn']/ul/li[5]/a")
    private WebElement domesticDeliveryMenu;

    public void openDomesticDelivery() {
        wait.until(ExpectedConditions.elementToBeClickable(domesticDeliveryMenu)).click();
    }

    // ====== DATE ======
    @FindBy(id = "datepicker")
    private WebElement dateField;

    /** Expects dd/MM/yyyy, e.g. "10/10/2025" */
    public void enterDate(String ddMMyyyy) {
        WebElement el = wait.until(ExpectedConditions.visibilityOf(dateField));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", el);
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].value=arguments[1]; arguments[0].dispatchEvent(new Event('change',{bubbles:true}));",
            el, ddMMyyyy
        );
    }

    // ====== SELECT2 (Product + Godown) ======
    @FindBy(id = "select2-ddlProductID-container")
    private WebElement productDropdown;

    @FindBy(id = "select2-ddlGodownID-container")
    private WebElement godownDropdown;

    /** Generic Select2 choose: clicks dropdown, types text, ENTERs */
    private void select2Choose(WebElement dropdownContainer, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(dropdownContainer)).click();

        By openSearch = By.cssSelector("span.select2-container--open input.select2-search__field");
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(openSearch));
        search.clear();
        search.sendKeys(text);
        search.sendKeys(Keys.ENTER);

        // wait until Select2 closes
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("span.select2-container--open")));
    }

    public void chooseProduct(String productName) { select2Choose(productDropdown, productName); }
    public void chooseGodown(String godownName) { select2Choose(godownDropdown, godownName); }

    // ====== ADD ROW ======
    @FindBy(id = "btnAddnewdelivery")
    private WebElement addNewDeliveryButton;

    public void addDeliveryRow() {
        wait.until(ExpectedConditions.elementToBeClickable(addNewDeliveryButton)).click();
    }

    // ====== DELIVERY MAN SELECT (duplicated per row) ======
    // Assuming the page really uses the same id "Delevry" per-row (typo retained to match DOM)
    @FindBy(id = "Delevry")
    private List<WebElement> deliverySelects;

    /** Choose delivery man for the MOST RECENT row */
    public void chooseDeliveryManByText(String name) {
        int last = lastIndex(deliverySelects);
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(deliverySelects.get(last)));
        new Select(el).selectByVisibleText(name);
    }

    // ====== REPEATED ROW INPUTS (same id per row) ======
    @FindBy(xpath = "//input[@id='txtfull']")
    private List<WebElement> fullCylInputs;

    @FindBy(xpath = "//input[@id='txtempty']")
    private List<WebElement> emptyCylInputs;

    @FindBy(xpath = "//input[@id='txtSV']")
    private List<WebElement> svInputs;

    @FindBy(xpath = "//input[@id='txtDBC']")
    private List<WebElement> dbcInputs;

    @FindBy(xpath = "//input[@id='txtDefective']")
    private List<WebElement> defectiveInputs;

    @FindBy(xpath = "//input[@id='txtLost']")
    private List<WebElement> lostInputs;

    @FindBy(xpath = "//input[@id='txtreturnfull']")
    private List<WebElement> returnFullInputs;

    public int getRowCount() {
        return fullCylInputs == null ? 0 : fullCylInputs.size();
    }

    private int lastIndex(List<?> list) {
        if (list == null || list.isEmpty()) throw new IllegalStateException("No rows found yet.");
        return list.size() - 1;
    }

   /* private void type(List<WebElement> list, int idx, String value) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(list.get(idx)));
        el.clear();
        el.sendKeys(value);
    }*/

    // ====== SUBMIT ======
    @FindBy(id = "btnSubmit")
    private WebElement submitButton;

    public void clickOnSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    // ====== ALERT HANDLING ======
    public void acceptAlert() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
            System.out.println("Alert accepted successfully.");
        } catch (TimeoutException te) {
            System.out.println("No alert appeared within wait.");
        } catch (Exception e) {
            System.out.println("Error handling alert: " + e.getMessage());
        }
    }

    // ====== GET DATA ======
    // You had @FindBy(id="...xpath..."). Using XPath correctly below.
    @FindBy(xpath = "//button[normalize-space()='Getdata']")
    private WebElement getDataButton;

    public void clickOnGetDataButton() {
        wait.until(ExpectedConditions.elementToBeClickable(getDataButton)).click();
    }
    @FindBy(id="btnEdit")
    private WebElement editButton;
    public void clickOnEditButton() {
		wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
	}
    @FindBy(id="btnupdate")
    private WebElement updateButton;
    public void clickOnUpdateButton() {
    			wait.until(ExpectedConditions.elementToBeClickable(updateButton)).click();
    }
    private void type(List<WebElement> list, int idx, String value) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(list.get(idx)));
        el.clear();
        el.sendKeys(value);
    }

    /** Fill the MOST RECENT row (matches your test flow). The 'row' arg is ignored on purpose. */
    public void fillRow(int row, String full, String empty, String sv, String dbc,
                        String defective, String lost, String returnFull) {

        int r = lastIndex(fullCylInputs); // most recently added row

        type(fullCylInputs, r, full);
        type(emptyCylInputs, r, empty);
        type(svInputs, r, sv);
        type(dbcInputs, r, dbc);
        type(defectiveInputs, r, defective);
        type(lostInputs, r, lost);
        type(returnFullInputs, r, returnFull);
    }
    

}
