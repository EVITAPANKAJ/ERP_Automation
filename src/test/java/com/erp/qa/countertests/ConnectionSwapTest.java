package com.erp.qa.countertests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;

public class ConnectionSwapTest extends BaseTest {
	private static Logger log = LogManager.getFormatterLogger(ConnectionSwapTest.class.getName());
	
	@Test
	public void verifyCounterLink() throws Exception {
		log.info("Starting test: verifyCounterLink");
		lp.login("qatest","Qatest@_2025");
		Thread.sleep(3000);
		sv.clickOnCounterSalesLink();
		log.info("Counter Sales link clicked successfully.");
		csp.clickOnConnectionSwapLink();
		log.info("Connection Swap link clicked successfully.");
		csp.FillDetails("89898");
		log.info("Details filled in Connection Swap form successfully.");
	}

}
