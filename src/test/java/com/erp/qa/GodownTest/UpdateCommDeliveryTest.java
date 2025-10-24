package com.erp.qa.GodownTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;

public class UpdateCommDeliveryTest extends BaseTest{
private static Logger log = LogManager.getFormatterLogger(CommercialDeliveryTest.class);
	
	@Test
	public void verifyUpdateCommercialDeliveryTest() throws Exception {
		log.info("Starting test case: verifyCommercialDeliveryTest");
		lp.login("qatest","Qatest@_2025");
		log.info("Login successful");
		Thread.sleep(3000);
		gp.clickOnGodown();
		log.info("Navigated to Godown section");
		ucdp.clickOnupCommercialDelivery();
		ucdp.enterDate(driver, "15/10/2025");
		Thread.sleep(2000);
		ucdp.clickOnShowButton();
		ucdp.selectGodown();
		ucdp.enterGodown("Main Godown");
		ucdp.selectProductType();
		ucdp.enterProductType("BMCG 19 KG");
		ucdp.enterFullCylinder("15");
		ucdp.enterEmptyCylinder("15");
		ucdp.enterSV("0");
		ucdp.enterDBC("0");
		ucdp.enterDefective("0");
		ucdp.enterLostCylinder("0");
		ucdp.clickonSubmitbutton();
		ucdp.acceptAlert();
		ucdp.acceptAlert();
	}
}
