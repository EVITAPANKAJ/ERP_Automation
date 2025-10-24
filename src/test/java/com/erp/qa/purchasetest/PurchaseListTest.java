package com.erp.qa.purchasetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;

public class PurchaseListTest extends BaseTest{
	private static Logger log = LogManager.getFormatterLogger(PurchaseListTest.class);
	
	@Test
	public void PurchaseListtest() throws Exception{
		log.info("********** Starting Purchase List Test **********");
		lp.login("qatest","Qatest@_2025");
		log.info("Login Successfully.");
		Thread.sleep(3000);
		pp.clickOnPurchaseLink();
		log.info("Purchase link clicked Successfully.");
		plp.clickOnPurchaselist();
		log.info("Purchase List link clicked Successfully.");
		plp.FillDetails("04/09/2025","798798","36378788","398399","03/09/2025","03/09/2025","MH 02 BA 1234"
				,"14.2 KG (S-DOM)","88","1","2","1","66526");
		log.info("Purchase List details filled Successfully.");
		Thread.sleep(2000);
		log.info("********** Ending Purchase List Test **********");
	}

}
