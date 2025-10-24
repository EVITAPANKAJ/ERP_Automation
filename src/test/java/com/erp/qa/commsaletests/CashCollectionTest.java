package com.erp.qa.commsaletests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;
import com.erp.qa.countertests.BeyondSaleTest;

public class CashCollectionTest extends BaseTest{	
		private static Logger log = LogManager.getFormatterLogger(BeyondSaleTest.class);
			
			@Test
			public void verifyCommSaleLink() throws Exception {
				log.info("********** Starting test case: verifyCounterLink **********");
				lp.login("qatest","Qatest@_2025");
				log.info("Login successful");
				Thread.sleep(3000);
				cs.clickOnCommSaleLink();
				ccp.clickOnCashCollectionlink();
				ccp.clickonDeliverymandropdown();
				ccp.enterOndeliverymanname("DINESH");
				ccp.clickOnselectParty();
				ccp.enterParty("KAILASH HOTEL");
				ccp.enterOnchallanNumber("12344");
				ccp.enterAmount("2190");
				ccp.clickOnSubmit();
				ccp.acceptAlert();
				ccp.acceptAlert();
				Thread.sleep(2000);
		}
	}

