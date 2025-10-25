package com.erp.qa.GodownTest;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import com.erp.qa.GodownPage.ERVPage;
import com.erp.qa.base.BaseTest;

public class ERVTest extends BaseTest {
    private static Logger log = LogManager.getFormatterLogger(ERVTest.class);

    @Test
    public void verifyERVTest() throws Exception {
        // Fix Log4j routing file name
        ThreadContext.put("testClass", this.getClass().getSimpleName());

        log.info("Starting test case: verifyERVTest");
        login("qatest", "Qatest@_2025");
        log.info("Login successful");
        
        ERVPage ep=new ERVPage(driver);

        gp.clickOnGodown();
        log.info("Navigated to Godown section");

        ep.clickOnERVLink();
        ep.enterSearchBox("9879798");
        ep.clickOnEditButton();
        ep.acceptAlert();
        ep.verifyMainGodownText();
        ep.enterSearchBox1("EAST GODOWN");
        ep.clickOnOtherVehicleCheckbox();
        ep.enterPCOVehicleId("KA01AB1234");
        ep.enterProduct("19 KG(COM)");
        ep.enterSoundQuantity("105");
        ep.enterDefectiveQuantity("0");
        ep.clickOnAddButton();
        ep.enterProduct1("14.2 KG (S-DOM)");
        ep.enterSoundQuantity1("101");
        ep.enterDefectiveQuantity1("0");
        ep.clickOnSubmitButton();
        ep.acceptAlert(); // Insert Data
        ep.acceptAlert(); // Save
        ep.acceptAlert(); // Successful Save

        // SECOND SECTION
        Thread.sleep(3000);
        ep.openSecondSection();         
        ep.selectGodown();  // Method to open dropdown
        ep.searchAndSelectGodown("EAST GODOWN"); // Method to search and select godown
        ep.enterERVDate("30/06/2024");
        ep.clickOnOtherVehicleCheckbox1();
        ep.enterPCOVehicleId1("KA01AB1234");
        ep.enterProduct2("19 KG(COM)");
        ep.enterSoundQuantity2("105");
        ep.enterDefectiveQuantity2("0");
        ep.clickOnAddButton2();
        ep.enterProduct3("14.2 KG (S-DOM)");
        ep.enterSoundQuantity3("101");
        ep.enterDefectiveQuantity3("0");
        ep.clickOnSubmitButton2();
        ep.acceptAlert();
        ep.acceptAlert();
        Thread.sleep(2000);
    }
}
