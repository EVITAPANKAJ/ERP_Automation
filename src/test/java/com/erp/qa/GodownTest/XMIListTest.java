package com.erp.qa.GodownTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;

public class XMIListTest extends BaseTest{
private static Logger log = LogManager.getFormatterLogger(CommercialDeliveryTest.class);
	
	@Test
	public void verifyXMIListTest() throws Exception {
		log.info("Starting test case: verifyCommercialDeliveryTest");
		lp.login("qatest","Qatest@_2025");
		log.info("Login successful");
		Thread.sleep(3000);
		gp.clickOnGodown();
		log.info("Navigated to Godown section");
		xmip.clickOnXMIList();
		xmip.clickOnViewIcon();
		xmip.getInvoiceNumber("12891");
		xmip.clickonSubmitbutton();
		xmip.acceptAlert();
		Thread.sleep(2000);

	}
}
