package com.erp.qa.countertests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;
import com.erp.qa.counterpages.SvPage;

public class SvTest extends BaseTest { 
	private static Logger log = LogManager.getLogger(SvTest.class.getName());
	@Test
	public void verifyCounterLink() throws Exception {
	    log.info("Starting test: verifyCounterLink");
	    login("qatest","Qatest@_2025");
	    log.info("Login successful");
	    Thread.sleep(3000); // ideally replace with explicit wait for a login-success element
	   
	    SvPage sv=new SvPage(driver);
	    
	    sv.clickOnCounterSalesLink();
	    log.info("Counter Sales link clicked successfully.");

	    sv.clickOnSvLink();
	    log.info("SV link clicked successfully.");

	    // Fill details and capture bill number
	    String billNo = sv.FillDetails("INV12345","27AAACB2894J1ZV","DOC67890","2889","8837489","REG98765","John Doe","9876543210",
	            "123 Main St, City, Country","City","BB123456","johan123@gmail.com");
	    log.info("Details filled successfully. billNo=" + billNo);

	    // No extra click here — FillDetails already submitted
	    // Navigate back / proceed
	    sv.clickonBackbutton();
	    log.info("Back button clicked successfully.");

	    sv.clickOnUpdateNewConnectionLink();
	    log.info("Update New Connection link clicked successfully.");

	    if (billNo != null) {
	        sv.enterMDLDocumentNumber(billNo);
	        log.info("MDL Document Number entered successfully: " + billNo);
	    } else {
	        log.warn("Bill number was null — skipping MDL document number entry.");
	    }		
	
	sv.clickOnMDLGetButton();
	log.info("MDL Get button clicked successfully.");
	
	sv.acceptAlert();
	log.info("Alert handled successfully.");
	Thread.sleep(2000); // ideally replace with explicit wait for alert handling
	
	sv.clickOnDeleteButton();
	log.info("Delete button clicked successfully.");
	
	sv.acceptAlert();
	sv.acceptAlert();
	log.info("Delete confirmation alert handled successfully.");
	}
}