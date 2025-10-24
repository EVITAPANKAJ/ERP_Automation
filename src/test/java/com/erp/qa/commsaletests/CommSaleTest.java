package com.erp.qa.commsaletests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;
import com.erp.qa.countertests.BeyondSaleTest;

public class CommSaleTest extends BaseTest {
private static Logger log = LogManager.getFormatterLogger(BeyondSaleTest.class);
	
	@Test
	public void verifyCommSaleLink() throws Exception {
		log.info("********** Starting test case: verifyCounterLink **********");
		lp.login("qatest","Qatest@_2025");
		log.info("Login successful");
		Thread.sleep(3000);
		cs.clickOnCommSaleLink();
		cs.clickOnCommercialSale();
		cs.clickOndeliveryman();
		cs.enterDeliveryManInSearchBox("DINESH");
		cs.clickOnPartyDropdown();
		cs.enterPartyInSearchBox("KAILASH HOTEL");
		cs.enterDate(driver, "20/10/2025");
		cs.enterChallanNo("001");
		cs.clickOnAreaDropdown();
		cs.enterAreaInSearchBox("VIRAR");
		cs.clickOnProductDropdown();
		cs.clickonPorduct();		
		cs.enterQty("22");
		cs.enterEmpty("2");
		cs.clickmodOfPay();
		cs.selectOnModeOfPayment("CASH");
		cs.enterOntheCash("2100");
		cs.clickOnsubmitButton();
		cs.acceptAlert();
		cs.acceptAlert();
		Thread.sleep(3000);
				

	}
}
