package com.acheive.util;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
	private static WebDriver driver=null;
	private static WebDriverManager driverFactoryInstance=null;
	private WebDriverManager(String browserType)
	{
		if("chrome".equals(browserType)){
			String driverPath=System.getProperty("user.dir")+File.separator+"extlib"+File.separator+"chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver=new ChromeDriver();
		}else if("firefox".equals(browserType)){
			String driverPath=System.getProperty("user.dir")+File.separator+"extlib"+File.separator+"geckoDriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver=new ChromeDriver();
		}
	}
	public static WebDriver getWebDriver() throws IOException {
		if(driverFactoryInstance==null)
			driverFactoryInstance=new WebDriverManager(PageObjectUtil.getProperty("browserType","page"));
		return driver;		
	}

}
