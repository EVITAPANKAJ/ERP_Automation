package com.erp.qa.purchasetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;
import com.erp.qa.purchasepages.OtherPurchaseListPage;

public class OtherPurchaseListTest extends BaseTest{
	private static Logger log = LogManager.getFormatterLogger(OtherPurchaseListTest.class);
	
	@Test
	public void verifyOtherPurchaseListTest() throws Exception{
		log.info("********** Starting Other Purchase List Test **********");
		
		login("qatest","Qatest@_2025");
		log.info("Login Successfully.");
		
		OtherPurchaseListPage oplp=new OtherPurchaseListPage(driver);
		
		Thread.sleep(3000);
		pp.clickOnPurchaseLink();
		log.info("Purchase link clicked Successfully.");
		
		oplp.clickOnotherpurchaselist();
		log.info("Other Purchase List link clicked Successfully.");
		
		oplp.FillDetails("01/09/2025","1002","12001","02/09/2025","Being Other Purchase","LIGHTER","92");
		log.info("Other Purchase List details filled Successfully.");
		
		Thread.sleep(2000);
		log.info("********** Ending Other Purchase List Test **********");
	}

}
