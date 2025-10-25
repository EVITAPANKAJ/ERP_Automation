package com.erp.qa.countertests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;
import com.erp.qa.counterpages.DbcPage;

public class DbcTest extends BaseTest {
	private static Logger log = LogManager.getFormatterLogger(DbcTest.class.getName());
	
	@Test
	public void verifyPurchaseLink() throws Exception {
		log.info("Starting test: verifyPurchaseLink");
		login("qatest","Qatest@_2025");
		log.info("Logged in successfully");
		Thread.sleep(3000);	
		DbcPage dbc=new DbcPage(driver);
		sv.clickOnCounterSalesLink();
		log.info("Clicked on Counter Sales link");
		dbc.clickOnDBCLink();
		log.info("Clicked on DBC link");
		String billNo=dbc.FillDetails("12345","INV12345","22AAAAA0000A1Z5","DOC67890","377384","REG12345","New York","BB123456",
				"qatest123@gmail.com","14.2 KG (S-DOM)","50","STAMP DUTY");		
		log.info("Filled in the details on DBC page");
		Thread.sleep(2000);		
		log.info("Clicked on Submit button");
		dbc.getBillNumber();
		log.info("Captured the bill number successfully");
		dbc.clickonBackbutton();
		log.info("Clicked on Back button");
		dbc.clickOnUpdateDBCLink();
		log.info("Clicked on Update New Connection link");
		if (billNo != null) {
	        dbc.enterMDLDocumentNumber(billNo);
	        log.info("MDL Document Number entered successfully: " + billNo);
	    } else {
	        log.warn("Bill number was null — skipping MDL document number entry.");
	    }
		dbc.enterMDLDocumentNumber(getBillNumber());
		log.info("Entered MDL Document Number: " + getBillNumber());
		
	}

	private String getBillNumber() {
		// TODO Auto-generated method stub
		return null;
	}

}
