package com.erp.qa.GodownTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;

public class AcceptedLoadTest extends BaseTest{
	private static Logger log = LogManager.getLogger(AcceptedLoadTest.class);
	
	@Test
	public void verifyAcceptedLoadTest()throws Exception {
		log.info("Starting test case: verifyAcceptedLoadTest");
		lp.login("qatest","Qatest@_2025");
		log.info("Login successful");
		Thread.sleep(3000);
		gp.clickOnGodown();
		log.info("Navigated to Godown section");
		alp.clickOnAcceptedload();
		alp.selectdate();
		alp.clickOnSeven();
		Thread.sleep(2000);
		alp.clickonsumt();
		alp.clickOnSearch("1678");
		alp.clickOnclickinv();
		alp.enterinvdate("06/10/2025");
		alp.selectsup();
		alp.SelectOnsupp();
		alp.enteraccount("PURCHASE : 300005");
		alp.enterSubtotal("66000");
		log.info("Entered all required details for accepted load");
		alp.clickOnSubmit();
		log.info("Accepted load process completed successfully");
	}
}
