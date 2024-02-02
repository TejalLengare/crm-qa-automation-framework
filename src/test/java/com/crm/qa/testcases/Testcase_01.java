package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.Base.BaseTest;
import com.crm.qa.PageEvents.HomePageEvent;
import com.crm.qa.PageEvents.LoginPageEvent;
import com.crm.qa.Utils.ElementFetch;

public class Testcase_01 extends BaseTest {

	ElementFetch ele = new ElementFetch();
	HomePageEvent homepage = new HomePageEvent();
	LoginPageEvent loginpage = new LoginPageEvent();

	@Test
	public void MethodForEnteringCredentials() {
		logger.info("Signin into Login Page");
		homepage.SignInButton();
		logger.info("Login into Login Page");
		loginpage.verifyIfLoginPageisLoaded();
		loginpage.enterCredentials();
	}

}
