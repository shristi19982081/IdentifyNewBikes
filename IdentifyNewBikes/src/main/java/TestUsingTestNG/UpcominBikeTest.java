package TestUsingTestNG;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import UpcomingBikes.UpcomingBikes;
import UtilityFiles.ReadFromExcel;

public class UpcominBikeTest extends TestBase {

	@Test
	public void testUpcomingBike() throws Exception {

		// Reading data from Excel file
		String manufacturerName = ReadFromExcel.readFromExcel(1, 0);
		UpcomingBikes bike = PageFactory.initElements(driver, UpcomingBikes.class);
		// Calling the newBikesMenu function
		bike.newBikesMenu();
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Upcoming Bikes Test");
		logger.log(Status.INFO, "Mouse Hover on 'New Bikes'");

		// Calling the selectUpcomingBike function
		bike.selectUpcomingBike();
		logger.log(Status.INFO, "Upcoming Bikes submenu is selected");

		// Calling the selectManufacturer function
		bike.selectManufacturer(manufacturerName);
		logger.log(Status.INFO, "Manufacturer name is selected as 'Honda'");

		// Calling the viewMoreBikes function
		bike.viewMoreBikes();
		logger.log(Status.INFO, "View More button is clicked");

		// Calling the bikeModels function
		bike.bikeModels();
		logger.log(Status.INFO, "Upcoming Bikes under 4 lac is displayed on console and stored in Excel");

		logger.log(Status.PASS, "Upcoming Bikes test is passed");

		// writing everything to document.
		extent.flush();
	}

}
