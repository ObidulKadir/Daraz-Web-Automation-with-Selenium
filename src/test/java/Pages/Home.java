package Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
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

public class Home extends BaseDriver {

	ExtentTest test;

	public Home(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}

	// SignUp

	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	public WebElement signUp;

}
