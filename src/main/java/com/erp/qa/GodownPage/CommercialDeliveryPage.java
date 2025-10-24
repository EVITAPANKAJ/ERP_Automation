package com.erp.qa.GodownPage;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;

import com.erp.qa.pages.BasePage;

public class CommercialDeliveryPage extends BasePage {

    public CommercialDeliveryPage(WebDriver driver) {
        super(driver);
    }

    /* -------- utils -------- */
    private static final Duration TIMEOUT = Duration.ofSeconds(15);

    private WebDriverWait getWait() {
        return new WebDriverWait(driver, TIMEOUT);
    }

    private void scrollIntoView(WebElement el) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
    }

    private void setSelectByVisibleTextJS(WebElement nativeSelect, String visibleText) {
        String js =
            "var sel=arguments[0], txt=arguments[1].trim();" +
            "for (var i=0;i<sel.options.length;i++) {" +
            "  if (sel.options[i].text.trim()===txt) { sel.selectedIndex=i;" +
            "    sel.dispatchEvent(new Event('change',{bubbles:true})); return true; } }" +
            "return false;";
        Boolean ok = (Boolean) ((JavascriptExecutor) driver).executeScript(js, nativeSelect, visibleText);
        if (ok == null || !ok) {
            throw new NoSuchElementException("Option not found: " + visibleText);
        }
        // if jQuery + bootstrap-select are present, refresh/render
        String refresh =
            "try{ if(window.jQuery){ var $=window.jQuery;" +
            " if($(arguments[0]).selectpicker){ $(arguments[0]).selectpicker('refresh'); $(arguments[0]).selectpicker('render'); } } }catch(e){}";
        ((JavascriptExecutor) driver).executeScript(refresh, nativeSelect);
        // verify selected text
        String read = "var s=arguments[0]; return s.options[s.selectedIndex].text.trim();";
        String actual = (String) ((JavascriptExecutor) driver).executeScript(read, nativeSelect);
        if (!visibleText.equals(actual)) {
            throw new IllegalStateException("Select mismatch. Expected: " + visibleText + " but was: " + actual);
        }
    }

    /* -------- page elements -------- */

    @FindBy(xpath = "//*[@id='menuGodowntrn']/ul/li[6]/a")
    private WebElement commercialDeliveryLink;

    public void clickOnCommercialDelivery() {
        getWait().until(ExpectedConditions.elementToBeClickable(commercialDeliveryLink)).click();
    }

    @FindBy(id = "datepicker")
    private WebElement dateField;

    public void enterDate(String date) {
        WebElement el = getWait().until(ExpectedConditions.visibilityOf(dateField));
        scrollIntoView(el);
        el.clear();
        el.sendKeys(date);
        el.sendKeys(Keys.TAB);
    }

    // Native select for Godown
    @FindBy(id = "ddlGodownID")
    private WebElement godownSelect;

    /** Prefer selecting by **visible text** for stability */
    public void selectGodownByText(String godownName) {
        WebElement el = getWait().until(ExpectedConditions.visibilityOf(godownSelect));
        scrollIntoView(el);
        try {
            new Select(el).selectByVisibleText(godownName);
        } catch (NoSuchElementException ignore) {
            // fallback to JS in case plugin wraps it oddly
            setSelectByVisibleTextJS(el, godownName);
        }
    }

    /** If you really need index (not recommended), use this: */
    public void selectGodownByIndex(int index) {
        WebElement el = getWait().until(ExpectedConditions.visibilityOf(godownSelect));
        scrollIntoView(el);
        new Select(el).selectByIndex(index);
    }

    // Bootstrap-Select controls (native <select> elements)
    // The page shows a button with data-id='ddlDeliveryMan', but the real control is <select id="ddlDeliveryMan">.
    @FindBy(id = "ddlDeliveryMan")
    private WebElement deliveryManSelect;

    public void selectDeliveryMan(String name) {
        WebElement el = getWait().until(ExpectedConditions.presenceOfElementLocated(By.id("ddlDeliveryMan")));
        scrollIntoView(el);
        setSelectByVisibleTextJS(el, name);
    }

    @FindBy(id = "ddlProductType")
    private WebElement productTypeSelect;

    public void selectProductType(String productType) {
        WebElement el = getWait().until(ExpectedConditions.presenceOfElementLocated(By.id("ddlProductType")));
        scrollIntoView(el);
        setSelectByVisibleTextJS(el, productType);
    }

    @FindBy(id = "txtFullCylinder")
    private WebElement fullCylinder;

    public void enterFullCylinder(String fullCyl) {
        WebElement el = getWait().until(ExpectedConditions.visibilityOf(fullCylinder));
        scrollIntoView(el);       
        el.sendKeys(fullCyl);
    }
    @FindBy(id = "txtEmptyCylinder")
    private WebElement emptyCylinder;
    public void enterEmptyCylinder(String emptyCyl) {
		WebElement el = getWait().until(ExpectedConditions.visibilityOf(emptyCylinder));
		scrollIntoView(el);       
		el.sendKeys(emptyCyl);
	}
    @FindBy(id = "txtSV")
    private WebElement sv;
    public void enterSV(String svAmt) {
    			WebElement el = getWait().until(ExpectedConditions.visibilityOf(sv));
    			scrollIntoView(el);
    			el.sendKeys(svAmt);
    }
    @FindBy(id = "txtDBC")
    private WebElement dbc;
    public void enterDBC(String dbcAmt) {
				WebElement el = getWait().until(ExpectedConditions.visibilityOf(dbc));
				scrollIntoView(el);
				el.sendKeys(dbcAmt);
	}
    @FindBy(id="txtDefective")
    private WebElement defective;
    public void enterDefective(String defectiveAmt) {
    			WebElement el = getWait().until(ExpectedConditions.visibilityOf(defective));
    			scrollIntoView(el);
    			el.sendKeys(defectiveAmt);
    }
    @FindBy(id="txtLostCylinder")
    private WebElement lostCylinder;
    public void enterLostCylinder(String lostCyl) {
				WebElement el = getWait().until(ExpectedConditions.visibilityOf(lostCylinder));
				scrollIntoView(el);
				el.sendKeys(lostCyl);
	}
    @FindBy(id="txtretrnFullCylinder")
    private WebElement returnFullCylinder;
    public void enterReturnFullCylinder(String returnFullCyl) {
    					WebElement el = getWait().until(ExpectedConditions.visibilityOf(returnFullCylinder));
    					scrollIntoView(el);
    					el.sendKeys(returnFullCyl);
    }
    @FindBy(id="btnSubmit")
	private WebElement submitButton;
    
    private WebDriverWait getWait1() {
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
