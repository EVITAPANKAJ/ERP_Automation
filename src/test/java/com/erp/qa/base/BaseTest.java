package com.erp.qa.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.erp.qa.driverfactry.DriverSetup;
import com.erp.qa.pages.LoginPage;
import com.erp.qa.GodownPage.AcceptedLoadPage;
import com.erp.qa.GodownPage.CommercialDeliveryPage;
import com.erp.qa.GodownPage.DomesticDeliveryPage;
import com.erp.qa.GodownPage.ERVPage;
import com.erp.qa.GodownPage.UpdateAcceptedLoadPage;
import com.erp.qa.GodownPage.UpdateCommDeliveryPage;
import com.erp.qa.GodownPage.UpdateERVPage;
import com.erp.qa.GodownPage.XMIListPage;
import com.erp.qa.commsalepage.CashCollectionPage;
import com.erp.qa.commsalepage.CommSalePage;
import com.erp.qa.commsalepage.CommercialSaleListPage;
import com.erp.qa.commsalepage.EmptyReceivedPage;

public class BaseTest {

	protected WebDriver driver;
	protected Logger log;

	// Page object references
	public LoginPage lp;
	public com.erp.qa.purchasepages.PurchasePage pp;
	public com.erp.qa.purchasepages.PurchaseListPage plp;
	public com.erp.qa.purchasepages.PurchaseServicePage psp;
	public com.erp.qa.purchasepages.PurchaseServiceLIstPage pslp;
	public com.erp.qa.purchasepages.OtherPurchasePage opp;
	public com.erp.qa.purchasepages.OtherPurchaseListPage oplp;
	public com.erp.qa.counterpages.SvPage sv;
	public com.erp.qa.counterpages.DbcPage dbc;
	public com.erp.qa.counterpages.TainPage tain;
	public com.erp.qa.counterpages.TaoutPage taout;
	public com.erp.qa.counterpages.TvinPage tvin;
	public com.erp.qa.counterpages.BeyondSalePage bsp;
	public com.erp.qa.counterpages.ConnectionSwapPage csp;
	public com.erp.qa.counterpages.NameChangePage ncp;
	public com.erp.qa.counterpages.EquipmentRecoveryPage erp;
	public com.erp.qa.tvoutpages.PartialTvoutPage ptv;
	public com.erp.qa.tvoutpages.PartialTvOutListPage ptvl;
	public com.erp.qa.tvoutpages.TvOutPage tvp;
	public com.erp.qa.tvoutpages.TvOutListPage tvlp;
	public com.erp.qa.GodownPage.PartialPurchasePage gp;
	public AcceptedLoadPage alp;
	public UpdateAcceptedLoadPage ualp;
	public ERVPage ep;
	public UpdateERVPage uep;
	public CommercialDeliveryPage cdp;
	public UpdateCommDeliveryPage ucdp;
	public XMIListPage xmip;
	public DomesticDeliveryPage ddp;
	public CommSalePage cs;
	public EmptyReceivedPage ce;
	public CashCollectionPage ccp;
	public CommercialSaleListPage cslp;

	// ----------------------------- SETUP -----------------------------
	@BeforeMethod
	public void setUp(ITestResult result) {
		// Put test name in ThreadContext
		String testClassName = result.getTestClass().getName();
		ThreadContext.put("testClass", testClassName);

		log = LogManager.getLogger(testClassName);
		log.info("===== Starting Test Setup for: {} =====", testClassName);

		driver = DriverSetup.setupBrowser("chrome");
		driver.get("https://qa.mygasagency.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

		log.info("Browser launched and navigated to application.");

		// Initialize Page Objects
		lp = new LoginPage(driver);
		pp = new com.erp.qa.purchasepages.PurchasePage(driver);
		plp = new com.erp.qa.purchasepages.PurchaseListPage(driver);
		psp = new com.erp.qa.purchasepages.PurchaseServicePage(driver);
		opp = new com.erp.qa.purchasepages.OtherPurchasePage(driver);
		pslp = new com.erp.qa.purchasepages.PurchaseServiceLIstPage(driver);
		oplp = new com.erp.qa.purchasepages.OtherPurchaseListPage(driver);
		sv = new com.erp.qa.counterpages.SvPage(driver);
		dbc = new com.erp.qa.counterpages.DbcPage(driver);
		tain = new com.erp.qa.counterpages.TainPage(driver);
		taout = new com.erp.qa.counterpages.TaoutPage(driver);
		tvin = new com.erp.qa.counterpages.TvinPage(driver);
		bsp = new com.erp.qa.counterpages.BeyondSalePage(driver);
		csp = new com.erp.qa.counterpages.ConnectionSwapPage(driver);
		ncp = new com.erp.qa.counterpages.NameChangePage(driver);
		erp = new com.erp.qa.counterpages.EquipmentRecoveryPage(driver);
		ptv = new com.erp.qa.tvoutpages.PartialTvoutPage(driver);
		ptvl = new com.erp.qa.tvoutpages.PartialTvOutListPage(driver);
		tvp = new com.erp.qa.tvoutpages.TvOutPage(driver);
		tvlp = new com.erp.qa.tvoutpages.TvOutListPage(driver);
		gp = new com.erp.qa.GodownPage.PartialPurchasePage(driver);
		alp = new AcceptedLoadPage(driver);
		ualp = new UpdateAcceptedLoadPage(driver);
		ep = new ERVPage(driver);
		uep = new UpdateERVPage(driver);
		cdp = new CommercialDeliveryPage(driver);
		ucdp = new UpdateCommDeliveryPage(driver);
		xmip = new XMIListPage(driver);
		ddp = new DomesticDeliveryPage(driver);
		cs = new CommSalePage(driver);
		ce= new EmptyReceivedPage(driver);
		ccp= new CashCollectionPage(driver);
		cslp=new CommercialSaleListPage(driver);

		log.info("All Page Objects initialized successfully.");
	}

	// ----------------------------- ALERT + SCREENSHOT HANDLER
	// -----------------------------
	public void handleErrorAlertAndScreenshot(WebElement errorElement, String screenshotName) {
		try {
			// Handle alert
			try {
				Alert alert = driver.switchTo().alert();
				log.warn("Alert detected: {}", alert.getText());
				alert.accept();
			} catch (NoAlertPresentException e) {
				log.info("No alert present.");
			}

			// Highlight problematic element
			if (errorElement != null) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].style.border='3px solid red'", errorElement);
				js.executeScript("arguments[0].style.backgroundColor='yellow'", errorElement);
				log.info("Highlighted problematic element.");
			}

			// Capture screenshot
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String filePath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timestamp
					+ ".png";
			FileHandler.copy(srcFile, new File(filePath));

			log.info("Screenshot saved at: {}", filePath);

		} catch (IOException e) {
			log.error("Screenshot save failed | {}", e.getMessage());
		} catch (Exception e) {
			log.error("Error in handleErrorAlertAndScreenshot | {}", e.getMessage());
		}
	}

	// ----------------------------- TEARDOWN -----------------------------
	@AfterMethod
	public void tearDown(ITestResult result) {
		try {
			if (driver != null) {
				driver.quit();
				log.info("Browser closed successfully.");
			}

			switch (result.getStatus()) {
			case ITestResult.SUCCESS:
				log.info("✅ Test Passed: {}", result.getMethod().getMethodName());
				break;

			case ITestResult.FAILURE:
				// ❌ Short one-line log without stack trace
				Throwable throwable = result.getThrowable();
				String errorMsg = "Unknown error";
				if (throwable != null && throwable.getMessage() != null) {
					// remove all newlines & extra spaces
					errorMsg = throwable.getMessage().replaceAll("\\r?\\n", " ").replaceAll("\\s+", " ").trim();
				}
				log.error("❌ Test Failed: {} | {}", result.getMethod().getMethodName(), errorMsg);

			case ITestResult.SKIP:
				log.warn("⚠️ Test Skipped: {}", result.getMethod().getMethodName());
				break;
			}

		} catch (Exception e) {
			log.error("Error during teardown | {}", e.getMessage());
		} finally {
			ThreadContext.clearAll();
			log.info("========== Test execution completed ==========");
		}
	}
}
