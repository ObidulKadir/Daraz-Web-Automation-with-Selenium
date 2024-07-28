package TestCase;

import java.io.IOException;

import org.apache.hc.core5.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;

import BaseDrivers.PageDriver;
import Pages.Home;
import Pages.Registration;
import Utilities.CommonMethods;
import Utilities.ExtentFactory;

public class RegistrationPageTestCase {
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	
	
	@BeforeClass
	public void StartUrl() {
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Registration Page</b></p>").assignAuthor("QA Team").assignDevice("Windows");
		
	}
	
	@Test (priority = 0)
	public void RTC_1() throws IOException {
		childTest = parentTest.createNode("<p style=\\\\\"color:#3E96E7; font-size:20px\\\\\\\"><b>Verify the Phone Number\r\n"
				+ ".</b></p>");
		Registration rp = new Registration(childTest);
		CommonMethods.sendKeysField(childTest, rp.phoneNumber, "Phone Number","PhoneNumberField" , "jhg3f3");
	}
	
	@Test (priority = 1)
	public void RTC_2() throws IOException {
		childTest = parentTest.createNode("<p style=\\\\\"color:#3E96E7; font-size:20px\\\\\\\"><b>Verify the Phone Number onfield alert\r\n"
				+ ".</b></p>");
		Registration rp = new Registration(childTest);
		String expectedPhoneNoAlert = "Please enter a valid phon number.";
		String ActualPhoneNoAlert = rp.phoneNumberError.getText();
		
        CommonMethods.verifyAlertMessage(childTest, ActualPhoneNoAlert, expectedPhoneNoAlert, "Phone Number");
	}
	
	@Test (priority = 2)
	public void RTC_3() throws IOException {
		childTest = parentTest.createNode("<p style=\\\\\"color:#3E96E7; font-size:20px\\\\\\\"><b>Verify the Full Name\r\n"
				+ ".</b></p>");
		Registration rp = new Registration(childTest);
		CommonMethods.sendKeysField(childTest,rp.fullName, "Full Name", "FullName", "ABC");
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}
}
