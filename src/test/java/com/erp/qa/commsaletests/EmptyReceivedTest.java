package com.erp.qa.commsaletests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;
import com.erp.qa.countertests.BeyondSaleTest;

public class EmptyReceivedTest extends BaseTest{
private static Logger log = LogManager.getFormatterLogger(BeyondSaleTest.class);
	
	@Test
	public void verifyCommSaleLink() throws Exception {
		log.info("********** Starting test case: verifyCounterLink **********");
		lp.login("qatest","Qatest@_2025");
		log.info("Login successful");
		Thread.sleep(3000);
		cs.clickOnCommSaleLink();
		cs.clickOnCommercialSale();
		ce.clickOnEmptyReceivedlink();
		ce.clickOnDeliveryMan();
		ce.enterOndeliveryman("DINESH");
		ce.clickOnPartyName();
		ce.enterOnPartyName("KAILASH HOTEL");
		ce.enterDate(driver, "20-10-2025");
		ce.clickOnproduct();
		ce.enterProduct("19 KG(COM)");
		ce.enterEmptyQty("10");
		ce.enterOnChallNo("3838");
		ce.clickModeOfpaymentdropdown();
		ce.EnterOnModeOfPayment("CASH");
		ce.enterOnCash("1231");
		ce.clickOnsubmitbutton();
		Thread.sleep(2000);
		//ce.acceptAlert();
		//ce.acceptAlert();
		Thread.sleep(2000);

	}
}
