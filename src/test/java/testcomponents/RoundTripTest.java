package testcomponents;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import enginecomponents.BaseClass;
import pagecomponents.RoundTrip;

public class RoundTripTest extends BaseClass{

	@BeforeTest
	public void beforeTest() throws Exception {
		
		prop(); //Db connect, Excel connect, property file
		testcase = "testRoundTrip";
		
	}
	
	@Test
	public void testRoundTrip() throws Exception {
		
		RoundTrip obj = new RoundTrip();
		obj.roundTrip();
	}
}
