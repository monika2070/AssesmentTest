package com.acheive.util;

import java.io.File;
import java.io.FileNotFoundException;
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
		}
	}
	public static WebDriver getWebDriver() throws FileNotFoundException, IOException {
		PageObjectUtil utility=new PageObjectUtil();
		String browserType=utility.getProperty("browserType");
		if(driverFactoryInstance==null)
			driverFactoryInstance=new WebDriverManager(browserType);
		return driver;		
	}

}
