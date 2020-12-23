package org.qsp.genric;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenShot {
	public static void screenShot(WebDriver driver, String path) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File ScreenS = ts.getScreenshotAs(OutputType.FILE);
		File ScreenSave = new File(path);
		Files.copy(ScreenS, ScreenSave);
	}

}
