package pagecomponents;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.WebUtilities;

public class OneWay extends WebUtilities{

	@FindBy(xpath = "(//input[contains(@class , 'css-1cwyjr8 r-homxoj')])[2]")
	WebElement to;
	
	@FindBy(xpath = "//div[text() = 'Departure Date']")
	WebElement depat_Date;
	
	@FindBy(xpath = "(//div[text() = '29'])[1]")
	WebElement travelDate;
	
	@FindBy(xpath = "//div[text() = 'Search Flight']")
	WebElement search_btn;
	
	@FindBy(xpath = "(//div[contains(@class, 'r-15d164r')])[2]")
	WebElement flightPrice;
	
	@FindBy(xpath = "(//div[text() = 'Continue'])[1]")
	WebElement continue_btn;
	
	@FindBy(xpath = "//div[text() = 'I am flying as the primary passenger']")
	WebElement passanger_checkbox;
	
	@FindBy(xpath = "//div[text() = 'Continue']")
	WebElement continueBtn2;
	
	@FindBy(xpath = "(//div[contains(@class , 'r-eafdt9 r-1i6wzkk r-lrvibr')])[26]")
	WebElement popupClose;
	
	@FindBy(xpath = "//div[@id = 'at_addon_close_icon']")
	WebElement popup2Close;
	
	@FindBy(xpath = "(//span[@id = 'skipfrompopup'])[2]")
	WebElement skipPopup;
	
	@FindBy(xpath = "(//div[text() = 'Continue'])[3]")
	WebElement continueBtn;
	
	@FindBy(xpath = "//div[@id = 'at_prepayment_close_icon']")
	WebElement payment_popupClose;
	
	@FindBy(xpath = "//input[@id ='card_number']")
	WebElement ccNumber;
	
	@FindBy(xpath ="//input[@id ='name_on_card']")
	WebElement cName;
	
	@FindBy(xpath = "//input[@id = 'card_exp_month']")
	WebElement cExpiaryMonth;
	
	@FindBy(xpath = "//input[@id = 'card_exp_year']")
	WebElement cExpiaryYear;
	
	@FindBy(xpath = "//input[@id = 'security_code']")
	WebElement cvv;
	
	@FindBy(xpath = "//div[text() = 'Proceed to pay']")
	WebElement processtoPay_Btn;
	
	public OneWay() {
		PageFactory.initElements(driver, this);
	}
	
	public void oneWayTrip() throws Exception {
	
		typeText(to, "PNQ");
		test.info("Destination PNQ text is typed");
		Thread.sleep(5000);
		buttonClick(travelDate);
		test.info("Travel Date is Selected");
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.click(search_btn).perform();
		test.info("Search Flight Button is Clicked");
		Thread.sleep(5000);
		action.click(flightPrice).perform();
		test.info("Flight price Button is Clicked");
		Thread.sleep(5000);
		action.click(continue_btn).perform();
		test.info("Continue Button is Clicked");
		Thread.sleep(5000);
		scrollPage();
		action.click(passanger_checkbox).perform();
		test.info("Passanger Check Box is clicked");
		action.click(continueBtn2).perform();
		test.info("Continue Button is Clicked");
		Thread.sleep(5000);
	}
	
	public void paymentProcess() throws Exception {
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", continueBtn);
			Actions action = new Actions(driver);
			//action.click(continueBtn).perform();
			action.click(skipPopup).build().perform();
			action.click(popupClose).perform();
			explicitWait(popup2Close, 10);
			action.click(popup2Close).perform();
			explicitWait(payment_popupClose, 10);
			action.click(payment_popupClose).perform();
			driver.switchTo().frame(1);
			typeText(ccNumber, prop.getProperty("ccNumber"));
			driver.switchTo().frame(2);
			typeText(cName, prop.getProperty("Cname"));
			driver.switchTo().frame(3);
			typeText(cExpiaryMonth, prop.getProperty("CEMonth"));
			driver.switchTo().frame(4);
			typeText(cExpiaryYear, prop.getProperty("CEYear"));
			driver.switchTo().frame(5);
			typeText(cvv, prop.getProperty("CVV"));
			driver.switchTo().defaultContent();
			action.click(processtoPay_Btn).build();
			Thread.sleep(5000);
			screeShot("OneWayTripSS");
			Thread.sleep(5000);
			driver.navigate().to("https://www.spicejet.com/");
		
	}
	
	
	
}
