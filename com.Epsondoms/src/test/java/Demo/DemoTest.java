package Demo;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class DemoTest {

	@Test
	public void DemoTesting1()
	{
		//Create the SparkReport
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReports/report.html");
		
		//Configure the SparkReport Information
		spark.config().setDocumentTitle("Regression Testing for the learningSelenium Page");
		spark.config().setReportName("RegressionSuite");
		spark.config().setTheme(Theme.DARK);
		
		//create the Extent Report
		ExtentReports report=new ExtentReports();
		
		//Attach the Spark Report and ExtentReport
		report.attachReporter(spark);
		
		//configure the System Information in Extent Report
		report.setSystemInfo("DeviceName:", "Harry");
		report.setSystemInfo("OpeningSystem:", "WINDOW 11");
		report.setSystemInfo("Browser:", "Chrome");
		report.setSystemInfo("BrowserVersion:", "chrome-128.0.6613.85");
		
		//Create the Test Information
		ExtentTest test=report.createTest("Regressiontest");
		
		
		//steps Information
		test.log(Status.INFO,"Step1:Launch The Browser Successful");
		test.log(Status.INFO,"Step2: Navigation To Application via URl Successful");
		test.log(Status.PASS,"Step3:veified the Webpage Successful");
		
		if("Harry".equals("Harry")) {
			test.log(Status.PASS,"Step4:verified the WebElement Displayed");
		}else {
			test.log(Status.FAIL,"Step4:verified the WebElements Not Displayed");
		}
		
		//test.log(Status.SKIP,"Step5:Element is Hidden");
		
		//Flush the Report Information
		report.flush();
		System.out.println("Execution done");
		}
	

	@Test
	public void DemoTesting2()
	{
		
		
		
	}
	

	@Test
	public void DemoTesting3()
	{
		
		
	}
	

	@Test
	public void DemoTesting4()
	{
		
	}
	

	@Test
	public void DemoTesting5()
	{
		
	}
	}
	
	
		
	


