package org.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtility {
	WebDriver driver;
	public WebDriver startUp(String bName, String URL) {
		if(bName.equalsIgnoreCase("CH") || bName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",
					"./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if(bName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"./drivers/chromedriver.exe");
			driver = new EdgeDriver();
		}else {
			System.out.println("Invalid Browser Name");
		}
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;
	}

	public void clickByJS(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
	}

	public boolean waitForVisibiltyOf(WebDriver driver, int time, WebElement ele) {
		try {
			WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
			wt.until(ExpectedConditions.visibilityOf(ele));
			return true;
		}catch(Exception e) {
			return false;
		}

	}
	public void waitForVisibiltyOfElementLocated(WebDriver driver, int time, String locator, String ele) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		switch(locator) {
		case "xpath": wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ele)));
		break;
		case "cssSelector": wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ele)));
		break;
		case "id": wt.until(ExpectedConditions.visibilityOfElementLocated(By.id(ele)));
		break;
		case "className": wt.until(ExpectedConditions.visibilityOfElementLocated(By.className(ele)));
		break;
		case "linkText": wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(ele)));
		break;
		case "partialLinkText": wt.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(ele)));
		break;
		case "name": wt.until(ExpectedConditions.visibilityOfElementLocated(By.name(ele)));
		break;
		case "tagName": wt.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(ele)));
		break;
		}	
	}
	public void waitPresenceOfElementLocated(WebDriver driver, int time, String type, String locator) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));

		switch(type) {
		case "id":wt.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
		break;

		case "class":wt.until(ExpectedConditions.presenceOfElementLocated(By.className(locator)));
		break;

		case "xpath":wt.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		break;

		case "cssSelector":wt.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
		break;

		case "tagName":wt.until(ExpectedConditions.presenceOfElementLocated(By.tagName(locator)));
		break;
		}
	}
	public void waitForUrlContains(WebDriver driver, int time, String partialUrl) {
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(time));
		wt.until(ExpectedConditions.urlContains(partialUrl));
	}
}
