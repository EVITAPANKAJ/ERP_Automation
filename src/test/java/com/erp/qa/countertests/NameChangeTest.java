package com.erp.qa.countertests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;
import com.erp.qa.counterpages.NameChangePage;

public class NameChangeTest extends BaseTest {
	private static Logger log = LogManager.getLogger(NameChangeTest.class.getName());
	
	@Test
	public void verifyCounterLink() throws Exception {
		log.info("********** Starting Test Case: NameChangeTest **********");
		login("qatest","Qatest@_2025");
		log.info("Login successful");
		Thread.sleep(3000);
		NameChangePage ncp=new NameChangePage(driver);
		sv.clickOnCounterSalesLink();
		log.info("Counter Sales link clicked successfully");
		ncp.clickOnNameChangeLink();
		log.info("Name Change link clicked successfully");
		String billNo =ncp.FillDetails("12345","27AAACB2894J1ZV","12345","Test Name","Pune","12345","test123@gmail.com","DGCC BOOK");
		log.info("Details filled successfully");
		Thread.sleep(2000);
		
		log.info("Submit button clicked successfully");		
		
		ncp.clickonBackbutton();
		log.info("Back button clicked successfully");
		
		ncp.clickOnUpdateNameChangeLink();
		log.info("Update New Connection link clicked successfully");
		
		if (billNo != null) {
	        ncp.enterMDLDocumentNumber(billNo);
	        log.info("MDL Document Number entered successfully: " + billNo);
	    } else {
	        log.warn("Bill number was null — skipping MDL document number entry.");
	    }	
		
		ncp.clickOnMDLGetButton();
		log.info("MDL Get button clicked successfully");
	}

}
