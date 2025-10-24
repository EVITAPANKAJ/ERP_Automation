package com.erp.qa.GodownTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import com.erp.qa.base.BaseTest;


public class CommercialDeliveryTest extends BaseTest{
	private static Logger log = LogManager.getFormatterLogger(CommercialDeliveryTest.class);
	
	@Test
	public void verifyCommercialDeliveryTest() throws Exception {
		log.info("Starting test case: verifyCommercialDeliveryTest");
		lp.login("qatest","Qatest@_2025");
		log.info("Login successful");
		Thread.sleep(3000);
		gp.clickOnGodown();
		log.info("Navigated to Godown section");
		cdp.clickOnCommercialDelivery();
		cdp.enterDate("10/10/2024");
		cdp.selectGodownByText("EAST GODOWN");     // or whatever name you need
		cdp.selectDeliveryMan("DINESH");
		cdp.selectProductType("19 KG(COM)");
		cdp.enterFullCylinder("25");
		cdp.enterEmptyCylinder("10");
		cdp.enterSV("1");
		cdp.enterDBC("2");
		cdp.enterDefective("3");
		cdp.enterLostCylinder("4");
		cdp.enterReturnFullCylinder("5");
		cdp.clickonSubmitbutton();
		cdp.acceptAlert();
		cdp.acceptAlert();
		Thread.sleep(2000);
		
	}

}
