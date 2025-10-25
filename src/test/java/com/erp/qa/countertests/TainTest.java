package com.erp.qa.countertests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;
import com.erp.qa.counterpages.TainPage;

public class TainTest extends BaseTest {
	private static Logger log = LogManager.getLogger(TainTest.class.getName());
	
	@Test
	public void verifyCounterLink() throws Exception {
		log.info("Starting test: verifyCounterLink");
		login("qatest","Qatest@_2025");
		log.info("Login successful");
		Thread.sleep(3000);
		
		TainPage tain=new TainPage(driver);
		
		sv.clickOnCounterSalesLink();	
		log.info("Counter Sales link clicked successfully");
		tain.clickOnTainLink();
		log.info("TAIN link clicked successfully");		
		String bill =tain.FillDetails("27AAACB2894J1ZV","DOC12345","708183","MH12AB1234","John Doe","123 Main St, City, State","Mumbai",
				"9876543210","john123@gmail.com","PD123","PC456","2","1");			
		log.info("Details filled successfully in TAIN form");
		Thread.sleep(2000);
		log.info("Submit button clicked successfully");
		
		tain.getBillNumber();
		log.info("Bill number retrieved successfully: " + tain.getBillNumber());
		
		tain.clickonBackbutton();
		log.info("Back button clicked successfully");
		
		tain.clickOnUpdateTAINLink();
		log.info("Update TAIN link clicked successfully");
		
		tain.enterMDLDocumentNumber(bill);
		log.info("MDL Document Number entered successfully: " + tain.getBillNumber());
		
		tain.clickOnMDLGetButton();
		log.info("MDL Get button clicked successfully");
		tain.acceptAlert();
		tain.acceptAlert();		
		
	}
	
}
