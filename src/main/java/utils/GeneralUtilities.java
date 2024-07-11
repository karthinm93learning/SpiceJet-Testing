package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GeneralUtilities {
	
	public static Properties prop;
	public static ExtentReports reports;
	public static ExtentTest test;

	public static void prop() throws Exception {
		
		String path = System.getProperty("user.dir") + "/datas.properties";
		FileInputStream file = new FileInputStream(path);
		prop = new Properties();
		prop.load(file);
	}
	
	public static void reports() {
		
		ExtentSparkReporter html = new ExtentSparkReporter("./Report.html");
		reports = new ExtentReports();
		reports.attachReporter(html);
	}
	
}
