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

public class TvinPage extends BasePage {
	
	public TvinPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//*[@id=\"menuCounterSales\"]/ul/li[5]/a")
	WebElement tvinLink;
	public void clickOnTvinLink() {
		tvinLink.click();
	}
	@FindBy(id="txtInvoiceNo")
	WebElement invoiceNo;
	public void enterInvoiceNo(String invNo) {
		invoiceNo.sendKeys(invNo);
	}
	@FindBy(id="txtGSTIN")
	WebElement gstin;
	public void enterGstin(String gst) {
		gstin.sendKeys(gst);
	}
	@FindBy(id="txtDocNo")
	WebElement docNo;
	public void enterDocNo(String doc) {
		docNo.sendKeys(doc);
	}
	@FindBy(id="txtSVNo")
	WebElement svNo;
	public void enterSvNo(String sv) {
		svNo.sendKeys(sv);
	}
	@FindBy(id="txtConsumerNo")
	WebElement consumerNo;
	public void enterConsumerNo(String consNo) {
		consumerNo.sendKeys(consNo);
	}
	@FindBy(id="txtRegistrationNo")
	WebElement registrationNo;
	public void enterRegistrationNo(String regNo) {
		registrationNo.sendKeys(regNo);
	}
	@FindBy(id="txtConsumerName")
	WebElement consumerName;
	public void enterConsumerName(String consName) {
		consumerName.sendKeys(consName);
	}
	@FindBy(id="txtAddress")
	WebElement address;
	public void enterAddress(String addr) {
		address.sendKeys(addr);
	}
	@FindBy(id="txtCity")
	WebElement city;
	public void enterCity(String cty) {
		city.sendKeys(cty);
	}
	@FindBy(id="txtContact")
	WebElement contact;
	public void enterContact(String cont) {
		contact.sendKeys(cont);
	}
	@FindBy(id="txtEmail")
	WebElement email;
	public void enterEmail(String mail) {
		email.sendKeys(mail);
	}
	@FindBy(id="txtPreDistributerCode")
	WebElement preDistributerCode;
	public void enterPreDistributerCode(String preCode) {
		preDistributerCode.sendKeys(preCode);
	}
	@FindBy(id="txtPreConsumerNo")
	WebElement preConsumerNo;
	public void enterPreConsumerNo(String preConsNo) {
		preConsumerNo.sendKeys(preConsNo);
	}
	@FindBy(id="txtPreOilCompany")
	WebElement preOilCompany;
	public void enterPreOilCompany(String preOilComp) {
		preOilCompany.sendKeys(preOilComp);
	}
	@FindBy(id="txtBlueBookNo")
	WebElement blueBookNo;
	public void enterBlueBookNo(String blueBook) {
		blueBookNo.sendKeys(blueBook);
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

    @FindBy(xpath="//a[normalize-space()='Update TVIN']")
    WebElement updateNewConnectionLink;
    public void clickOnUpdateTVINLink() {
        updateNewConnectionLink.click();
    }

    @FindBy(id="txtUMDLDocumentNo")
    WebElement mdlDocumentNumber;
    public void enterMDLDocumentNumber(String billNo) {
        mdlDocumentNumber.sendKeys(billNo);
    }
    @FindBy(id="btnUMDLGet")
    WebElement mdlGetButton;
    public void clickOnMDLGetButton() {
		mdlGetButton.click();
	}
    public String FillDetails(String invNo,String gst,String doc,String sv,String consNo,String regNo,String consName,
			String addr,String cty,String cont,String mail,String preCode,String preConsNo,String preOilComp,String blueBook) {
		enterInvoiceNo(invNo);
		enterGstin(gst);
		enterDocNo(doc);
		enterSvNo(sv);
		enterConsumerNo(consNo);
		enterRegistrationNo(regNo);
		enterConsumerName(consName);
		enterAddress(addr);
		enterCity(cty);
		enterContact(cont);
		enterEmail(mail);
		enterPreDistributerCode(preCode);
		enterPreConsumerNo(preConsNo);
		enterPreOilCompany(preOilComp);
		enterBlueBookNo(blueBook);
		
		clickonSubmitbutton();
		acceptAlert();
		acceptAlert();
		
		return getBillNumber();
		
	}

}
