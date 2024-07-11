package testcomponents;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import enginecomponents.BaseClass;
import pagecomponents.Signup;

public class SignUpTest extends BaseClass{

	@BeforeTest
	public void beforeTest() throws Exception {
		
		prop(); //Db connect, Excel connect, property file
		testcase = "testSignup";
	}
	
	@Test
	public void testSignup() throws Exception {
		
		Signup obj = new Signup();
		obj.signUpProcess();
		test.pass("Signup test is Pass", 
				MediaEntityBuilder.createScreenCaptureFromPath("SignupScreenshot.png").build());
	}
}
