package com.erp.qa.test;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erp.qa.base.BaseTest;
import com.erp.qa.pages.LoginPage;
import com.erp.qa.utils.ExcelUtils;

public class LoginTest extends BaseTest {	
	private static final Logger log = LogManager.getLogger(LoginTest.class);
	
	@DataProvider(name = "loginCredentials")
	public Object[][] loginCredentialsProvider() {
		log.info("Logger for LoginTest initialized");
		log.info("Starting LoginTest execution");
		String excelPath = System.getProperty("user.dir") + "/src/main/java//com/erp/qa/utils/LoginData.xlsx";
		List<String[]> credentialsList = ExcelUtils.getAllLoginCredentials(excelPath, "Sheet1");
		Object[][] data = new Object[credentialsList.size()][2];
		for (int i = 0; i < credentialsList.size(); i++) {
			data[i][0] = credentialsList.get(i)[0];
			data[i][1] = credentialsList.get(i)[1];
		}
		return data;
	}
	
	@Test(dataProvider = "loginCredentials")
	public void testLogin(String username, String password) throws Exception {
		
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);
		log.info("Attempting login with username: " + username);
		Thread.sleep(3000); // Just for demo, avoid using Thread.sleep in real tests
		// Simulate error handling: highlight the username field and capture screenshot
		Alert alert = driver.switchTo().alert();
        System.out.println("Alert detected: " + alert.getText());
        if(alert.getText().contains("User Not Registred!")) {
			handleErrorAlertAndScreenshot(lp.username, "LoginError");
		}else 
		{
			if(alert.getText().contains("login failed Please try again!")) {
				handleErrorAlertAndScreenshot(lp.getPasswordField(), "LoginError");
			}
		}
        Assert.assertTrue(driver.getCurrentUrl().contains("/Index"), "Login failed for user: " + username);
	}

}