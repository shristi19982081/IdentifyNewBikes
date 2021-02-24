package Common;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

	public static WebDriver driver;
	public static String url = "https://www.zigwheels.com/";
	public static String browsertype;

	// Instantiation of chrome and mozilla firefox browser
	public static WebDriver driverInstantiate(String browser) {
Wait wait=new Wait();
		browsertype = browser;
		if (browsertype.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browsertype.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browsertype.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		// To maximize the window
		driver.manage().window().maximize();
	wait.waitImplicit(driver);
		// To go to the webpage
		driver.get(url);

		return driver;

	}

}
