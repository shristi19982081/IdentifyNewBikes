package TestUsingTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import Common.SelectBrowser;
import UtilityFiles.CaptureScreenshot;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver = null;
	public String filePath = null;
	public static String browser = null;
	public static ExtentHtmlReporter reporter = new ExtentHtmlReporter(
			System.getProperty("user.dir") + "/ExtentReport/extentReportFile.html");
	public static ExtentReports extent = new ExtentReports();

	@BeforeSuite
	public void initBrowser() {
		// Selecting the browser for test
		browser = SelectBrowser.selectBrowser();
	}

	@BeforeTest
	public void initializeTest() throws Exception {

		// Launching the browser according to user's choice
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Driver Test");
		logger.log(Status.INFO, "Browser launched");

		// To maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// To go to the webpage
		driver.get("https://www.zigwheels.com/");
		logger.log(Status.INFO, "Navigated to https://www.zigwheels.com/");

		// For capturing the screenshot
		filePath = System.getProperty("user.dir") + "/Screenshots/HomePage.png";
		CaptureScreenshot.captureTestScreenshot(driver, filePath);
		logger.log(Status.INFO, "Homepage Snapshot: ");
		logger.addScreenCaptureFromPath(filePath);

	}

	@AfterTest
	public void closeDriver() {
		// Close the driver
		driver.close();
	}

	@AfterSuite
	public void exitDriver() {
		// Quit the driver
		driver.quit();
	}

}
