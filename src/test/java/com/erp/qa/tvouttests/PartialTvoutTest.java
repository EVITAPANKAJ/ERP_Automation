package com.erp.qa.tvouttests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import com.erp.qa.base.BaseTest;
import com.erp.qa.tvoutpages.PartialTvoutPage;


public class PartialTvoutTest extends BaseTest {	
	private static Logger log = LogManager.getFormatterLogger(PartialTvoutTest.class);
	
	@Test(priority = 1)
	public void verifyPartialTvoutLink() throws Exception {
		log.info("Starting test: verifyPartialTvoutLink");
		login("qatest","Qatest@_2025");
		log.info("Login successful");
		
		PartialTvoutPage ptv=new PartialTvoutPage(driver);
		
		ptv.clickOnTvModuleLink();
		log.info("TV Module link clicked successfully.");
		ptv.clickOnPartialTvoutLink();
		Thread.sleep(3000);				
		log.info("TV Module link clicked successfully.");		
		ptv.checkNewConsumerCheckbox();
		ptv.enterNewConsumerNo("25526");
		ptv.enterNewDate("10/06/2024");
		ptv.selectConsumerType();
		ptv.chooseConsumerType();
		ptv.enterNumberOfCylinders("2");
		ptv.selectNewGodownByName("MAIN GODOWN");
		ptv.clickOnSubmitButton();
		log.info("Partial TV out form submitted successfully.");
		}
		@Test(priority = 2)
		public void verifyWithConsumerDetails() throws Exception {
			log.info("Starting test: verifyWithConsumerDetails");
			login("qatest","Qatest@_2025");
			log.info("Login successful");
			ptv.clickOnTvModuleLink();
			log.info("TV Module link clicked successfully.");
			ptv.clickOnPartialTvoutLink();
			Thread.sleep(3000);				
			log.info("TV Module link clicked successfully.");	
			ptv.enterConsumerNo("12345");
			ptv.clickOnGetConsumerDataButton();			
			ptv.selectExistingGodownByName("MAIN GODOWN");
			log.info("Existing Godown selected successfully.");
			ptv.clickOnExistingSubmitButton();
			log.info("Partial TV out form submitted successfully.");
			Thread.sleep(2000);
		
	}
		public static org.apache.logging.log4j.Logger getLog() {			
			return log;
		}
		public static void setLog(org.apache.logging.log4j.Logger log) {
			PartialTvoutTest.log = log;
		}

}