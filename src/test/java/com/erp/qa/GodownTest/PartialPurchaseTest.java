package com.erp.qa.GodownTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.GodownPage.PartialPurchasePage;
import com.erp.qa.base.BaseTest;

public class PartialPurchaseTest extends BaseTest{
	private static Logger log = LogManager.getFormatterLogger(PartialPurchaseTest.class);
	@Test	
	public void verifyPurchaseLink() throws Exception {
		log.info("Starting test case: verifyPurchaseLink");
		login("qatest","Qatest@_2025");
		log.info("Login successful");
		Thread.sleep(3000);
		
		PartialPurchasePage gp=new PartialPurchasePage(driver);
		
		gp.clickOnGodown();
		log.info("Navigated to Godown section");
		gp.clickOnPartialPurchase();
		log.info("Navigated to Partial Purchase section");
		gp.enterInvoice("2349");
		gp.enterERV("38478");
		gp.clickOnoneway();
		gp.clickOnselectgodown();
		gp.clickOnSearchGodown();				
		//gp.selectVehical();
		//gp.clickOnSearchVehical();
		gp.clickOncheckVehical();
		gp.enterVehical("MH 02 SS 2318");
		gp.enterProduct("14.2 KG (S-DOM)");
		gp.enterQty("190");
		gp.eneterLostqty("1");
		gp.enterdefectiveqty("2");
		log.info("Entered all details");
		gp.clickonSubmitbutton();
		log.info("Partial Purchase submitted successfully");
		gp.acceptAlert();
		gp.acceptAlert();
		
		
		
	}
}
