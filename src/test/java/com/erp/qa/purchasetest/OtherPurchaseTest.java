package com.erp.qa.purchasetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;
import com.erp.qa.purchasepages.OtherPurchasePage;

public class OtherPurchaseTest extends BaseTest {
	private static Logger log = LogManager.getFormatterLogger(OtherPurchaseTest.class);

	@Test
	public void verifyOtherPurchaseLink() throws Exception {
		log.info("********** Starting Other Purchase Test **********");
		
		login("qatest", "Qatest@_2025");
		log.info("Login Successfully.");
		
		OtherPurchasePage opp=new OtherPurchasePage(driver);
		
		Thread.sleep(3000);
		pp.clickOnPurchaseLink();
		log.info("Purchase link clicked Successfully.");
		
		opp.clickOnOtherPurchaseLink();
		log.info("Other Purchase link clicked Successfully.");
		
		opp.FillDetails("INV54321", "Test narration for other purchase.", "PURCHASE : 300005", "LIGHTER", "50");
		log.info("Other Purchase details filled Successfully.");
		
		Thread.sleep(2000);
		log.info("********** Ending Other Purchase Test **********");
	}

}
