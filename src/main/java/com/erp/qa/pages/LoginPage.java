package com.erp.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="txtEmail")
	public WebElement username;
	
	@FindBy(id="password-field")
	private WebElement password;
	
	@FindBy(id="btnLogin")
	private WebElement loginBtn;
	
	public void enterUsername(String user) {
		username.sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	
	public void login(String user, String pass) throws Exception {
		enterUsername(user);
		enterPassword(pass);
		Thread.sleep(2000); // Just for demo, avoid using Thread.sleep in real tests
		clickLogin();
	}
	
	public WebElement getPasswordField() {
		return password;
	}

	public String getAlertTextAndAccept() {
		try {
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			return text;
		} catch (NoAlertPresentException e) {
			return "";
		}
	}

	public WebElement getUsernameField() {
		// TODO Auto-generated method stub
		return null;
	}
}