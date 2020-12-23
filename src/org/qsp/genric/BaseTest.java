package org.qsp.genric;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentTest;

public class BaseTest implements IAutoConst {
	public WebDriver driver = null;
	ExtentTest test = null;

	@BeforeMethod
	public void openBrowser() {
		if (Browser_Name.equalsIgnoreCase("Chrome")) {
			System.setProperty(ChromeKey, ChromeValue);
			driver = new ChromeDriver();
		}
		if (Browser_Name.equalsIgnoreCase("Firefox")) {
			System.setProperty(FireFoxKey, FirefoxValue);
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) throws IOException {
		String name = result.getName();
		int status = result.getStatus();
		if (status == 1) {
			Reporter.log("TestCase :" + name + " is passed ", true);
			Reports.ExtendantReport(test, name, status);
		} else {
			ScreenShot.screenShot(driver, imgPath + name + ".png");
			Reporter.log("TestCase :" + name + " is Fail ", true);
			Reports.ExtendantReport(test, name, status);
		}

		driver.close();

	}

}
