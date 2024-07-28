package BaseDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {

	WebDriver driver;

	protected static final java.lang.String url = "https://www.daraz.com.bd/";

	@BeforeSuite
	public void StartBrowser() throws InterruptedException {
		java.lang.String browserName = System.getProperty("browser", "chrome");

		if(browserName.equals("chrome")){

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		}else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		PageDriver.getInstance().setDriver(driver);

	}


	@AfterSuite
	public void CloseBrowser() {
		driver.quit();
	}
}
