package com.acheive.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectUtil {
	WebDriver driver;
	public String getProperty(String propertyName) throws FileNotFoundException, IOException
	{
		String propFilePath=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+ "page.properties";
		String propertyValue=null;
		Properties prop=new Properties();
		prop.load(new FileInputStream(propFilePath));
		propertyValue=prop.getProperty(propertyName);
		return propertyValue;
	}
	public WebElement getWebElement(String strElement,String selectorType) throws FileNotFoundException, IOException
	{
		driver= WebDriverManager.getWebDriver();
		WebElement element = null;
		if(selectorType.equals("xpath"))
			element=driver.findElement(By.xpath(strElement));		
		return element;		
	}
	public void scrollIntoTheElement(WebElement element) throws FileNotFoundException, IOException{
		driver= WebDriverManager.getWebDriver();
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("arguments[0].scrollIntoView(true);", element);		
		}
	public void jsClick(WebElement webElement) throws FileNotFoundException, IOException {
		driver= WebDriverManager.getWebDriver();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", webElement);
		
	}


}
