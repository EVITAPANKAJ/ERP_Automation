package com.erp.qa.purchasetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;
import com.erp.qa.purchasepages.PurchasePage;

public class PurchaseTest extends BaseTest {
	private static Logger log = LogManager.getLogger(PurchaseTest.class.getName());
	
	@Test
	public void verifyPurchaseLink() throws Exception {
		log.info("Starting verifyPurchaseLink test");
		login("qatest","Qatest@_2025");
		log.info("Login successful");
		Thread.sleep(3000);
		
		PurchasePage pp=new PurchasePage(driver);
		
		pp.clickOnPurchaseLink();
		log.info("Purchase link clicked successfully");
		pp.clickOnPurchaseFormLink();
		log.info("Purchase Form link clicked successfully");
		pp.FillDetails("INV12345", "ERV67890", "PURCHASE : 300005", "14.2 KG (S-DOM)", "100", "10", "5", "10", "70380");
		log.info("Purchase Form details filled successfully");
		Thread.sleep(2000);
		log.info("Ending verifyPurchaseLink test");
	}
}
