package com.erp.qa.countertests;

import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;

public class EquipmentRecoveryTest extends BaseTest {
	
	@Test
	public void verifyCounterLink() throws Exception {
		lp.login("qatest","Qatest@_2025");
		Thread.sleep(3000);
		sv.clickOnCounterSalesLink();
		erp.clickOnEquipmentRecoveryLink();
	    erp.FillDetails("12345","Bharat Petroleum","01-09-2025","SRN123456","10-09-2025","DPR LOST PENALTY","1","5000");
	    System.out.println("Form submitted successfully.");
	}

}