package UpcomingBikes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import Common.Wait;
import UtilityFiles.Highlighter;
import UtilityFiles.WriteToExcel;

public class UpcomingBikes {

	WebDriver driver;
	public String filePath = null;
	
	public UpcomingBikes(WebDriver driver) {
		this.driver = driver;
	}


	@FindBy(how = How.XPATH, using = "//a[contains(text(),'New Bikes')]")
	WebElement newBikesMenu;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Upcoming Bikes')]")
	WebElement upcomingBikes;
	@FindBy(how = How.ID, using = "makeId")
	WebElement manufacturer;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'View More Bikes')]")
	WebElement viewMore;
	@FindBy(how = How.XPATH, using = "//*[@id='carModels']/ul")
	WebElement hondaBikeModels;

	public void newBikesMenu() {

		Actions action = new Actions(driver);
		filePath = System.getProperty("user.dir") + "/Screenshots/UpcomingBikes/NewBikesMenu.png";
		Highlighter.highLightElement(driver, newBikesMenu, filePath);
		action.moveToElement(newBikesMenu).perform();
	}

	public void selectUpcomingBike() {
		filePath = System.getProperty("user.dir") + "/Screenshots/UpcomingBikes/UpcomingBikeMenu.png";
		Highlighter.highLightElement(driver, upcomingBikes, filePath);
		upcomingBikes.click();
	}

	public void selectManufacturer(String bikeManufacturer) {

		Select select = new Select(manufacturer);
		filePath = System.getProperty("user.dir") + "/Screenshots/UpcomingBikes/ManufacturerDropdown.png";
		Highlighter.highLightElement(driver, manufacturer, filePath);
		select.selectByVisibleText(bikeManufacturer);
	}

	public void viewMoreBikes() {
Wait wait=new Wait();
		Actions action = new Actions(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", viewMore);
		wait.waitImplicit(driver);
		filePath = System.getProperty("user.dir") + "/Screenshots/UpcomingBikes/ViewMore.png";
		Highlighter.highLightElement(driver, viewMore, filePath);
		action.moveToElement(viewMore).click(viewMore).perform();
	}

	public void bikeModels() throws IOException {
		String bikeModels = hondaBikeModels.getText();

		ArrayList<String> bikeModelsElements = new ArrayList<String>();
		Collections.addAll(bikeModelsElements, bikeModels.split("\n"));

		ArrayList<String> NameList = new ArrayList<String>();
		ArrayList<String> DateList = new ArrayList<String>();
		ArrayList<String> PriceList = new ArrayList<String>();
		String[] arr = null;
		for (int i = 0; i < bikeModelsElements.size(); i++) {
			String s = bikeModelsElements.get(i);
			if (s.contains("Honda")) {
				NameList.add(s);
			}
			if (s.contains("Rs. ")) {
				arr = s.split(" ");
				PriceList.add(arr[1]);
			}
			if (s.contains("Exp. Launch")) {
				DateList.add(s);
			}
		}

		ArrayList<String> upcomingBikes = new ArrayList<String>();
		for (int i = 0; i < NameList.size(); i++) {
			String temp = NameList.get(i);
			double price = Double.parseDouble(PriceList.get(i));
			String info = temp + "  " + PriceList.get(i) + " Lakh  " + DateList.get(i);
			if (info.contains(temp)) {
				if (Double.compare(price, 4d) < 0) {
					upcomingBikes.add(info);
				}
			}
		}

		WriteToExcel.bikesOutputoToExcel("Upcoming Honda Bikes", upcomingBikes);
		System.out.println("Upcoming Honda Bikes Below 4 Lakhs are as follows:");
		for (int i = 0; i < upcomingBikes.size(); i++) {
			System.out.println(upcomingBikes.get(i));
		}

	}

}
