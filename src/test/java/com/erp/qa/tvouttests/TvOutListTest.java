package com.erp.qa.tvouttests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;

public class TvOutListTest extends BaseTest{
	private static Logger log = LogManager.getFormatterLogger(TvOutListTest.class);
	
	// Test 1: Verify navigation to Partial TV Out list
	
	@Test
	public void tvOutListTest() throws Exception {
		log.info("TvOutListTest started");
		lp.login("qatest","Qatest@_2025");
		log.info("Login Successfully");
		ptv.clickOnTvModuleLink();
		log.info("TV Module Clicked Successfully");
		tvlp.clickOnTvoutList();
		log.info("TV Out List Clicked Successfully");
		tvlp.Fillings("91881","91881","29/09/2025","2800","Surat","DPR LOST PENALTY","2","230","5","CYLINDER LOST PENALTY"
				,"1100");
		log.info("TV Out List Filled Successfully");
		Thread.sleep(2000);
		
		
	}

}
