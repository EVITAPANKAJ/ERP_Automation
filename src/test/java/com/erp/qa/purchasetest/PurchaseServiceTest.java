package com.erp.qa.purchasetest;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;
import com.erp.qa.purchasepages.PurchaseServicePage;

public class PurchaseServiceTest extends BaseTest {
	private static Logger log = LogManager.getLogger(PurchaseServiceTest.class.getName());
	
	@Test
	public void verifyPurchaseLink() throws Exception {
		log.info("Starting verifyPurchaseLink test");
		login("qatest","Qatest@_2025");
		log.info("Login successful");
		Thread.sleep(3000);
		
		PurchaseServicePage psp= new PurchaseServicePage(driver);
		
		psp.clickOnPurchaseLink();
		log.info("Purchase link clicked successfully");
		psp.clickOnPurchaseServiceLink();
		Thread.sleep(2000);
		log.info("Purchase Service link clicked successfully");
		psp.FillDetails("INV12345","Test narration","MECHANIC CHECKING : 300009","10");
		log.info("Purchase Service details filled successfully");
		Thread.sleep(2000);
		log.info("Ending verifyPurchaseLink test");
}
}
