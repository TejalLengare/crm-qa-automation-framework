package com.crm.qa.PageEvents;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.crm.qa.Base.BaseTest;
import com.crm.qa.Utils.ElementFetch;

public class LoginPageEvent {
	ElementFetch ele = new ElementFetch();

	public void verifyIfLoginPageisLoaded() {
		//Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElements.LoginText).size() > 0,
				//"Login Test is not Found");
		List<WebElement> elements = ElementFetch.getWebElements("your-locator-type", "your-locator-value");

        // Verify that the list is not null before checking its size
        if (elements != null && !elements.isEmpty()) {
            int size = elements.size();
            // Continue with your verification logic
        } else {
            // Log an error or throw an exception if the list is null or empty
            System.err.println("Error: List of WebElements is null or empty");
            // Consider throwing an exception to indicate the error
            // throw new RuntimeException("List of WebElements is null or empty");
        }
	}
	public void enterCredentials() {
		//ele.getWebElement("XPATH",LoginPageElements.EmailAddress).sendKeys("tejallengare999@gmail.com");
		//ele.getWebElement("XPATH",LoginPageElements.Password).sendKeys("Tejallengare");;
		
		BaseTest.driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("tejallengare999@gmail.com");
		BaseTest.driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Tejallengare");

	}

}
