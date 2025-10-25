package com.erp.qa.tvouttests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;
import com.erp.qa.tvoutpages.PartialTvOutListPage;

public class PartialTvOutListTest extends BaseTest {
	private static Logger log = LogManager.getFormatterLogger(PartialTvOutListTest.class);
    // Test 1: Verify navigation to Partial TV Out list
    @Test
    public void verifyPartialTvoutListlink() throws Exception {
    	log.info("Starting test: verifyPartialTvoutListlink");
		login("qatest","Qatest@_2025");
		log.info("Login successful");
		
		PartialTvOutListPage ptvl=new PartialTvOutListPage(driver);
		
		ptvl.clickOnTvModuleLink();
		log.info("TV Module link clicked successfully.");
		ptvl.clickonPartialtvoutlist();
		log.info("Partial TV Out list link clicked successfully.");
		Thread.sleep(2000);
    	
       // performPartialTvOutFlow("1234899", "Rohit", "2500", "Virar", 1);
    }

    // DataProvider for multiple datasets
    @DataProvider(name = "tvOutData")
    public Object[][] getTvOutData() {
    	log.info("Providing test data for partialTvOut test");
        return new Object[][] {
            {"1234899", "Rohit", "2500", "Virar", 1, null, null,null,null},   // Test Case 1
            {"897689", "Suresh", "3000", "Palghar", 2, "DPR LOST PENALTY", "230", "CYLINDER LOST PENALTY","1100"} // Test Case 2
       
        };
        
       
    }

    // Test 2: Run same flow with different data
    @Test(dataProvider = "tvOutData")
    public void partialTvOut(String consumerNumber, String consumerName, String amount, String cityName, int option, String servic, String unitcost, String service,String Unitcos) throws Exception {
        performPartialTvOutFlow(consumerNumber, consumerName, amount, cityName, option, servic, unitcost, service,Unitcos);
        log.info("Test data provided successfully");
    }
   

    // Common reusable flow
    private void performPartialTvOutFlow(String consumerNumber, String consumerName, String amount, String cityName, int option, String servic, String unitcost, String service, String Unitcos) throws Exception {
    	setLog(LogManager.getLogger(PartialTvOutListTest.class));
    	log.info("Starting performPartialTvOutFlow with parameters: consumerNumber=" + consumerNumber + ", consumerName=" + consumerName + ", amount=" + amount + ", cityName=" + cityName + ", option=" + option + ", servic=" + servic + ", unitcost=" + unitcost + ", service=" + service + ", Unitcos=" + Unitcos);
        login("qatest","Qatest@_2025");
        log.info("Login successful");
        ptvl.clickOnTvModuleLink();
        log.info("TV Module link clicked successfully.");        
        ptvl.clickonPartialtvoutlist();
        ptvl.enterConosumernumber(consumerNumber);
        ptvl.clickOnConsumerNumber(consumerNumber);
        ptvl.enterConsumerName(consumerName);
        log.info("Consumer name entered: " + consumerName);

        if (option == 1) {
            // Test Case 1
            ptvl.selectDprRecievedBy();
            ptvl.selectCylinderRecievedBy();
            ptvl.selectRecievedBy();        
            ptvl.clickOnSelectRecievedBy();
            ptvl.selectReason();
            ptvl.ClickonReason();
        } else {
            // Test Case 2
            ptvl.selectDprRecievedBy1();
            ptvl.selectCylinderRecievedBy1();
            ptvl.selectReason();
            ptvl.ClickonReason();
            if (servic != null && unitcost != null) {
                ptvl.selectonService(servic);
                ptvl.enterOnUnitCost(unitcost);
            }
            ptvl.clickOnAddbutton();
            if(service != null && Unitcos != null) {
            ptvl.enterOnservic(service);
            ptvl.enterOnUnitcost1(Unitcos);
            }
           
        }

        ptvl.getTotalDepositeAmount(amount);
       Thread.sleep(2000);        
        ptvl.clickOnSelectTvModel();
        ptvl.selectTvModelOption();
        ptvl.clickOnSelectState();
        ptvl.selectStateOption();
        ptvl.selectDestrictOption();
        ptvl.selectTehsilOption();
        ptvl.enterCity(cityName);
        ptvl.clickOnSubmitButton();
        Thread.sleep(2000);
    }

	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		PartialTvOutListTest.log = log;
	}
}
