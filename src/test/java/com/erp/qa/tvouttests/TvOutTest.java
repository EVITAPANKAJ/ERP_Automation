package com.erp.qa.tvouttests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;
import com.erp.qa.tvoutpages.TvOutPage;

public class TvOutTest extends BaseTest {
	private static Logger log = LogManager.getFormatterLogger(TvOutTest.class);
	
	@Test
	public void tvOutTest() throws Exception {
		log.info("TvOutTest started");
		login("qatest","Qatest@_2025");
		log.info("Login Successfully");
		ptv.clickOnTvModuleLink();
		log.info("TV Module link clicked successfully.");
		
		TvOutPage tvp=new TvOutPage(driver);
		
		tvp.clickOnTvModuleLink();
		log.info("TV Out Module link clicked successfully.");
		tvp.Filling("12345","2500","Virar");
		log.info("TV Out details filled successfully.");
		Thread.sleep(2000);
	}	

}
