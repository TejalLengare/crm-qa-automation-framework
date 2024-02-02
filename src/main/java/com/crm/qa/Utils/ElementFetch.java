package com.crm.qa.Utils;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.crm.qa.Base.BaseTest;

public class ElementFetch {
	public WebElement getWebElement(String locatorType, String locatorValue) {
		switch (locatorType) {
		case "XPATh":
			return BaseTest.driver.findElement(By.xpath(locatorValue));
		case "CSS":
			return BaseTest.driver.findElement(By.cssSelector(locatorValue));
		case "CLASSNAME":
			return BaseTest.driver.findElement(By.className(locatorValue));
		case "ID":
			return BaseTest.driver.findElement(By.id(locatorValue));
		case "Name":
			return BaseTest.driver.findElement(By.name(locatorValue));
		case "TAGNAME":
			return BaseTest.driver.findElement(By.tagName(locatorValue));
		default:
			return null;
		}
		}
		public static List <WebElement> getWebElements(String locatorType, String locatorValue) {
		
			switch (locatorType) {
			case "XPATh":
				return BaseTest.driver.findElements(By.xpath(locatorValue));
			case "CSS":
				return BaseTest.driver.findElements(By.cssSelector(locatorValue));
			case "CLASSNAME":
				return BaseTest.driver.findElements(By.className(locatorValue));
			case "ID":
				return BaseTest.driver.findElements(By.id(locatorValue));
			case "Name":
				return BaseTest.driver.findElements(By.name(locatorValue));
			case "TAGNAME":
			default:
				return null;

			}
	}
}
