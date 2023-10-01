package org.applicationHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.utilities.BaseUtility;
import org.utilities.configReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {
	public static configReader cr;
	public static Properties prop;
	public static BaseUtility bu;
	public static WebDriver driver;
	public static Scenario scn;

	@Before(order=0)
	public void LaunchBrowser() {
		cr = new configReader();
		prop = cr.getData();
		bu = new BaseUtility();
		driver = bu.startUp(prop.getProperty("browserName"), prop.getProperty("url"));
	}
	@Before(order=1)
	public void getScenarionInstance(Scenario scn) {
		AppHooks.scn=scn;
	}

	@After(order=2)
	public void takesScreenshot() {
		if(scn.isFailed()) {
			String screenShotName = scn.getName().replaceAll(" ", "");
			byte [] scnpath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scn.attach(scnpath, "image/png", screenShotName);
		}	
	}
	@After(order=1)
	public void tearDown() {
		driver.quit();
	}
}
