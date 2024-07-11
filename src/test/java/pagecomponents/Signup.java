package pagecomponents;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WebUtilities;

public class Signup extends WebUtilities{

	@FindBy(xpath = "//div[text() = 'Signup']")
	WebElement signup_Link;
	
	@FindBy(xpath = "//select[@class = 'form-control form-select ']")
	WebElement prefix_name;
	
	@FindBy(id = "first_name")
	WebElement firstname;
	
	@FindBy(id = "last_name")
	WebElement lastname;
	
	@FindBy(id = "dobDate")
	WebElement dob;
	
	@FindBy(xpath = "//input[@class = ' form-control']")
	WebElement mobilenumber;
	
	@FindBy(xpath = "//input[@id = 'email_id']")
	WebElement emailID;
	
	@FindBy(id = "new-password")
	WebElement password;
	
	@FindBy(id = "c-password")
	WebElement confirmPassword;
	
	@FindBy(xpath = "//input[@id ='defaultCheck1']")
	WebElement iAgree;
	
	@FindBy(xpath = "//button[text() = 'Submit']")
	WebElement submit_btn;
	
	@FindBy(xpath = "//div[@class = 'p-5']")
	WebElement image;

	public Signup() {
		PageFactory.initElements(driver, this);
	}
	
	public void signUpProcess() throws Exception {
		String Parentwindows = driver.getWindowHandle();
		linkClick(signup_Link);
		test.info("Signup Link is Clicked");
		Set <String> childwindows = driver.getWindowHandles();
		List<String> listwindows = new ArrayList<String>(childwindows);
		driver.switchTo().window(listwindows.get(1));
		test.info("Driver Control is moved to Child Window");
		listDropdown(prefix_name, "Mr");
		test.info("Name lable is Selected");
		typeText(firstname, prop.getProperty("firstname"));
		test.info("Firstname is typed");
		typeText(lastname, prop.getProperty("lastname"));
		test.info("Lastname is typed");
		scrollPage();
		typeText(dob, prop.getProperty("DOB"));
		test.info("Date of Birth is typed");
		linkClick(image);
		typeText(mobilenumber, prop.getProperty("mobilenumber"));
		test.info("Mobile is typed");
		Thread.sleep(5000);
		typeText(emailID, prop.getProperty("email"));
		test.info("Email is typed");
		linkClick(image);
		Thread.sleep(5000);
		typeText(password, prop.getProperty("password"));
		test.info("Password is typed");
		typeText(confirmPassword, prop.getProperty("ConPassword"));
		test.info("Confirm Password is typed");
		iAgree.click();
		test.info("I Agree Button is Clicked");
		Actions action = new Actions(driver);
		action.click(submit_btn).build().perform();
		test.info("Submit Button is clicked");
		Thread.sleep(5000);
		screeShot("SignupScreenshot");
		driver.close();
		driver.switchTo().window(Parentwindows);
	}
}
