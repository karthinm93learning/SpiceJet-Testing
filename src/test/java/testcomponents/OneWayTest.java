package testcomponents;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import enginecomponents.BaseClass;
import pagecomponents.OneWay;

public class OneWayTest extends BaseClass{

	@BeforeTest
	public void beforeTest() throws Exception {
		
		prop(); //Db connect, Excel connect, property file
		testcase = "testOneWayTrip";
	}
	
	@Test
	public void testOneWayTrip() throws Exception {
		
		OneWay obj = new OneWay();
		obj.oneWayTrip();
		obj.paymentProcess();
		test.pass("Oneway testcase is Pass", 
			MediaEntityBuilder.createScreenCaptureFromPath("OneWayTripSS.png").build());
	}
	
}
