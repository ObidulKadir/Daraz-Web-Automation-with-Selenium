package TestCase;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import BaseDrivers.BaseDriver;
import BaseDrivers.PageDriver;
import Pages.Home;
import Utilities.CommonMethods;
import Utilities.ExtentFactory;

public class HomePageTestCase extends BaseDriver {

	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void StartUrl() {
		PageDriver.getCurrentDriver().get(url);
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Home Page</b></p>").assignAuthor("QA Team").assignDevice("Windows");
		
	}
	
	
	@Test (priority = 0)
	public void HTC_1() throws IOException {
		childTest = parentTest.createNode("<p style=\\\\\"color:#3E96E7; font-size:20px\\\\\\\"><b>Verify the SignUp option.</b></p>");
		Home hp = new Home(childTest);
		CommonMethods.clickableField(childTest, hp.signUp, "Sign Up", "SignUp");
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}
}
