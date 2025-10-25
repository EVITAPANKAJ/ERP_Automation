package com.erp.qa.GodownTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.GodownPage.UpdateERVPage;
import com.erp.qa.base.BaseTest;

public class UpdateERVTest extends BaseTest{
	private static Logger log = LogManager.getFormatterLogger(UpdateERVTest.class);
	@Test
	public void verifyUpdateERVTest() throws Exception {
		log.info("Starting test case: verifyUpdateERVTest");
		login("qatest","Qatest@_2025");
		log.info("Login successful");
		Thread.sleep(3000);
		
		UpdateERVPage uep=new UpdateERVPage(driver);
		
		gp.clickOnGodown();
		log.info("Navigated to Godown page");
		uep.clickOnUpdateERVLink();
		log.info("Clicked on Update ERV link");
		uep.selectDate("08/10/2025");
		log.info("Date selected");
		uep.enterERVNumber("9879798");
		log.info("Entered ERV Number");
		uep.clickOnSearchButton();
		log.info("Clicked on Search button");
		uep.clickOnDeleteButton();
		log.info("Clicked on Delete button");
		uep.acceptAlert();
		uep.acceptAlert();
		Thread.sleep(2000);
		
	}

}
