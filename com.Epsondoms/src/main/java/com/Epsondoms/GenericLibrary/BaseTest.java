package com.Epsondoms.GenericLibrary;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.Epsondoms.ExcelFileLibrary.ReadExcelFile;
import com.Epsondoms.PageRepository.PageManagement;
import com.Epsondoms.PropertyFileLibrary.ReadPropertyFile;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import WebDriverLibrary.WebDriverUtility;

/**
 * This Class Is Used For Configure All The PreCondition And PostCondition For TestScript
 * And Also Initializing All The Library-Utility Classes
 * 
 * 
 * @author rehana23
 */
public class BaseTest {

	public PageManagement pageManagementobj;
	public WebDriverUtility webDriverobj;
	public ReadExcelFile excelutilityobj;
	public String username;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	public ReadPropertyFile propertyfileobj;

	@BeforeSuite
	public void suiteSetup() {
		// Create the SparkReport
		spark = new ExtentSparkReporter("./AdvanceReports/report.html");

		// Configure the SparkReport Information
		spark.config().setDocumentTitle("Regression Testing for the learningSelenium Page");
		spark.config().setReportName("RegressionSuite||Verification of Welcome Page");
		spark.config().setTheme(Theme.STANDARD);

		// create the Extent Report
		report = new ExtentReports();

		// Attach the Spark Report and ExtentReport
		report.attachReporter(spark);

		// configure the System Information in Extent Report
		report.setSystemInfo("DeviceName:", "Harry");
		report.setSystemInfo("OpeningSystem:", "WINDOWS 11");
		report.setSystemInfo("Browser:", "Chrome");
		report.setSystemInfo("BrowserVersion:", "chrome-128.0.6613.85");
	}

	@AfterSuite
	public void suiteTerminateSetup() {
		// Flush the Report Information
		report.flush();
	}

	@Parameters({ "browsername", "weburl" })
	@BeforeClass
	public void browserSetup(String browser, String url) {
		// Create Object for All the Repository/Utility
		createObjects();

		// Fetch The Username From Excel File
		username = excelutilityobj.readSingleData("RegisterData", 1, 1);

		// Step1: Launch the Browser
		webDriverobj.launchBrowser(browser);
		Reporter.log("Step1: Launch the Browser Success", true);

		// Maximize the Browser
		webDriverobj.maximizeTheBrowser();
		Reporter.log("Step1.1:Maximized Browser Sucess", true);

		// Step 2: Navigating to the Application via URL
		webDriverobj.NavigateToApplication(url);
		Reporter.log("Step2: Navigating the Application via URL Success", true);
	}

	// Browser Termination
	@AfterClass
	public void browserTermination() {
		// Step 10: close the Browser
		webDriverobj.closeAllBrowser();
		Reporter.log("Step10: Close the Browser Success", true);
	}

	public void createObjects() {
		webDriverobj = new WebDriverUtility();
		excelutilityobj = new ReadExcelFile();
		propertyfileobj=new ReadPropertyFile();
	}
}
