package com.erp.qa.countertests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;

public class BeyondSaleTest extends BaseTest{
	private static Logger log = LogManager.getFormatterLogger(BeyondSaleTest.class);
	
	@Test
	public void verifyCounterLink() throws Exception {
		log.info("********** Starting test case: verifyCounterLink **********");
		lp.login("qatest","Qatest@_2025");
		log.info("Login successful");
		Thread.sleep(3000);
		sv.clickOnCounterSalesLink();
		log.info("Clicked on Counter Sales link");
		bsp.clickOnBeyondSalesLink();
		log.info("Clicked on Beyond Sales link");		
		bsp.FillDetails("89898","12345","29AAACB2894D1ZV","Bangalore","john123@gmail.com","LIGHTER");
		log.info("Filled details in Beyond Sale form");
		Thread.sleep(3000);
				
	}

}
