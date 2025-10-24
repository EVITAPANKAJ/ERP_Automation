package com.erp.qa.countertests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;

public class TvinTest extends BaseTest {
	private static Logger log = LogManager.getFormatterLogger(TvinTest.class.getName());
	
	@Test
	public void verifyCounterLink() throws Exception {
		log.info("Starting test: verifyCounterLink");
		lp.login("qatest","Qatest@_2025");
		log.info("Login successful.");
		Thread.sleep(3000);
		sv.clickOnCounterSalesLink();
		log.info("Counter Sale link clicked successfully.");
		tvin.clickOnTvinLink();
		log.info("TVIN link clicked successfully.");
		String billNo =tvin.FillDetails("22345","27AAACB2894J1ZV","64890","56321","28765","MH12AB1234","John Doe","123 Main St, City, Country",
				"Mumbai","9876543210","john123@gmail.com","PD123","PC456","BPCL","BB789");
		log.info("Details filled successfully.");		
		Thread.sleep(3000);
		tvin.clickonBackbutton();
		log.info("Back button clicked successfully.");
		tvin.acceptAlert();
		log.info("Alert accepted successfully.");
		tvin.clickOnUpdateTVINLink();
		log.info("Update New Connection link clicked successfully.");
		tvin.enterMDLDocumentNumber(billNo);
		log.info("MDL Document Number entered successfully: 12345");
		tvin.clickOnMDLGetButton();
		log.info("MDL Get button clicked successfully.");
	}

}
