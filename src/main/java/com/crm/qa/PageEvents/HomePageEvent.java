package com.crm.qa.PageEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.crm.qa.Base.BaseTest;
import com.crm.qa.Utils.ElementFetch;

public class HomePageEvent {
	ElementFetch ele = new ElementFetch();

	public void SignInButton() {
		//WebElement signInButton = ele.getWebElement("XPATH", HomePageElements.signinbuttontext);
		WebElement signInButton = BaseTest.driver.findElement(By.xpath("//span[normalize-space()='Log In']"));
		// Verify that signInButton is not null before clicking
		if (signInButton != null) {
			signInButton.click();
		} else {
			// Log an error or throw an exception if signInButton is null
			System.err.println("Error: WebElement is null");
			// Consider throwing an exception to indicate the error
			// throw new RuntimeException("WebElement is null");
		}
	}
}
