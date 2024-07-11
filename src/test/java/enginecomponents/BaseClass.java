package enginecomponents;

import utils.WebUtilities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseClass extends WebUtilities{
  
  @Parameters({"Browser"})
  @BeforeSuite
  public void beforeSuite(String Browser) throws Exception {
	  prop();
	  reports();
	  browserLaunch("Chrome");
	  launchPage();
  }
  
  
  @BeforeClass
  public void beforeClass() {
	 test = reports.createTest(testcase);
  }

  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  
  @AfterClass
  public void afterClass() {
  }

  @AfterTest
  public void afterTest() {
  }

  @AfterSuite
  public void afterSuite() {
	  
	  closeBrowser();
	  reports.flush();
  }

}
