package com.erp.qa.commsalepage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.erp.qa.pages.BasePage;

public class EmptyReceivedPage extends BasePage{
	
	public EmptyReceivedPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[@id='tb2']")
	private WebElement receivedEmpty;
	public void clickOnEmptyReceivedlink(){
	receivedEmpty.click();	
	}
	@FindBy(xpath="//*[@id=\"tab2\"]/div[1]/div[1]/div/div/div/button/div/div/div")
	private WebElement deliveryman;
	public void clickOnDeliveryMan() {
		deliveryman.click();
	}
	@FindBy(xpath="//div[@class='dropdown bootstrap-select form-control bs3 open']//input[@aria-label='Search']")
	private WebElement enterdeliveryman;
	public void enterOndeliveryman(String del) {
		enterdeliveryman.sendKeys(del);
		enterdeliveryman.sendKeys(Keys.ENTER);
	}
	@FindBy(xpath="//*[@id=\"tab2\"]/div[1]/div[2]/div/div/div/button/div/div/div")
	private WebElement partyname;
	public void clickOnPartyName() {
		partyname.click();
	}
	@FindBy(xpath="//div[@class='dropdown bootstrap-select form-control bs3 open']//input[@aria-label='Search']")
	private WebElement enterParty;
	public void enterOnPartyName(String party) {
		enterParty.sendKeys(party);
		enterParty.sendKeys(Keys.ENTER);
	}
	@FindBy(id="datetb2")
	private WebElement changedate;
	public void enterDate(WebDriver driver, String date) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    
	    // Clear any auto-filled date
	    js.executeScript("arguments[0].value='';", changedate);
	    
	    // Set the new date and trigger change event
	    js.executeScript("arguments[0].value='" + date + "'; arguments[0].dispatchEvent(new Event('change'));", changedate);
	}
	@FindBy(xpath="//*[@id=\"tab2\"]/div[1]/div[4]/div/div/div/button/div/div/div")
	private WebElement product;
	public void clickOnproduct() {
		product.click();
	}
	@FindBy(xpath="//div[@class='dropdown bootstrap-select form-control bs3 open']//input[@aria-label='Search']")
	private WebElement selProduct;
	public void enterProduct(String prod) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    // wait until the search input is visible and enabled
	    wait.until(ExpectedConditions.visibilityOf(selProduct));
		selProduct.sendKeys(prod);
		selProduct.sendKeys(Keys.ENTER);
	}
	@FindBy(id="txtEmptyCylRecivedtb2")
	private WebElement emptyqty;
	public void enterEmptyQty(String qty) {
		emptyqty.sendKeys(qty);
	}
	@FindBy(id="txtChallanNotb2")
	private WebElement challnNo;
	public void enterOnChallNo(String chall) {
		challnNo.sendKeys(chall);
	}
	@FindBy(xpath="//div[@class='dropdown bootstrap-select form-control bs3 dropup']//div[@class='filter-option-inner-inner'][normalize-space()='--Select--']")
	private WebElement modeOfPayment;
	public void clickModeOfpaymentdropdown() {
		modeOfPayment.click();
	}
	// --- Keep exactly these two locators ---

	// 1) The real <select> that Mode of Payment is bound to (visible or hidden)
	@FindBy(xpath = "//*[@id='tab2']//label[normalize-space()='Mode of Payment']/following::select[1]")
	private WebElement modeOfPaymentSelect;

	// 2) The bootstrap-select button (used only when UI fallback is needed)
	@FindBy(xpath = "//*[@id='tab2']//label[normalize-space()='Mode of Payment']" +
	                "/following::*[contains(@class,'bootstrap-select')][1]/button")
	private WebElement modeOfPaymentBtn;


	// --- Single robust method ---
	public void EnterOnModeOfPayment(String mode) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    String text = mode.trim();

	    // A) Fast path: if the native <select> is interactable, use Select API
	    try {
	        // ensure the <select> is present
	        wait.until(ExpectedConditions.presenceOfElementLocated(
	            By.xpath("//*[@id='tab2']//label[normalize-space()='Mode of Payment']/following::select[1]")));
	        if (modeOfPaymentSelect.isDisplayed() && modeOfPaymentSelect.isEnabled()) {
	            new org.openqa.selenium.support.ui.Select(modeOfPaymentSelect).selectByVisibleText(text);
	            return;
	        }
	    } catch (Exception ignored) {
	        // continue to JS / UI fallbacks
	    }

	    // B) If <select> is hidden by bootstrap-select, set it via JS and refresh the picker
	    try {
	        WebElement container = modeOfPaymentBtn.findElement(
	            By.xpath("./ancestor::div[contains(@class,'bootstrap-select')]"));
	        WebElement sel = container.findElement(By.xpath(".//select"));

	        Boolean matched = (Boolean) js.executeScript(
	            "const sel=arguments[0], t=arguments[1];" +
	            "for (let i=0;i<sel.options.length;i++) {" +
	            "  if (sel.options[i].text.trim() === t) {" +
	            "    sel.selectedIndex = i;" +
	            "    sel.dispatchEvent(new Event('change', {bubbles:true}));" +
	            "    try { if (window.jQuery && jQuery(sel).selectpicker) { jQuery(sel).selectpicker('refresh'); } } catch(e) {}" +
	            "    return true;" +
	            "  }" +
	            "}" +
	            "return false;", sel, text);

	        if (Boolean.TRUE.equals(matched)) return;
	    } catch (Exception ignored) {
	        // continue to UI fallback
	    }

	    // C) UI fallback: open the menu and click the option (no ENTER key!)
	    try {
	        // open dropdown
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(modeOfPaymentBtn)).click();
	        } catch (Exception e) {
	            js.executeScript("arguments[0].click();", modeOfPaymentBtn);
	        }

	        // container when open (supports both .open and .show)
	        By containerBy = By.cssSelector("#tab2 .bootstrap-select.open, #tab2 .bootstrap-select.show");
	        WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(containerBy));

	        // if there is a live-search box, type the text (do not cache this input with @FindBy)
	        List<WebElement> inputs = container.findElements(
	            By.cssSelector(".bs-searchbox input[aria-label='Search'], .bs-searchbox .form-control"));
	        if (!inputs.isEmpty()) {
	            WebElement input = inputs.get(0);
	            wait.until(ExpectedConditions.visibilityOf(input));
	            input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
	            input.sendKeys(Keys.DELETE);
	            input.sendKeys(text);
	            // wait until list is filtered
	            wait.until(d -> !container.findElements(By.cssSelector("li:not(.disabled):not(.d-none)")).isEmpty());
	        }

	        // exact match → otherwise click first enabled
	        By exact = By.xpath(".//div[contains(@class,'dropdown-menu')]//ul[contains(@class,'inner')]" +
	                            "//li[not(contains(@class,'disabled'))]/a[.//span[normalize-space()='" + text +
	                            "'] or normalize-space()='" + text + "']");
	        WebElement option = null;
	        List<WebElement> exactHits = container.findElements(exact);
	        if (!exactHits.isEmpty()) {
	            option = exactHits.get(0);
	        } else {
	            option = container.findElement(By.cssSelector(".dropdown-menu .inner li:not(.disabled) a"));
	        }

	        try { option.click(); } catch (Exception e) { js.executeScript("arguments[0].click();", option); }

	        wait.until(ExpectedConditions.invisibilityOfElementLocated(containerBy));
	    } catch (Exception e) {
	        String dom = String.valueOf(js.executeScript(
	            "var b=arguments[0]; var c=b.closest('.bootstrap-select'); return c?c.outerHTML:b.outerHTML;", modeOfPaymentBtn));
	        throw new RuntimeException("Mode of Payment selection failed for: " + text + "\nDOM:\n" + dom, e);
	    }
	}
	@FindBy(id="txtCashAmounttb2")
	private WebElement enetercash;
	public void enterOnCash(String cash) {
		enetercash.sendKeys(cash);
	}
	@FindBy(id="btnSubmit")
	private WebElement submitbutton;
	public void clickOnsubmitbutton() {
		submitbutton.click();
	}
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
