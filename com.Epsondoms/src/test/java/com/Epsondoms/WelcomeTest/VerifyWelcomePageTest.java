package com.Epsondoms.WelcomeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Epsondoms.GenericLibrary.BaseTest;
import com.Epsondoms.PageRepository.PageManagement;
import com.Epsondoms.javaLibrary.JavaUtility;
import com.aventstack.extentreports.Status;

public class VerifyWelcomePageTest extends BaseTest {

	@Test(priority = 1)
	public void verifyWelcomepageWithValidInput() {

		// Create the Test Information
		test = report.createTest("verifyWelcomepageWithValidInput");

		// steps Information
		test.log(Status.INFO, "<<--Execution Started Successfully--->>");

		// Execute the Preconditon-->1.Launch the Browser, 2. Navigate to URL
		test.log(Status.INFO, "Step1: Launching The Browser Successful");

		// implicit Wait
		webDriverobj.waitImplicitly(20);

		// Verify the Welcome Page Using Title
		String exptitle = "Learning Selenium";

		// Verify The Welcome Page Using Title
		Assert.assertEquals("Learning Selenium", webDriverobj.driver.getTitle());
		test.log(Status.PASS, "Title Verified");

		// create an Object For PageManager
		pageManagementobj = new PageManagement(webDriverobj.driver);

		// verify the Name TextField
		boolean result = pageManagementobj.initWelcomepage().getName().isDisplayed();

		Assert.assertTrue(result);
		test.log(Status.PASS, "Element Verified: Name TextField is Displayed");

		// Step 3: Perform Action---Clear
		pageManagementobj.initWelcomepage().getName().clear();
		test.log(Status.PASS, "step3:clear Action Done Successfully -Name Textfield");

		// Step 4: Perform actions----sendKeys
		pageManagementobj.initWelcomepage().getName().sendKeys(username);
		test.log(Status.PASS, "step 4:sendKeys Action Done Successfully -name Textfield");

		// See the Execution
		JavaUtility.pause(3000);

		// soft Assert statement
		SoftAssert softassertobj = new SoftAssert();

		// Step5: Verify the Contact us" Hyperlink
		softassertobj.assertEquals("Contact Us", pageManagementobj.initWelcomepage().getContact().getText());
		test.log(Status.PASS, "step4:Verified Text successfully- contact us HyperLink");

		softassertobj.assertAll();

		// Execution Log or Status
		test.log(Status.PASS, "<<--Execution completed successsfully-->>");

	}

	@Test(priority = 2, invocationCount = 2,  dependsOnMethods = "verifyWelcomepageWithValidInput")
	public void verifyWelcomepageWithInValidInput() {

		// Create the Test Information
		test = report.createTest("verifyWelcomepageWithValidInput");

		// Steps Information
		test.log(Status.INFO, "<<--Execution started successfully-->>");
		// Execute the Preconditon-1.Launch the Browser, 2. Navigate to URL

		// implicit Wait
		webDriverobj.waitImplicitly(20);

		// Verify the Welcome Page Using Title
		String exptitle = "Learning Selenium";
		String acttitle = webDriverobj.driver.getTitle();

		Assert.assertEquals(acttitle, exptitle);
		test.log(Status.PASS, "----Title Verified:" + acttitle);

		// create an Object For PageManager
		pageManagementobj = new PageManagement(webDriverobj.driver);

		// verify the Name TextField
		boolean result = pageManagementobj.initWelcomepage().getName().isDisplayed();

		Assert.assertTrue(result);
		test.log(Status.PASS, "Element Verified: Name TextField is Displayed");

		// Step 3: Perform Action---Clear
		pageManagementobj.initWelcomepage().getName().clear();
		test.log(Status.PASS, "step3:clear Action Done Successfully -Name Textfield");

		// Step 4: Perform actions----sendKeys
		pageManagementobj.initWelcomepage().getName().sendKeys("adfdfkjdklfj");
		test.log(Status.PASS, "step 4:sendKeys Action Done Successfully -name Textfield");

		// See the Execution
		JavaUtility.pause(3000);

		// To Make The Explicit TestScript Fail
		// Assert.fail();

		// Execute the postcondition--->1.Terminate The Browser
		// Execution Log or Status
		test.log(Status.INFO, "----Execution completed successfully--->");

	}
}
