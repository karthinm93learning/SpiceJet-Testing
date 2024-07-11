package testcomponents;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import enginecomponents.BaseClass;
import pagecomponents.MenuValidation;

public class MenuValidationTest extends BaseClass{

	@BeforeTest
	public void beforeTest() throws IOException {
		
		 //Db connect, Excel connect, property file
		testcase = "testMenuValidation";
		
	}
	
	@Test
	public void testMenuValidation() throws Exception {
		
		MenuValidation obj = new MenuValidation();
		obj.menuVisible();
		test.pass("Menu Validation testcase are pass",
			MediaEntityBuilder.createScreenCaptureFromPath("MenuVisiblitySS.png").build());
	}
}
