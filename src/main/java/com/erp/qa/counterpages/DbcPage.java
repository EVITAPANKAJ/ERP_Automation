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

public class DbcPage extends BasePage {
	
	public DbcPage(WebDriver driver) {
		super(driver);
		// Constructor
	}
	@FindBy(xpath="//*[@id=\"menuCounterSales\"]/ul/li[2]/a")
	WebElement dbcLink;
	public void clickOnDBCLink() {
		dbcLink.click();
	}
	@FindBy(id="txtConsumerNoSearch")
	WebElement consumerNo;
	public void enterConsumerNo(String consNo) {
		consumerNo.sendKeys(consNo);
	}
	@FindBy(id="btnGetConsumerData")
	WebElement getConsumerDataBtn;
	public void clickOnGetConsumerDataBtn() {
		getConsumerDataBtn.click();
	}
	@FindBy(id="txtInvoiceNo")
	WebElement invoiceNo;
	public void enterInvoiceNo(String invNo) {
		invoiceNo.sendKeys(invNo);
	}
	@FindBy(id="txtGSTIN")
	WebElement gstin;
	public void enterGSTIN(String gstinNo) {
		gstin.sendKeys(gstinNo);
	}
	@FindBy(id="txtDocNo")
	WebElement docNo;
	public void enterDocNo(String documentNo) {
		docNo.sendKeys(documentNo);
	}
	@FindBy(id="txtSVNo")
	WebElement svNo;
	public void enterSVNo(String svNumber) {
		svNo.sendKeys(svNumber);
	}
	@FindBy(id="txtRegistrationNo")
	WebElement registrationNo;
	public void enterRegistrationNo(String regNo) {
		registrationNo.sendKeys(regNo);
	}
	@FindBy(id="txtCity")
	WebElement city;
	public void enterCity(String cityName) {
		city.sendKeys(cityName);
	}
	@FindBy(id="txtBlueBookNo")
	WebElement blueBookNo;
	public void enterBlueBookNo(String blueBook) {
		blueBookNo.sendKeys(blueBook);
	}
	@FindBy(id="txtEmail")
	WebElement email;
	public void enterEmail(String emailId) {
		email.sendKeys(emailId);
	}
	@FindBy(id="txtProduct")
	WebElement productDropdown;
	public void EnterProduct(String product) {
		productDropdown.sendKeys(product);	
	}
	@FindBy(id="txtPrdQunatity")
	WebElement quantity;
	public void EnterQuantity(String qty) {
		quantity.clear();
		quantity.sendKeys(qty);
	}
	@FindBy(id="txtService")
	WebElement service;
	public void EnterService(String serviceName) {
		service.sendKeys(serviceName);
	}
	@FindBy(id="btnSubmit")
	WebElement submitButton;
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

	    @FindBy(xpath="//a[normalize-space()='Update DBC']")
	    WebElement updateNewConnectionLink;
	    public void clickOnUpdateDBCLink() {
	        updateNewConnectionLink.click();
	    }

	    @FindBy(id="txtMDLDocumentNo")
	    WebElement mdlDocumentNumber;
	    public void enterMDLDocumentNumber(String billNo) {
	        mdlDocumentNumber.sendKeys(billNo);
	    }

	
	public String FillDetails(String consNo,String invNo,String gstinNo,String documentNo,String svNumber,String regNo,
			String cityName,String blueBook,String emailId,String product,String qty,String serviceName) throws Exception{
		enterConsumerNo(consNo);
		clickOnGetConsumerDataBtn();
		enterInvoiceNo(invNo);
		enterGSTIN(gstinNo);
		enterDocNo(documentNo);
		enterSVNo(svNumber);
		enterRegistrationNo(regNo);
		enterCity(cityName);
		enterBlueBookNo(blueBook);
		enterEmail(emailId);
		EnterProduct(product);
		EnterQuantity(qty);
		EnterService(serviceName);
		clickonSubmitbutton();
		acceptAlert();
		acceptAlert();
		Thread.sleep(2000);
		return getBillNumber();
	}

	}
