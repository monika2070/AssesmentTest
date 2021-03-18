package com.acheive.base.page;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.acheive.util.PageObjectUtil;
import com.acheive.util.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Acheive3000BasePage {
	PageObjectUtil util=new PageObjectUtil();
	protected String acceptAllCookies="//button[text()='Accept All Cookies']";
	protected String linkPartners ="//a[text()='Partners']";
	protected String logos ="//h3/../parent::div[@class='col-12 col-md-9 news-list-post article']/..";
	protected String menuExpander ="//button[@class='navbar-toggler collapsed']";

	public Acheive3000BasePage() throws IOException
	{
		WebDriver webDriver = WebDriverManager.getWebDriver();
		webDriver.get(util.getProperty("url"));
		webDriver.manage().window().maximize();
	}
	

}
