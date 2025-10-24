package com.erp.qa.counterpages;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.qa.pages.BasePage;

public class EquipmentRecoveryPage extends BasePage {

    public EquipmentRecoveryPage(WebDriver driver) {
        super(driver);
    }

    // ---------- Locators ----------
    @FindBy(xpath = "//*[@id='menuCounterSales']/ul/li[10]/a")
    WebElement equipmentRecoveryLink;

    @FindBy(xpath = "//button[@id='NewEQP']")
    WebElement newEquipmentButton;

    @FindBy(id = "txtConsumerSearch")
    WebElement consumerSearchBox;

    @FindBy(xpath = "//button[normalize-space()='Get Details']")
    WebElement getDetailsButton;

    @FindBy(xpath = "//option[@value='Lost']")
    WebElement equipmentTypeDropdown;

    @FindBy(xpath = "//div[contains(text(),'--Select--')]")
    WebElement equipmentDropdown;

    @FindBy(xpath = "//span[normalize-space()='BPC DPR']")
    WebElement equipment;

    @FindBy(id = "txtNewEquipmentcompanyname")
    WebElement newEquipmentCompanyName;

    @FindBy(id = "txtNewManufacturingDate")
    WebElement newManufacturingDate;

    @FindBy(id = "txtNewEquipmentSrNo")
    WebElement newEquipmentSrNo;

    @FindBy(id = "txtNewEquipmentIssueDate")
    WebElement newEquipmentIssueDate;

    @FindBy(id = "txtService")
    WebElement selectService;

    @FindBy(id = "txtSrvQunatity")
    WebElement serviceQuantity;

    @FindBy(id = "txtSrvUnitCost")
    WebElement serviceUnitCost;

    @FindBy(xpath = "//button[@id='Add']")
    WebElement saveButton;

    @FindBy(xpath = "//button[normalize-space()='Edit']")
    WebElement editButton;

    @FindBy(xpath = "//button[normalize-space()='Delete']")
    WebElement deleteButton;
    
    @FindBy(xpath="//button[normalize-space()='Yes, Deleted it!']")
    WebElement confirmDeleteButton;

    // ---------- Utility methods ----------

    private void safeClick(WebElement el) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        wait.until(ExpectedConditions.visibilityOf(el));
        wait.until(ExpectedConditions.elementToBeClickable(el));

        try {
            el.click();
        } catch (ElementClickInterceptedException e) {
            try {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(
                        By.cssSelector(".modal-backdrop, .spinner, .loading, .block-ui, .blockOverlay")));
            } catch (Exception ignored) {}
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
        }
    }

    private void clearAndType(WebElement el, String text) {
        try {
            el.sendKeys(Keys.CONTROL, "a");
            el.sendKeys(Keys.DELETE);
        } catch (Exception ignore) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", el);
        }
        if (el.getAttribute("value") != null && !el.getAttribute("value").isEmpty()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", el);
        }
        el.sendKeys(text);
    }

    // ---------- Alert handling utilities ----------

    private boolean acceptAlertIfPresent(Duration waitFor) {
        try {
            Alert alert = new WebDriverWait(driver, waitFor).until(ExpectedConditions.alertIsPresent());
            String text = alert.getText();
            System.out.println("Alert text: " + text);
            alert.accept();
            System.out.println("Alert accepted.");
            return true;
        } catch (TimeoutException e) {
            return false; // no alert within wait
        }
    }

    private void acceptAllAlerts(Duration gapWait, Duration overallTimeout) {
        long end = System.nanoTime() + overallTimeout.toNanos();
        while (System.nanoTime() < end) {
            boolean gotOne = acceptAlertIfPresent(gapWait);
            if (!gotOne) break;
            try { Thread.sleep(300); } catch (InterruptedException ignored) {}
        }
    }

    private void resilientClick(WebElement el) {
        try {
            safeClick(el);
        } catch (UnhandledAlertException ua) {
            acceptAllAlerts(Duration.ofSeconds(1), Duration.ofSeconds(5));
            safeClick(el);
        }
    }

    // ---------- Diagnostics ----------

    private void dumpDiagnostics(String prefix) {
        String ts = String.valueOf(System.currentTimeMillis());
        String base = prefix + "_" + ts;
        try {
            if (driver instanceof TakesScreenshot) {
                File ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Files.copy(ss.toPath(), Paths.get(base + "_screenshot.png"));
            }
        } catch (Exception e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }

        try {
            String src = driver.getPageSource();
            Files.writeString(Paths.get(base + "_pagesource.html"), src);
        } catch (IOException e) {
            System.err.println("Failed to save page source: " + e.getMessage());
        }

        try {
            StringBuilder sb = new StringBuilder();
            List<LogEntry> logs = driver.manage().logs().get(LogType.BROWSER).getAll();
            for (LogEntry le : logs) {
                sb.append(new Date(le.getTimestamp())).append(" ").append(le.getLevel()).append(" ").append(le.getMessage()).append("\n");
            }
            Files.writeString(Paths.get(base + "_console.log"), sb.toString());
        } catch (Exception e) {
            System.err.println("Could not retrieve browser console logs: " + e.getMessage());
        }
    }

    // ---------- Wait utilities ----------

    private void waitForModalOpen() {
        int timeoutSeconds = 20;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        By modalBy = By.cssSelector("#myModal, .modal");

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(modalBy));
            wait.until(driver -> {
                List<WebElement> modals = driver.findElements(By.cssSelector(".modal.show, .modal.in"));
                for (WebElement m : modals) {
                    if (m.isDisplayed()) return true;
                }
                return false;
            });
        } catch (TimeoutException te) {
            dumpDiagnostics("modal_open_timeout");
            throw te;
        }
    }

    private void waitForConsumerDetailsLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.invisibilityOfElementLocated(
                        By.cssSelector(".spinner, .loading, .block-ui, .blockOverlay")));
    }

    // ---------- Actions ----------

    public void clickOnEquipmentRecoveryLink() {
        safeClick(equipmentRecoveryLink);
    }

    public void clickOnNewEquipmentButton() {
        safeClick(newEquipmentButton);
    }

    public void enterConsumerDetails(String consumer) {
        consumerSearchBox.sendKeys(consumer);
    }

    public void clickOnGetDetailsButton() {
        safeClick(getDetailsButton);
    }

    public void selectEquipmentType() {
        safeClick(equipmentTypeDropdown);
    }

    public void selectEquipment() {
        safeClick(equipmentDropdown);
    }

    public void searchEquipment() {
        safeClick(equipment);
    }

    public void enterNewEquipmentCompanyName(String companyName) {
        newEquipmentCompanyName.sendKeys(companyName);
    }

    public void enterNewManufacturingDate(String mfgDate) {
        clearAndType(newManufacturingDate, mfgDate);
    }

    public void enterNewEquipmentSrNo(String srNo) {
        newEquipmentSrNo.sendKeys(srNo);
    }

    public void enterNewEquipmentIssueDate(String issueDate) {
        clearAndType(newEquipmentIssueDate, issueDate);
    }

    public void enterService(String charge) {
        selectService.sendKeys(charge);
    }

    public void enterServiceQuantity(String qty) {
        serviceQuantity.clear();
        serviceQuantity.sendKeys(qty);
    }

    public void enterServiceUnitCost(String cost) {
        serviceUnitCost.clear();
        serviceUnitCost.sendKeys(cost);
    }

    public void clickOnSubmitButton() {
        resilientClick(saveButton);
    }

    public void clickOnEditButton() {
        resilientClick(editButton);
    }

    public void clickOnDeleteButton() {
        resilientClick(deleteButton);
    }
    
    public void clickOnConfirmDeleteButton() {
		resilientClick(confirmDeleteButton);
	}

    // ---------- Full workflow ----------
    public void FillDetails(String consumer, String companyName, String mfgDate, String srNo,
                            String issueDate, String charge, String qty, String cost) throws InterruptedException {

        clickOnNewEquipmentButton();
        waitForModalOpen();

        enterConsumerDetails(consumer);
        clickOnGetDetailsButton();
        waitForConsumerDetailsLoaded();

        selectEquipmentType();
        selectEquipment();
        searchEquipment();

        enterNewEquipmentCompanyName(companyName);
        enterNewManufacturingDate(mfgDate);
        enterNewEquipmentSrNo(srNo);
        enterNewEquipmentIssueDate(issueDate);

        enterService(charge);
        enterServiceQuantity(qty);
        enterServiceUnitCost(cost);

        // Save and handle alerts
        clickOnSubmitButton();
        acceptAllAlerts(Duration.ofSeconds(2), Duration.ofSeconds(15));

        // Wait for backend or modal to clear
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(
                        By.cssSelector(".modal-backdrop, .spinner, .loading, .block-ui, .blockOverlay")));

        // Delete flow
        clickOnDeleteButton();
        acceptAllAlerts(Duration.ofSeconds(2), Duration.ofSeconds(10));
        
        clickOnConfirmDeleteButton();
    }
}
