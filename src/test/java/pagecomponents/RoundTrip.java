package pagecomponents;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WebUtilities;

public class RoundTrip extends WebUtilities{

	@FindBy(xpath = "(//div[@class = 'css-1dbjc4n r-zso239'])[2]")
	WebElement roundtrip_radioBtn;
	
	@FindBy(xpath = "(//input[contains(@class , 'css-1cwyjr8 r-homxoj')])[2]")
	WebElement to;
	
	@FindBy(xpath = "//div[text() = '27']")
	WebElement dep_dates;
	
	@FindBy(xpath = "(//div[@class = 'css-1dbjc4n r-1awozwy r-14lw9ot r-1loqt21 r-eu3ka r-1otgn73 r-1aockid']//child::div[text() = '10'])[2]")
	WebElement ret_dates;
	
	@FindBy(xpath = "//div[text() = 'Search Flight']")
	WebElement search_btn;
	
	@FindBy(xpath = "(//div[contains(@class, 'r-15d164r')])[2]")
	WebElement dep_flightPrice;
	
	@FindBy(xpath = "(//div[contains(@class, 'r-15d164r')])[7]")
	WebElement ret_flightPrice;
	
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
	
	@FindBy(xpath = "(//img[@class = 'css-9pa8cd'])[1]")
	WebElement spicejetIcon;
	
	public RoundTrip() {
		PageFactory.initElements(driver, this);
	}
	
	public void roundTrip() throws Exception {
		linkClick(roundtrip_radioBtn);
		typeText(to, "HYD");
		Thread.sleep(6000);
		buttonClick(dep_dates);
		buttonClick(ret_dates);
		Actions action = new Actions(driver);
		action.click(search_btn).perform();
		Thread.sleep(6000);
		action.click(dep_flightPrice).perform();
		Thread.sleep(5000);
		scrollPage();
		action.click(ret_flightPrice).perform();
		Thread.sleep(5000);
		action.click(continue_btn).perform();
		Thread.sleep(5000);
		scrollPage();
		action.click(passanger_checkbox).perform();
		action.click(continueBtn2).perform();
		Thread.sleep(5000);
		action.click(popupClose).perform();
		explicitWait(popup2Close, 10);
		action.click(popup2Close).perform();
		action.click(continueBtn).perform();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		typeText(ccNumber, prop.getProperty("ccNumber"));
		driver.switchTo().frame(1);
		typeText(cName, prop.getProperty("Cname"));
		driver.switchTo().frame(2);
		typeText(cExpiaryMonth, prop.getProperty("CEMonth"));
		driver.switchTo().frame(3);
		typeText(cExpiaryYear, prop.getProperty("CEYear"));
		driver.switchTo().frame(4);
		typeText(cvv, prop.getProperty("CVV"));
		driver.switchTo().defaultContent();
		action.click(processtoPay_Btn).build();
		Thread.sleep(5000);
		screeShot("RoundTripSS");
				
	}
}
