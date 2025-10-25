package com.erp.qa.GodownTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.erp.qa.GodownPage.DomesticDeliveryPage;
import com.erp.qa.base.BaseTest;

import org.apache.logging.log4j.ThreadContext;

public class DomesticDeliveryTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(DomesticDeliveryTest.class);

    @BeforeClass
    public void putTestNameInLogContext() {
        // Fix for log path like logs/${ctx:testClass}.log
        ThreadContext.put("testClass", this.getClass().getSimpleName());
    }

    @Test
    public void verifyDomesticDeliveryTest() throws Exception {
        log.info("Starting test case: verifyDomesticDeliveryTest");

        login("qatest","Qatest@_2025");
        gp.clickOnGodown();
        
        DomesticDeliveryPage ddp=new DomesticDeliveryPage(driver);

        ddp.openDomesticDelivery();
        ddp.enterDate("07/10/2025");

        ddp.chooseProduct("14.2 KG (S-DOM)");
        ddp.chooseGodown("MAIN GODOWN");

        // Row 0
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("DILIP");
        ddp.fillRow(0, "20","20","0","0","0","0","0");

        // Row 1
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("SOMRAJ"); // or another name as needed
        ddp.fillRow(1, "20","18","2","0","0","0","0");
        
     // Row 2
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("MAHESH"); // or another name as needed
        ddp.fillRow(1, "20","18","0","2","0","0","0");
        
     // Row 3
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("KIRAN"); // or another name as needed
        ddp.fillRow(1, "20","18","0","0","2","0","0");
        
     // Row 4
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("PRAKASH"); // or another name as needed
        ddp.fillRow(1, "20","18","0","0","0","2","0");
        
     // Row 5
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("AJAY"); // or another name as needed
        ddp.fillRow(1, "20","18","0","0","0","0","2");
        
     // Row 6
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("ADITYA"); // or another name as needed
        ddp.fillRow(1, "20","16","2","2","0","0","0");
        
     // Row 7
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("VIKASH"); // or another name as needed
        ddp.fillRow(1, "20","16","2","0","2","0","0");
        
     // Row 8
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("PRADEEP"); // or another name as needed
        ddp.fillRow(1, "20","16","2","0","0","2","0");
        
     // Row 9
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("RAJ KESHAR"); // or another name as needed
        ddp.fillRow(1, "20","16","2","0","0","0","2");
        
     // Row 10
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("JAY PRAKASH"); // or another name as needed
        ddp.fillRow(1, "20","16","0","2","2","0","0");
        
     // Row 11
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("AJIT"); // or another name as needed
        ddp.fillRow(1, "20","16","0","2","0","2","0");
        
     // Row 12
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("RABEL"); // or another name as needed
        ddp.fillRow(1, "20","16","0","2","0","0","2");
        
     // Row 13
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("JAMES FIGHTER"); // or another name as needed
        ddp.fillRow(1, "20","16","0","0","2","2","0");
        
     // Row 14
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("FIGHTER ONE"); // or another name as needed
        ddp.fillRow(1, "20","16","0","0","2","0","2");
        
     // Row 15
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("FIGHTER TWO"); // or another name as needed
        ddp.fillRow(1, "20","16","0","0","0","2","2");
        
     // Row 16
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("FIGHTER THREE"); // or another name as needed
        ddp.fillRow(1, "20","14","2","2","2","0","0");
        
     // Row 17
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("FIGHTER FOUR"); // or another name as needed
        ddp.fillRow(1, "20","14","2","2","0","2","0");
        
     // Row 18
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("TEST B"); // or another name as needed
        ddp.fillRow(1, "20","14","2","2","0","0","2");
        
     // Row 19
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("RAM LAL"); // or another name as needed
        ddp.fillRow(1, "20","14","2","0","2","2","0");
        
     // Row 20
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("PA_TEST"); // or another name as needed
        ddp.fillRow(1, "20","14","2","0","2","0","2");
        
     // Row 21
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("DAS"); // or another name as needed
        ddp.fillRow(1, "20","14","0","2","2","2","0");
        
     // Row 22
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("POLE"); // or another name as needed
        ddp.fillRow(1, "20","14","0","2","2","0","2");
        
     // Row 23
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("SHIV"); // or another name as needed
        ddp.fillRow(1, "20","14","0","2","0","2","2");
        
     // Row 24
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("RAJARAM"); // or another name as needed
        ddp.fillRow(1, "20","14","0","0","2","2","2");
        
     // Row 25
        ddp.addDeliveryRow();
        ddp.chooseDeliveryManByText("SURAJ"); // or another name as needed
        ddp.fillRow(1, "20","12","2","2","2","2","0");

        log.info("Filled rows: {}", ddp.getRowCount());
        
        ddp.clickOnSubmitButton();
        log.info("Clicked on Submit button.");
        ddp.acceptAlert();
        ddp.acceptAlert();
        log.info("Domestic delivery submitted successfully.");
        Thread.sleep(2000); // wait for submission to process
        
        ddp.enterDate("08/10/2025");

        ddp.chooseProduct("14.2 KG (S-DOM)");
        ddp.chooseGodown("MAIN GODOWN");
        log.info("Reopened Domestic Delivery page to verify submission.");
        ddp.clickOnGetDataButton();
        ddp.clickOnEditButton();
        
        ddp.clickOnUpdateButton();
        Thread.sleep(2000); // wait for data to load
    }
}
