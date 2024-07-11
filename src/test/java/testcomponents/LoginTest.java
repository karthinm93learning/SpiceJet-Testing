package testcomponents;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import enginecomponents.BaseClass;
import pagecomponents.Login;

public class LoginTest extends BaseClass{

	@BeforeTest
	public void beforeTest() throws Exception {
		
		 //Db connect, Excel connect, property file
		testcase = "testLogin";
	}
	
	@Test
	public void testLogin() throws Exception {
		
		Login obj = new Login();
		obj.login();
		test.pass("Login testcase is Pass", 
			MediaEntityBuilder.createScreenCaptureFromPath("LoginSS.png").build());
		
	}
	
}
