package com.erp.qa.countertests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;

public class TaoutTest extends BaseTest {
	private static Logger log = LogManager.getFormatterLogger(TaoutTest.class.getName());
	
	@Test
	public void verifyCounterLink() throws Exception {
		log.info("Starting test: verifyCounterLink");
		lp.login("qatest","Qatest@_2025");
		log.info("Login successful");
		Thread.sleep(3000);
		sv.clickOnCounterSalesLink();
		log.info("Counter Sales link clicked successfully");
		taout.clickOnTaoutLink();
		log.info("Taout link clicked successfully");
		String billNo =taout.FillDetails("89898","29AAACB2894J1ZV","12345","Bangalore","1234","abc123@gmail.com");
		Thread.sleep(2000);
		log.info("Details filled successfully");
		log.info("Test verifyCounterLink completed successfully");
		
		log.info("Submit button clicked successfully");
		
		 taout.clickonBackbutton();
		    log.info("Back button clicked successfully.");
		    
		 taout.clickOnUpdateTAOUTLink();
		    log.info("Update New Connection link clicked successfully.");
		    
		    if (billNo != null) {
		    	taout.enterMDLDocumentNumber(billNo);
		        log.info("MDL Document Number entered successfully: " + billNo);
		    } else {
		        log.warn("Bill number was null — skipping MDL document number entry.");
		    } 
		    taout.clickOnMDLGetButton();
			taout.acceptAlert();
	}	
	
}
