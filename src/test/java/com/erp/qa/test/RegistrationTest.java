package com.erp.qa.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.erp.qa.base.BaseTest;
import com.erp.qa.pages.RegistrationPage;
import com.erp.qa.utils.ExcelUtils;

public class RegistrationTest extends BaseTest {
	private static Logger log = LogManager.getLogger(RegistrationTest.class);
    WebDriver driver;
    RegistrationPage regPage;

    @BeforeClass
    public void setup() {
    	  log=LogManager.getLogger(RegistrationTest.class);
    	
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://harekrishna.mygasagency.com/Registration/Registration");
        regPage = new RegistrationPage(driver);
    }

//    @DataProvider(name = "registrationData")
//    public Iterator<Object[]> getRegistrationData() throws IOException {
//        List<Map<String, String>> testData = ExcelUtils.getTestData("user.dir"+"\\src\\main\\java\\com\\erp\\qa\\utils\\RegistrationData.xlsx", "Sheet1");
//        List<Object[]> data = new ArrayList<>();
//        for (Map<String, String> map : testData) {
//            data.add(new Object[]{map});
//        }
//        return data.iterator();
//    }
 
    @Test
    public void fillRegistrationForm() throws InterruptedException {
    	 
        RegistrationPage regPage = new RegistrationPage(driver);
        log.info("Starting RegistrationTest execution");
 
        String excelPath = System.getProperty("user.dir") + "/src/main/java//com/erp/qa/utils/RegistrationData.xlsx";
        List<Map<String, String>> allData = ExcelUtils.getData(excelPath, "Sheet1");
 
        for (Map<String, String> data : allData) {
 
            regPage.Filling("FirstName","LastName","Contact","Email","DistributorCode","DistributorName","Address1","Address2",
            		"State","District","Tehsil","City","Area","Pincode","AltContact1","AltContact2","DistributorEmail","DistributorOf",
            		"Territory","DistributorType","TransporterCode","PAN","GSTIN","UserID","Password","repassword");
      	  log.info("Form filled with data: " + data);
            Thread.sleep(2000);
            regPage.clickOnsubmit();
            log.info("Form submitted successfully");
        }
    }
}
