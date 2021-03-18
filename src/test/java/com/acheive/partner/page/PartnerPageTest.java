package com.acheive.partner.page;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import com.acheive.base.page.Acheive3000BasePage;
import com.acheive.util.PageObjectUtil;
import com.acheive.util.WebDriverManager;

public class PartnerPageTest extends Acheive3000BasePage
{
	WebDriver driver = null;

	public PartnerPageTest() throws IOException {
	}


	@Test
	public void testPartnersLogoNameAndDescription() throws IOException {
		/**
		 * Test Step 1- Open  https://www.achieve3000.com.
		 * - Loading Web Driver
		 * - Open URL as defined in externalize property file.
 		 */
		driver = WebDriverManager.getWebDriver();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(acceptAllCookies)));

		PageObjectUtil.javascriptClickExecutor(PageObjectUtil.getWebElementByXpath(acceptAllCookies));
		/**
		 * Test Step 2 - Open Partners List .
		 *  1- Click on toggler collapsed Menu.
		 *  2 - Wait Until partner link is initialized and clickable.
		 *  3- Click on Partners Link
		 */
		PageObjectUtil.javascriptClickExecutor(PageObjectUtil.getWebElementByXpath(menuExpander));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(linkPartners)));

		PageObjectUtil.getWebElementByXpath(linkPartners).click();
		/** Step 2 Complete	**/

		/**
		 * Step 3 - List all partners LOGO
		 * - Find all elemnts using xpath locator for logos.
		 */
		List<WebElement> listOfElementsOurPartners = driver.findElements(By.xpath(logos));
		/** Step 3 Complete **/
		int i = 1;
		for (WebElement element : listOfElementsOurPartners) {
			PageObjectUtil.scrollIntoTheElement(element);
			/**
			 * Step 4 - Final Step check all presented partners has logo, header and text description
			 */
			//Assert and validation for header
			String headerPartner = element.findElement(By.tagName("h3")).getText();
			Assert.assertNotNull(headerPartner);
			//Assert and validation for text description
			String text = element.findElement(By.tagName("p")).getText();
			Assert.assertNotNull(text);
			//Assert and validation for Logo
			element = element.findElement(By.tagName("img"));
			String logoHyperlink = element.getAttribute("src");
			Assert.assertNotNull(logoHyperlink);
			/**
			 * Logging the value on Console for testing purpose only
			 */
			System.out.println(i++ + " Partner Name - " + headerPartner);
			System.out.println("Header and text description - " + text);
			System.out.println("Logo Image link - " + logoHyperlink);
		}
		/** Final Step Complete**/
	}

	@AfterSuite
	public void cleanUp()	{
		driver.quit();
	}
	
}


