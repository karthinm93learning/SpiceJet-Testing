package pagecomponents;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.WebUtilities;

public class MenuValidation extends WebUtilities{

	@FindBy(xpath= "//div[text() = 'check-in']")
	WebElement checkIn;
	
	@FindBy(xpath= "//div[text() = 'flight status']")
	WebElement flightStatus;
	
	@FindBy(xpath= "//div[text() = 'manage booking']")
	WebElement manageBookings;
	
	public MenuValidation() {
		PageFactory.initElements(driver, this);
	}
	
	public void menuVisible() throws Exception {
		
		Assert.assertTrue(checkIn.isDisplayed());
		test.info("Check In menu is Visible");
		Assert.assertTrue(flightStatus.isDisplayed());
		test.info("Flight Status menu is Visible");
		Assert.assertTrue(manageBookings.isDisplayed());
		test.info("Manage Bookings menu is Visible");
		screeShot("MenuVisiblitySS");
		Thread.sleep(5000);
	}
}
