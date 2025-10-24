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

public class TaoutPage extends BasePage {
	
	public TaoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//*[@id=\"menuCounterSales\"]/ul/li[4]/a")
	WebElement taoutLink;
	public void clickOnTaoutLink() {
		taoutLink.click();
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
	@FindBy(id="txtGSTIN")
	WebElement gstin;
	public void enterGSTIN(String gstNo) {
		gstin.sendKeys(gstNo);
	}
	@FindBy(id="txtDocNo")
	WebElement docNo;
	public void enterDocNo(String docNumber) {
		docNo.sendKeys(docNumber);
	}
	@FindBy(id="txtCity")
	WebElement city;
	public void enterCity(String cityName) {
		city.sendKeys(cityName);
	}
	@FindBy(xpath="//div[contains(text(),'Select State')]")
	WebElement stateDropdown;
	public void selectState() {
		stateDropdown.click();
	}
	@FindBy(xpath="//span[normalize-space()='MAHARASHTRA']")
	WebElement state;
	public void searchState() {
		state.click();
	}
	@FindBy(id="txtPostDistributorCode")
	WebElement postDistributorCode;
	public void enterPostDistributorCode(String postCode) {
		postDistributorCode.sendKeys(postCode);
	}
	@FindBy(id="txtEmail")
	WebElement email;
	public void enterEmail(String emailId) {
		email.sendKeys(emailId);
	}
	@FindBy(id="btnSubmit")
	WebElement submitBtn;
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

    @FindBy(xpath="//a[normalize-space()='Update TA OUT']")
    WebElement updateTAOUTLink;
    public void clickOnUpdateTAOUTLink() {
    	updateTAOUTLink.click();
    }

    @FindBy(id="txtMDLDocumentNo")
    WebElement mdlDocumentNumber;
    public void enterMDLDocumentNumber(String billNo) {
        mdlDocumentNumber.sendKeys(billNo);
    }
    @FindBy(id="btnMDLGet")
    WebElement mdlGetButton;
    public void clickOnMDLGetButton() {
		mdlGetButton.click();
	}
	
    public String FillDetails(String consNo,String gstNo,String docNumber,String cityName,String postCode,String emailId) throws Exception{
		enterConsumerNo(consNo);
		clickOnGetConsumerDataBtn();
		enterGSTIN(gstNo);
		enterDocNo(docNumber);
		enterCity(cityName);
		selectState();
		searchState();
		enterPostDistributorCode(postCode);
		enterEmail(emailId);			
		clickonSubmitbutton();
		acceptAlert();
		acceptAlert();
		
		 return getBillNumber();
	}

	public void updateTAOUTLink() {
		// TODO Auto-generated method stub
		
	}
	

}
