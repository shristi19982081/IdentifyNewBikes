package TestUsingTestNG;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import UsedCars.UsedCars;

public class UsedCarsTest extends TestBase {

	@Test
	public void testUsedCars() throws Exception {

		UsedCars cars = PageFactory.initElements(driver, UsedCars.class);

		// Calling the usedCarsMenu function
		cars.usedCarsMenu();
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest("Used Cars in Chennai Test");
		logger.log(Status.INFO, "Mouse Hover on 'Used Cars'");

		// Calling the selectFindUsedCars function
		cars.selectFindUsedCars();
		logger.log(Status.INFO, "Find Used Cars submenu is selected");

		// Calling the selectChennaiCity function
		cars.selectChennaiCity();
		logger.log(Status.INFO, "Chennai is selected as Location");

		// Calling the selectFirstModel function
		cars.selectFirstModel();
		logger.log(Status.INFO, "Hyundai i10 model is selected");

		// Calling the printFirstModelList function
		cars.printFirstModelList();
		logger.log(Status.INFO, "All Hyundai i10 cars are displayed on console and stored in excel");

		// Calling the selectSecondModel function
		cars.selectSecondModel();
		logger.log(Status.INFO, "Hyundai Santro model is selected");

		// Calling the printSecondModelList function
		cars.printSecondModelList();
		logger.log(Status.INFO, "All Hyundai Santro cars are displayed on console and stored in excel");

		// Calling the selectThirdModel function
		cars.selectThirdModel();
		logger.log(Status.INFO, "Mahindra XUV model is selected");

		// Calling the printThirdModelList function
		cars.printThirdModelList();
		logger.log(Status.INFO, "All Mahindra XUV cars are displayed on console and stored in excel");

		// Calling the selectForthModel function
		cars.selectForthModel();
		logger.log(Status.INFO, "Toyota Fortuner model is selected");

		// Calling the printForthModelList function
		cars.printForthModelList();
		logger.log(Status.INFO, "All Toyota Fortuner cars are displayed on console and stored in excel");

		// Calling the selectFifthModel function
		cars.selectFifthModel();
		logger.log(Status.INFO, "Toyota Innova model is selected");

		// Calling the printFifthModelList function
		cars.printFifthModelList();
		logger.log(Status.INFO, "All Toyota Innova cars are displayed on console and stored in excel");

		logger.log(Status.PASS, "Used cars in chennai test is passed");

		// writing everything to document.
		extent.flush();
	}
}
