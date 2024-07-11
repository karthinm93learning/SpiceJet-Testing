package pagecomponents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WebUtilities;

public class Login extends WebUtilities{

	@FindBy(xpath = "//div[text() = 'Login']")
	WebElement login_link;
	
	@FindBy(xpath = "(//div[@class = 'css-1dbjc4n r-zso239'])[4]")
	WebElement email_radio_btn;
	
	@FindBy(xpath = "(//div[contains(@class, 'css-1dbjc4n r-1awozwy')]//child::input)[3]")
	WebElement emailField;
	
	@FindBy(xpath = "(//div[contains(@class, 'css-1dbjc4n r-1awozwy')]//child::input)[4]")
	WebElement passwordField;
	
	@FindBy(xpath = "//div[text() = 'LOGIN']")
	WebElement loginbtn;
	
	public Login() {
		PageFactory.initElements(driver, this);
	}
	
	public void login() throws Exception {
		
		linkClick(login_link);
		test.info("Login Link is Clicked");
		explicitWait(email_radio_btn, 5);
		linkClick(email_radio_btn);
		test.info("Email radio Button is Clicked");
		typeText(emailField, "karthi123@gmail.com");
		test.info("EmailID is Typed");
		typeText(passwordField, "Testing@1234");
		test.info("Password is Typed");
		Actions action = new Actions(driver);
		action.click(loginbtn).perform();
		test.info("Login Button is Clicked");
		Thread.sleep(7000);
		screeShot("LoginSS");
	}
	
}
