package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentFactory {
	
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports getInstance() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./reports/Report.html");
		reporter.config().setReportName("Daraz QA Test Automation Report");
		extentReports.attachReporter(reporter);
		
		return extentReports;
	}
	
}
