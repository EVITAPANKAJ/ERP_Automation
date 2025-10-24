package com.erp.qa.purchasetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;

public class PurchaseServiceListTest extends BaseTest{
	private static Logger log = LogManager.getFormatterLogger(PurchaseServiceListTest.class);
	
	@Test
	public void verifyPurchaseServiceListTest() throws Exception{
		log.info("********** Starting Purchase Service List Test **********");
	lp.login("qatest","Qatest@_2025");
	log.info("Login Successfully.");
	Thread.sleep(3000);
	pp.clickOnPurchaseLink();
	log.info("Purchase link clicked Successfully.");
	pslp.clickOnPurchaseService();
	log.info("Purchase Service List link clicked Successfully.");
	pslp.FillDetails("03/10/2025","289298","393484","04/10/2025","Being purchase services","DBTL AMNT : 400013",
			"20","210");
	log.info("Purchase Service List details filled Successfully.");
	Thread.sleep(2000);
	log.info("********** Ending Purchase Service List Test **********");
	
	
	}
}
