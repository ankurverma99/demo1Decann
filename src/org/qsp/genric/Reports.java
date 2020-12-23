package org.qsp.genric;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {
	public static void ExtendantReport(ExtentTest test, String name, int status) throws IOException {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("D:\\Ankur\\eclipse\\Selenium\\FrameWorkDemo1cse6\\Repo" + name + ".html");

		ExtentReports ext = new ExtentReports();
		ext.attachReporter(reporter);
		test = ext.createTest("test1");
		if (status == 1)
			test.log(Status.PASS, "test is pass");
		else
			test.log(Status.FAIL, "test is fail");
		ext.flush();
	}
}
