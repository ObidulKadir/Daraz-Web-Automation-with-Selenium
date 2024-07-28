package Utilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import BaseDrivers.PageDriver;

public class CommonMethods {

	//Hard - Assertion Method
    public static void verifyAlertMessage(ExtentTest childTest, String actualMessage, String expectedMessage, String fieldName) {
        try {
            Assert.assertEquals(actualMessage, expectedMessage);
            childTest.log(Status.PASS, fieldName + " The alert message is as expected.");
        } catch (AssertionError e) {
            childTest.log(Status.FAIL, fieldName + " The alert message is not as expected. Expected: " + expectedMessage + ", Actual: " + actualMessage);
            throw e;
        }
    }
    
    
    public static void clickableField(ExtentTest test, WebElement xpathElement, String fieldName, String scName) throws IOException {
        WebDriverWait wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(10));

        try {
            test.info("Checking if the " + fieldName + " is displayed.");
            if (xpathElement.isDisplayed()) {
                test.info("The " + fieldName + " is displayed. Waiting for it to be clickable.");
                wait.until(ExpectedConditions.elementToBeClickable(xpathElement)); // Explicit wait for element to be clickable

                test.info("Clicking on the " + fieldName + ".");
                xpathElement.click();

                Thread.sleep(10000);

                test.info("Click on the " + fieldName + " was successful.");
                passCaseWithSC(test, "Click on the " + fieldName + " successfully.", scName + "Pass");
            } else {
                throw new Exception("The " + fieldName + " is not displayed.");
            }
        } catch (Exception e) {
            failCaseWithSC(test, "The " + fieldName + " element is unable to locate.", scName + "Fail", e);
        }
    }
    
    public static void sendKeysField(ExtentTest test, WebElement xpathElement, String elementName, String scName, String elementValue)
			throws IOException {
		try {
			test.info("Enter the " + elementName + ".");
			if (xpathElement.isDisplayed()) {
				xpathElement.click();
				xpathElement.clear();
				xpathElement.sendKeys(elementValue);
				Thread.sleep(3000);
				passCaseWithSC(test, "Entered the '" + elementName + "' successfully.", scName + "Pass");

			}
		} catch (Exception e) {
			failCaseWithSC(test, "The '" + elementName + "' element is unable to locate.", scName + "Fail", e);
		}
	}

    public static void failCaseWithSC(ExtentTest test, String message, String scName, Exception e) throws IOException {
        test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>" + message + "</b></p>");
        test.fail(e);
        String screenShotPath = Utilities.GetScreenShot.capture(PageDriver.getCurrentDriver(), scName);
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + scName + ".png";
        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
        PageDriver.getCurrentDriver().quit();
    }

    public static void passCaseWithSC(ExtentTest test, String message, String scName) throws IOException {
        test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
        String screenShotPath = Utilities.GetScreenShot.capture(PageDriver.getCurrentDriver(), scName);
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + scName + ".png";
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
    }
}
