package com.acheive.base.page;


import java.io.IOException;

import com.acheive.util.PageObjectUtil;
import com.acheive.util.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Acheive3000BasePage {

	public Acheive3000BasePage() throws IOException	{
		WebDriver webDriver = WebDriverManager.getWebDriver();
		webDriver.get(PageObjectUtil.getProperty("url","page"));
		webDriver.manage().window().maximize();
	}
	

}
