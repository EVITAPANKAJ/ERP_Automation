package com.erp.qa.commsaletests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;
import com.erp.qa.commsalepage.CommercialSaleListPage;

public class CommercialSaleListTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(CommercialSaleListTest.class);

    @Test
    public void verifyCommercialSaleListFlow() throws Exception {
        log.info("********** Starting test case: verifyCommercialSaleListFlow **********");

        // Step 1: Login
        login("qatest", "Qatest@_2025");
        log.info("Login successful");

        // Step 2: Navigate to Commercial Sale List
        cs.clickOnCommSaleLink();
        log.info("Clicked on Commercial Sale link");
        
        CommercialSaleListPage cslp=new CommercialSaleListPage(driver);
        cslp.clickOnCommSaleList();
        log.info("Opened Commercial Sale List page");
         
        
        // Step 3: Apply date and deliveryman filter
        cslp.enterDate("20/10/2025");
        log.info("Changed date to 20/10/2025");
         
        
        cslp.clickOnDeliveryman();
        cslp.searchOnDeliveryman("DINESH");
        cslp.clickOnGetData();
        log.info("Filtered data by deliveryman: DINESH");

        // Step 4: Edit the record
        cslp.clickOnEditButton();
        cslp.switchToNewTab();
        log.info("Clicked on Edit button and switched to new tab");

        // Step 5: Update details in Edit page
        cslp.clickDeliveryman();
        cslp.enterDeliverymanName("UTTAM");
        log.info("Updated deliveryman to UTTAM");

        cslp.clickParty();
        cslp.enterParty("LLL HOTEL");
        log.info("Updated party to LLL HOTEL");

        cslp.enterOnDate("21/10/2025");
        log.info("Updated date to 21/10/2025");
        
        cslp.changeChallanNo("23893");
        cslp.clickOnAreaDropdown();
        cslp.enterAreaName("NALASOPARA");
        cslp.clickOnProduct();
        cslp.searchOnProduct("BMCG 19 KG");
        cslp.enterOnDiscount("10");
        cslp.updateFullQty("51");
        cslp.updateEmptyQty("41");
        cslp.clickOnUpdateButton();

        log.info("********** Completed test case: verifyCommercialSaleListFlow **********");
    }
}
