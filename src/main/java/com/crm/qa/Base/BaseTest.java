package com.crm.qa.Base;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;
import java.lang.Thread;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.crm.qa.Utils.Constant;
public class BaseTest {
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public static WebDriver driver;

	@BeforeTest
	public void beforetestmethod() {
		//ExtentSparkReporter Initialization
		sparkreporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + File.separator + "reports" + File.separator + "ExtentReport.html");
		extent = new ExtentReports();
		//Attaching ExtentSparkReporter to ExtentReports
		extent.attachReporter(sparkreporter);
		//Configuring SparkReporter Theme
		sparkreporter.config().setTheme(Theme.DARK);
		//Setting System Information
		extent.setSystemInfo("HostName", "RHEL8");
		extent.setSystemInfo("UserName", "root");
		//Configuring SparkReporter Document Title and Report Name
		sparkreporter.config().setDocumentTitle("Automation Report");
		sparkreporter.config().setReportName("Automation Test Result");
	}

	@BeforeMethod
	@Parameters("browser")
	//@Parameters("browser") method can receive a parameter named "browser" from the testng.xml file.
	//@Optional("chrome") Provides a default value ("chrome") for the "browser" parameter if not specified in the testng.xml file.
	//Method testMethod Represents information about the currently executing test method.
	public void beforemethod(@Optional("chrome")String browser, Method testMethod) {
		//Creating Extent Report Test
		logger = extent.createTest(testMethod.getName());
		//Setting up WebDriver
		setupDriver(browser);
		//Maximizing Browser Window
		driver.manage().window().maximize();
		//Navigating to URL
		driver.get(Constant.url);
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Thread Sleep
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setupDriver(String browser) {
		// TODO Auto-generated method stub
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = (WebDriver) new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = (WebDriver) new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = (WebDriver) new EdgeDriver();
		}
	}

	@AfterMethod
	//MarkupHelper.createLabel helps in formatting the log entries with appropriate colors in the HTML report.
	public void aftermethod(ITestResult result) {
		//Checks the status of the test method 
		//If the test method fails (ITestResult.FAILURE), logs the failure status in red.
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case Failed", ExtentColor.RED));
		//If the test method is skipped (ITestResult.SKIP), logs the skip status in orange.
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + "Test Case Skipped", ExtentColor.ORANGE));
		//If the test method passes (ITestResult.SUCCESS), logs the pass status in green.
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test Case Pass", ExtentColor.GREEN));
		}
		driver.quit();
	}
	@AfterTest
	public void aftertestmethod() {
	//for flushing and finalizing the Extent Report.
		extent.flush();
	}
}
