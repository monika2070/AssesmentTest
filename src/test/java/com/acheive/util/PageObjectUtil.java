package com.acheive.util;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PageObjectUtil {

	public static String getProperty(String propertyName) throws  IOException	{
		String propFilePath=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+ "page.properties";
		Properties properties=new Properties();
		properties.load(new FileInputStream(propFilePath));
		return properties.getProperty(propertyName);
	}
	public static WebElement getWebElementByXpath(String elementReference) throws  IOException	{
		return WebDriverManager.getWebDriver().findElement(By.xpath(elementReference));
	}

	public static void scrollIntoTheElement(WebElement element) throws IOException{
		JavascriptExecutor js=(JavascriptExecutor)WebDriverManager.getWebDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void javascriptClickExecutor(WebElement webElement) throws  IOException {
		JavascriptExecutor javascriptExecutor=(JavascriptExecutor)WebDriverManager.getWebDriver();
		javascriptExecutor.executeScript("arguments[0].click();", webElement);
		
	}


}
