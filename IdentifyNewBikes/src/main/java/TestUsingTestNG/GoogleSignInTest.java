package TestUsingTestNG;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Common.Wait;
import GoogleSignIn.GoogleSignIn;
import UtilityFiles.ReadFromExcel;

public class GoogleSignInTest extends TestBase {
Wait wait=new Wait();

	@Test
	public void testGoogleSignIn() throws Exception {

		// Reading data from excel
		String emailId = ReadFromExcel.readFromExcel(0, 0);
		GoogleSignIn signInTest = PageFactory.initElements(driver, GoogleSignIn.class);

		// Calling the clickSignIn function
		signInTest.clickSignIn();
		wait.waitImplicit(driver);
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Google Sign In Test");
		logger.log(Status.INFO, "Sign In button is clicked");
		
		// Calling the googleSignIn function
		signInTest.googleSignIn();
		wait.waitImplicit(driver);
		logger.log(Status.INFO, "Continue with Google button is clicked");

		// Calling the emailInput function
		signInTest.emailInput(emailId);
		wait.waitImplicit(driver);
		logger.log(Status.INFO, "An invalid email id is entered into Email field");

		// Calling the emailNext function
		signInTest.emailNext();
		wait.waitImplicit(driver);
		logger.log(Status.INFO, "Next button is clicked after entering the invalid email id");

		// Calling the getErrorMessage function
		signInTest.getErrorMessage();
		wait.waitImplicit(driver);
		logger.log(Status.INFO,
				"Error message is captured successfully and stored in excel as well as displayed on console");

		logger.log(Status.PASS, "Google Sign In test is passed");

		// writing everything to document.
		extent.flush();
	}
}
