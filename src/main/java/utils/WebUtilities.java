package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtilities extends GeneralUtilities{


	public static WebDriver driver = null;
	public static JavascriptExecutor jsscroll;
	public String testcase;
	
	public static void browserLaunch(String browser) {
		
		switch (browser) {
		case "Chrome":
			ChromeOptions option = new ChromeOptions();
			option.addArguments("disable-notifications");
			option.addArguments("disable-geolocation");
			driver = new ChromeDriver(option);
			break;

		case "Firefox":
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("disable-notifications");
			options.addArguments("disable-geolocation");
			driver = new FirefoxDriver(options);
			break;
		default:
			break;
		}
		
	}
	
	public static void launchPage() {
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public static void linkClick(WebElement ele) {
		ele.click();
	}
	
	public static void buttonClick(WebElement ele) {
		ele.click();
	}
	
	public static void typeText(WebElement ele, String text) {
		ele.sendKeys(text);
	}
	
	public static void listDropdown(WebElement ele, String text) {
		
		Select list = new Select(ele);
		list.selectByVisibleText(text);
	}
	
	public static void scrollPage() {
		
		jsscroll = (JavascriptExecutor) driver;
		jsscroll.executeScript("window.scrollBy(0,350)", "");
	}
	
	public static void closeBrowser() {
		driver.close();
	}
	
	public static void screeShot(String name) {
		
		String location = System.getProperty("user.dir")+ "/" + name + ".png";
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(location);
		
		try {
			FileHandler.copy(src, des);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void explicitWait(WebElement ele, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
}
