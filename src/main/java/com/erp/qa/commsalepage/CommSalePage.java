package com.erp.qa.commsalepage;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.qa.pages.BasePage;

public class CommSalePage extends BasePage {

    public CommSalePage(WebDriver driver) { super(driver); }

    // ---------- Waits / helpers ----------
    private WebDriverWait uiWait() { return new WebDriverWait(driver, Duration.ofSeconds(2)); }
    private WebDriverWait shortWait() { return new WebDriverWait(driver, Duration.ofSeconds(1)); }

    private static final By OPEN_BS_MENU = By.xpath(
        "//div[contains(@class,'bootstrap-select') and (contains(@class,'open') or contains(@class,'show'))]"
    );

    private static final By OPEN_BS_SEARCH = By.xpath(
        "//div[contains(@class,'bootstrap-select') and (contains(@class,'open') or contains(@class,'show'))]"
      + "//div[contains(@class,'bs-searchbox')]//input[@aria-label='Search']"
    );

    private static By optionByExactText(String text) {
        return By.xpath(".//span[contains(@class,'text')][normalize-space()='" + text + "']");
    }

    private void scrollIntoView(WebElement el) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
    }

    private WebElement findVisible(By... bys) {
        for (By by : bys) {
            for (WebElement el : driver.findElements(by)) {
                try { if (el.isDisplayed()) return el; } catch (Exception ignored) {}
            }
        }
        return null;
    }

    private void tinyPause(long ms) { try { Thread.sleep(ms); } catch (InterruptedException ignored) {} }

    private boolean closeAnyAlert(long seconds) {
        try {
            Alert a = new WebDriverWait(driver, Duration.ofSeconds(seconds))
                    .until(ExpectedConditions.alertIsPresent());
            a.accept();
            tinyPause(200);
            return true;
        } catch (Exception ignored) { return false; }
    }

    private void typeInActiveSearchAndEnter(String text) {
        WebElement search = uiWait().until(ExpectedConditions.visibilityOfElementLocated(OPEN_BS_SEARCH));
        search.clear();
        search.sendKeys(text);
        search.sendKeys(Keys.ENTER);
    }

    /** Verify dropdown selection by button text OR backing <select> OR a dependent field becoming enabled. */
    private void waitForSelectionOnButtonOrDependentEnabled(String dataId, String expectedText, WebElement dependentToEnable, int seconds) {
        String expected = expectedText == null ? "" : expectedText.trim();

        ExpectedCondition<Boolean> condition = drv -> {
            // button text
            try {
                WebElement t = drv.findElement(By.cssSelector("button[data-id='" + dataId + "'] .filter-option-inner-inner"));
                String shown = t.getText() == null ? "" : t.getText().trim();
                if (!shown.isEmpty() && (shown.equalsIgnoreCase(expected) || shown.contains(expected))) return true;
            } catch (Exception ignored) {}

            // backing <select>
            try {
                WebElement select = drv.findElement(By.id(dataId));
                WebElement checked = null;
                try { checked = select.findElement(By.cssSelector("option:checked")); } catch (Exception ignored) {}
                String shown = null;
                if (checked != null) shown = checked.getText();
                if (shown == null || shown.isEmpty()) shown = select.getAttribute("value");
                if (shown != null) {
                    shown = shown.trim();
                    if (!shown.isEmpty() && (shown.equalsIgnoreCase(expected) || shown.contains(expected))) return true;
                }
            } catch (Exception ignored) {}

            // dependent becomes enabled
            try {
                if (dependentToEnable != null && dependentToEnable.isDisplayed() && dependentToEnable.isEnabled()) return true;
            } catch (Exception ignored) {}

            return false;
        };

        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(condition);
    }

    private void waitEnabled(WebElement el, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(d -> {
            try { return el.isDisplayed() && el.isEnabled(); } catch (Exception e) { return false; }
        });
    }

    // ---------- Navigation ----------
    @FindBy(xpath = "//span[normalize-space()='Commercial Cyl. Sales']")
    private WebElement commSaleLink;

    public void clickOnCommSaleLink() {
        closeAnyAlert(1);
        uiWait().until(ExpectedConditions.elementToBeClickable(commSaleLink)).click();
        closeAnyAlert(1);
    }

    @FindBy(xpath = "//a[normalize-space()='Sale/Empty Received']")
    private WebElement commSaleEntryLink;

    public void clickOnCommercialSale() {
        closeAnyAlert(1);
        uiWait().until(ExpectedConditions.elementToBeClickable(commSaleEntryLink)).click();
        closeAnyAlert(1);
    }

    // ---------- Delivery Man ----------
    @FindBy(xpath = "//button[@data-id='ddlDeliveryMan']")
    private WebElement deliveryManDropdownBtn;

    @FindBy(id = "ddlDeliveryMan")
    private WebElement deliveryManSelect;

    public void clickOndeliveryman() {
        closeAnyAlert(1);
        scrollIntoView(deliveryManDropdownBtn);
        uiWait().until(ExpectedConditions.elementToBeClickable(deliveryManDropdownBtn)).click();
        uiWait().until(ExpectedConditions.visibilityOfElementLocated(OPEN_BS_MENU));
    }

    public void enterDeliveryManInSearchBox(String deliveryMan) {
        if (driver.findElements(OPEN_BS_MENU).isEmpty()) clickOndeliveryman();

        WebElement search = uiWait().until(ExpectedConditions.visibilityOfElementLocated(OPEN_BS_SEARCH));
        search.clear();
        search.sendKeys(deliveryMan);

        WebElement menu = uiWait().until(ExpectedConditions.visibilityOfElementLocated(OPEN_BS_MENU));
        WebElement optionSpan = uiWait().until(
            ExpectedConditions.elementToBeClickable(menu.findElement(optionByExactText(deliveryMan)))
        );
        optionSpan.findElement(By.xpath("./ancestor::a[1]")).click();

        // verify selection (no dependent for this one)
        waitForSelectionOnButtonOrDependentEnabled("ddlDeliveryMan", deliveryMan, null, 10);
        uiWait().until(ExpectedConditions.invisibilityOfElementLocated(OPEN_BS_MENU));
        closeAnyAlert(1);

        // JS safety net in case UI text is lazy
        try {
            ((JavascriptExecutor) driver).executeScript(
                "var sel=arguments[0], txt=arguments[1];" +
                "for (var i=0;i<sel.options.length;i++){" +
                " if(sel.options[i].text.trim().toLowerCase()===txt.trim().toLowerCase()){" +
                "   sel.selectedIndex=i; sel.dispatchEvent(new Event('change',{bubbles:true})); break; }}",
                deliveryManSelect, deliveryMan
            );
        } catch (Exception ignored) {}
    }

    // ---------- Party ----------
    @FindBy(xpath = "//button[@data-id='ddlParty']")
    private WebElement partyDropdown;

    public void clickOnPartyDropdown() {
        closeAnyAlert(1);
        scrollIntoView(partyDropdown);
        uiWait().until(ExpectedConditions.elementToBeClickable(partyDropdown)).click();
        uiWait().until(ExpectedConditions.visibilityOfElementLocated(OPEN_BS_MENU));
    }

    public void enterPartyInSearchBox(String party) {
        typeInActiveSearchAndEnter(party);
        waitForSelectionOnButtonOrDependentEnabled("ddlParty", party, null, 10);
        uiWait().until(ExpectedConditions.invisibilityOfElementLocated(OPEN_BS_MENU));
        closeAnyAlert(1);
        tinyPause(300); // give the UI a beat to populate dependent fields
    }

    // ---------- Date / Challan ----------
    @FindBy(id = "Deldate")
    private WebElement dateField;

    public void enterDate(WebDriver driver, String date) {
        closeAnyAlert(1);
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].value='';", dateField);
        js.executeScript(
            "arguments[0].value=arguments[1]; arguments[0].dispatchEvent(new Event('change'));",
            dateField, date
        );
        closeAnyAlert(1);
    }

    @FindBy(id = "txtChallanNo")
    private WebElement challanNoField;

    public void enterChallanNo(String challanNo) {
        closeAnyAlert(1);
        challanNoField.clear();
        challanNoField.sendKeys(challanNo);
        closeAnyAlert(1);
    }

    // ---------- Area ----------
    @FindBy(xpath = "//button[@data-id='ddlArea']")
    private WebElement areaDropdown;

    public void clickOnAreaDropdown() {
        closeAnyAlert(1);
        scrollIntoView(areaDropdown);
        uiWait().until(ExpectedConditions.elementToBeClickable(areaDropdown)).click();
        uiWait().until(ExpectedConditions.visibilityOfElementLocated(OPEN_BS_MENU));
    }

    public void enterAreaInSearchBox(String area) {
        typeInActiveSearchAndEnter(area);
        waitForSelectionOnButtonOrDependentEnabled("ddlArea", area, null, 10);
        uiWait().until(ExpectedConditions.invisibilityOfElementLocated(OPEN_BS_MENU));
        closeAnyAlert(1);
        tinyPause(300);
    }

    // ---------- Product ----------
    @FindBy(xpath = "//button[@data-id='ddlProduct']")
    private WebElement productDropdown;

    public void clickOnProductDropdown() {
        closeAnyAlert(1);
        scrollIntoView(productDropdown);
        uiWait().until(ExpectedConditions.elementToBeClickable(productDropdown)).click();
        uiWait().until(ExpectedConditions.visibilityOfElementLocated(OPEN_BS_MENU));
    }

    public void clickonPorduct() {
        final String productText = "19 KG(COM)";
        if (driver.findElements(OPEN_BS_MENU).isEmpty()) clickOnProductDropdown();

        try {
            WebElement search = uiWait().until(ExpectedConditions.visibilityOfElementLocated(OPEN_BS_SEARCH));
            search.clear();
            search.sendKeys(productText);
        } catch (Exception ignored) {}

        WebElement menu = uiWait().until(ExpectedConditions.visibilityOfElementLocated(OPEN_BS_MENU));
        WebElement optionSpan = uiWait().until(
            ExpectedConditions.elementToBeClickable(menu.findElement(optionByExactText(productText)))
        );
        optionSpan.findElement(By.xpath("./ancestor::a[1]")).click();

        waitForSelectionOnButtonOrDependentEnabled("ddlProduct", productText, null, 10);
        uiWait().until(ExpectedConditions.invisibilityOfElementLocated(OPEN_BS_MENU));
        closeAnyAlert(1);
        tinyPause(300);
    }

    // ---------- Quantities ----------
    @FindBy(id = "txtFullQty")
    private WebElement quantity;

    public void enterQty(String qty) {
        closeAnyAlert(1);
        waitEnabled(quantity, 10);
        try {
            quantity.clear();
            quantity.sendKeys(qty);
        } catch (UnhandledAlertException e) {
            closeAnyAlert(3);
            quantity.clear();
            quantity.sendKeys(qty);
        }
        closeAnyAlert(1);
    }

    @FindBy(id = "txtEmptyCylRecived")
    private WebElement emptyCyl;

    public void enterEmpty(String emp) {
        closeAnyAlert(1);
        waitEnabled(emptyCyl, 10);
        try {
            emptyCyl.clear();
            emptyCyl.sendKeys(emp);
        } catch (UnhandledAlertException e) {
            closeAnyAlert(3);
            emptyCyl.clear();
            emptyCyl.sendKeys(emp);
        }
        closeAnyAlert(1);
    }

    // ---------- Mode of Payment ----------
    @FindBy(xpath = "//button[@data-id='ddlPaymentMode']")
    private WebElement modofPay; // may be null/hidden on some builds

    private WebElement getPaymentModeButton() {
        By c1 = By.xpath("//button[@data-id='ddlPaymentMode']");
        By c2 = By.xpath("//select[@id='ddlPaymentMode']/following-sibling::*[contains(@class,'bootstrap-select')]//button");
        By c3 = By.xpath("//label[contains(.,'Mode of Payment') or contains(.,'Payment Mode')]/following::div[contains(@class,'bootstrap-select')][1]//button");
        By c4 = By.xpath("(//div[contains(@class,'bootstrap-select')]//button)[last()]");
        WebElement btn = findVisible(c1, c2, c3, c4);
        if (btn == null) throw new org.openqa.selenium.NoSuchElementException("Payment Mode dropdown button not found.");
        return btn;
    }

    public void clickmodOfPay() {
        closeAnyAlert(1);
        WebElement btn = getPaymentModeButton();
        scrollIntoView(btn);
        try { uiWait().until(ExpectedConditions.elementToBeClickable(btn)).click(); }
        catch (Exception e) { ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn); }
        uiWait().until(ExpectedConditions.visibilityOfElementLocated(OPEN_BS_MENU));
    }

    public void selectOnModeOfPayment(String mode) {
        if (driver.findElements(OPEN_BS_MENU).isEmpty()) clickmodOfPay();

        try { typeInActiveSearchAndEnter(mode); }
        catch (Exception e) {
            WebElement menu = uiWait().until(ExpectedConditions.visibilityOfElementLocated(OPEN_BS_MENU));
            WebElement optionSpan = uiWait().until(
                ExpectedConditions.elementToBeClickable(menu.findElement(optionByExactText(mode)))
            );
            optionSpan.findElement(By.xpath("./ancestor::a[1]")).click();
        }

        // If selecting CASH, the cash textbox should become enabled – use that as success signal.
        WebElement dependent = mode != null && mode.trim().equalsIgnoreCase("CASH") ? entercash : null;
        waitForSelectionOnButtonOrDependentEnabled("ddlPaymentMode", mode, dependent, 12);
        uiWait().until(ExpectedConditions.invisibilityOfElementLocated(OPEN_BS_MENU));
        closeAnyAlert(1);
        tinyPause(300);
    }

    // ---------- Cash / Submit ----------
    @FindBy(id = "txtCashAmount")
    private WebElement entercash;

    public void enterOntheCash(String cash) {
        closeAnyAlert(1);
        scrollIntoView(entercash);
        // Wait until enabled (app often enables it only after mode = CASH)
        waitEnabled(entercash, 12);

        try {
            // remove readonly/disabled if stubborn
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].removeAttribute('readonly'); arguments[0].removeAttribute('disabled');", entercash);

            // clear reliably
            try { entercash.clear(); } catch (Exception ignored) {}
            entercash.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            entercash.sendKeys(Keys.DELETE);
            ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", entercash);

            // type
            entercash.sendKeys(cash);
        } catch (UnhandledAlertException e) {
            closeAnyAlert(3);
            entercash.sendKeys(cash);
        }
        closeAnyAlert(1);
    }

    @FindBy(id="btnSubmit")
    private WebElement submitbutton;

    public void clickOnsubmitButton() { submitbutton.click(); }    

//Wait for and accept alert(s)
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
