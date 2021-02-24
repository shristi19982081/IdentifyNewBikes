package UsedCars;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import UtilityFiles.Highlighter;
import UtilityFiles.WriteToExcel;

public class UsedCars {
	WebDriver driver;
	public String filePath = null;

	public UsedCars(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//header/div[1]/div[2]/div[1]/div[2]/ul[1]/li[5]/a[1]")
	WebElement usedCarsMenu;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Find Used Cars')]")
	WebElement findUsedCars;

	@FindBy(how = How.LINK_TEXT, using = "Chennai")
	WebElement chennaiCity;

	@FindBy(how = How.CSS, using = "#bycarid10_146")
	WebElement eleHyundai;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Hyundai i10')]")
	List<WebElement> hyundaiModels;

	@FindBy(how = How.CSS, using = "#bycarid10_156")
	WebElement eleHyundaisantro;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Hyundai Santro Xing')]")
	List<WebElement> hyundaiSantroModels;

	@FindBy(how = How.CSS, using = "#bycarid21_314")
	WebElement eleMahindra;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Mahindra XUV500')]")
	List<WebElement> mahindraModels;

	@FindBy(how = How.CSS, using = "#bycarid13_205")
	WebElement eleToyota;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Toyota Fortuner')]")
	List<WebElement> toyotaModels;

	@FindBy(how = How.CSS, using = "#bycarid13_207")
	WebElement eleToyota2;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Toyota Innova')]")
	List<WebElement> toyotaInoModels;

	public void usedCarsMenu() {

		Actions actions = new Actions(driver);
		filePath = System.getProperty("user.dir") + "/Screenshots/UsedCars/UsedCarsMenu.png";
		Highlighter.highLightElement(driver, usedCarsMenu, filePath);

		actions.moveToElement(usedCarsMenu).perform();

		System.out.println("Done Mouse hover on 'Used cars' from Menu");

	}

	public void selectFindUsedCars() {

		filePath = System.getProperty("user.dir") + "/Screenshots/UsedCars/FindUsedCarsMenu.png";
		Highlighter.highLightElement(driver, findUsedCars, filePath);
		findUsedCars.click();

	}

	public void selectChennaiCity() throws InterruptedException {

		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		filePath = System.getProperty("user.dir") + "/Screenshots/UsedCars/UsedCarsInChennai.png";
		Highlighter.highLightElement(driver, chennaiCity, filePath);
		chennaiCity.click();
		driver.switchTo().window(winHandleBefore);

	}

	public void selectFirstModel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 300)");

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", eleHyundai);
		filePath = System.getProperty("user.dir") + "/Screenshots/UsedCars/HyundaiI10models.png";
		Highlighter.highLightElement(driver, eleHyundai, filePath);

	}

	public void printFirstModelList() throws IOException {
		// create an empty list in which the label texts will be stored
		List<String> labelsList = new ArrayList<String>();
		// iterate through all the webElements
		for (WebElement webElement : hyundaiModels) {
			// add each webElements label to the labelsList
			labelsList.add(webElement.getText());
		}
		WriteToExcel.usedCarsOutputToExcel("Hyundai", "Hyundai", labelsList);
		System.out.println("Following is the list of Hyundai i10 models:");
		for (int i = 0; i < labelsList.size(); i++) {
			System.out.println(labelsList.get(i));
		}

	}

	public void selectSecondModel() {
		// Deselecting earlier popular model
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", eleHyundai);

		JavascriptExecutor executor2 = (JavascriptExecutor) driver;

		executor2.executeScript("arguments[0].click();", eleHyundaisantro);
		filePath = System.getProperty("user.dir") + "/Screenshots/UsedCars/HyundaisantroModels.png";
		Highlighter.highLightElement(driver, eleHyundaisantro, filePath);

	}

	public void printSecondModelList() throws IOException {
		// create an empty list in which the label texts will be stored
		List<String> labelsList = new ArrayList<String>();
		// iterate through all the webElements
		for (WebElement webElement : hyundaiSantroModels) {
			// add each webElements label to the labelsList
			labelsList.add(webElement.getText());
		}
		WriteToExcel.usedCarsOutputToExcel("Hyundai Santro", "Hyundai Santro", labelsList);
		System.out.println("Following is the list of Hyundai Santro xing models:");
		for (int i = 0; i < labelsList.size(); i++) {
			System.out.println(labelsList.get(i));
		}

	}

	public void selectThirdModel() {
		// Deselecting earlier popular model
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", eleHyundaisantro);

		JavascriptExecutor executor2 = (JavascriptExecutor) driver;

		executor2.executeScript("arguments[0].click();", eleMahindra);
		filePath = System.getProperty("user.dir") + "/Screenshots/UsedCars/MahindraXUVModels.png";
		Highlighter.highLightElement(driver, eleMahindra, filePath);

	}

	public void printThirdModelList() throws IOException {
		// create an empty list in which the label texts will be stored
		List<String> labelsList = new ArrayList<String>();
		// iterate through all the webElements
		for (WebElement webElement : mahindraModels) {
			// add each webElements label to the labelsList
			labelsList.add(webElement.getText());
		}
		WriteToExcel.usedCarsOutputToExcel("Mahindra", "Mahindra", labelsList);
		System.out.println("Following is the list of Mahindra XUV models:");
		for (int i = 0; i < labelsList.size(); i++) {
			System.out.println(labelsList.get(i));
		}

	}

	public void selectForthModel() throws InterruptedException {

		// Deselecting earlier popular model
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("arguments[0].click();", eleMahindra);

		JavascriptExecutor executor = (JavascriptExecutor) driver;

		executor.executeScript("arguments[0].click();", eleToyota);
		filePath = System.getProperty("user.dir") + "/Screenshots/UsedCars/ToyotaFortunerModels.png";
		Highlighter.highLightElement(driver, eleToyota, filePath);

	}

	public void printForthModelList() throws IOException {
		// create an empty list in which the label texts will be stored
		List<String> labelsList = new ArrayList<String>();
		// iterate through all the webElements
		for (WebElement webElement : toyotaModels) {
			// add each webElements label to the labelsList
			labelsList.add(webElement.getText());
		}
		WriteToExcel.usedCarsOutputToExcel("Toyota Fortuner", "Toyota Fortuner", labelsList);
		System.out.println("Following is the list of Toyota Fortuner models:");
		for (int i = 0; i < labelsList.size(); i++) {
			System.out.println(labelsList.get(i));
		}

	}

	public void selectFifthModel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 300)");
		// Deselecting earlier popular model
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", eleToyota);

		JavascriptExecutor executor2 = (JavascriptExecutor) driver;

		executor2.executeScript("arguments[0].click();", eleToyota2);
		filePath = System.getProperty("user.dir") + "/Screenshots/UsedCars/ToyotaInnovaModels.png";
		Highlighter.highLightElement(driver, eleToyota2, filePath);

	}

	public void printFifthModelList() throws IOException {
		// create an empty list in which the label texts will be stored
		List<String> labelsList = new ArrayList<String>();
		// iterate through all the webElements
		for (WebElement webElement : toyotaInoModels) {
			// add each webElements label to the labelsList
			labelsList.add(webElement.getText());
		}
		WriteToExcel.usedCarsOutputToExcel("Toyota Innova", "Toyota Innova", labelsList);
		System.out.println("Following is the list of Toyota Innova models:");
		for (int i = 0; i < labelsList.size(); i++) {
			System.out.println(labelsList.get(i));
		}
	}

}
