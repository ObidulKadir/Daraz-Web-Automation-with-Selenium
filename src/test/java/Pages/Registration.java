package Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import BaseDrivers.BaseDriver;
import BaseDrivers.PageDriver;


public class Registration extends BaseDriver {

	ExtentTest test;

	public Registration(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}

	// xpath
	@FindBy(xpath = "//input[@placeholder='Please enter your phone number']")
	public WebElement phoneNumber;

	@FindBy(xpath = "//span[contains(text(),'Please enter a valid phone numbe.')]")
	public WebElement phoneNumberError;

	@FindBy(xpath = "//input[@placeholder='Enter your first and last name']")
	public WebElement fullName;
	

}
