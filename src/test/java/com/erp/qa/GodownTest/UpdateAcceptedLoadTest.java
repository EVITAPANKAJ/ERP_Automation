package com.erp.qa.GodownTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;



public class UpdateAcceptedLoadTest extends BaseTest{
	private static Logger log = LogManager.getFormatterLogger(UpdateAcceptedLoadTest.class);
	@Test	
	public void verifyUpdateAcceptedLoadTest() throws Exception {
		log.info("Starting test case: verifyUpdateAcceptedLoadTest");
		lp.login("qatest","Qatest@_2025");
		log.info("Login successful");
		Thread.sleep(3000);
		gp.clickOnGodown();
		log.info("Clicked on Godown module");
		ualp.clickOnupdateaccepted();
		log.info("Clicked on Update Accepted Load");
		ualp.Filling("14/10/2025","2349","12-10-2025","EAST GODOWN","19 KG(COM)","201","0","0","14.2 KG (S-DOM)","100","0","0");
		log.info("Filled the form with provided data");
		ualp.clickonSubmitbutton();
		log.info("Clicked on Submit button");
		ualp.acceptAlert();
		ualp.acceptAlert();
		log.info("Accepted all alerts");
		ualp.clickOnSearch();
		log.info("Clicked on Search button");
		ualp.changedate1("12/10/2025");
		log.info("Changed the date for search");
		ualp.enterInvoice1("2349");
		log.info("Entered date and invoice number for search");
		ualp.clickOnSearch();
		log.info("Searched for the invoice");
		ualp.clickOnDeleteButton();	
		log.info("Clicked on Delete button");
		ualp.acceptAlert();
		ualp.acceptAlert();
		log.info("Accepted all alerts after deletion");
		
		
	}

}
