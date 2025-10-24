package com.erp.qa.driverfactry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {
	public static WebDriver setupBrowser(String browserName) {
        WebDriver driver;

      switch (browserName.toLowerCase()) {
        case "chrome":
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;

        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;

        case "edge":
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            break;

        default:
            throw new IllegalArgumentException("Invalid browser name: " + browserName);
    }

        driver.manage().window().maximize();
        return driver;
    }

}
