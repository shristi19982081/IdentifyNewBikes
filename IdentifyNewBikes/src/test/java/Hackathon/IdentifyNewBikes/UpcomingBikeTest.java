package Hackathon.IdentifyNewBikes;

import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpcomingBikeTest {

	public static WebDriver driver;
	@Test
	public void upcomingBikeTest() throws InterruptedException{
		
WebElement newBikesMenu = driver.findElement(By.xpath("//a[contains(text(),'New Bikes')]"));
		
		Actions action = new Actions(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		action.moveToElement(newBikesMenu).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Upcoming Bikes')]")).click();
		Thread.sleep(2000);
		WebElement manufacturer = driver.findElement(By.id("makeId"));
		Select select = new Select(manufacturer);
		select.selectByVisibleText("Honda");
		Thread.sleep(2000);
		WebElement scrollupto = driver.findElement(By.xpath("//span[contains(text(),'View More Bikes')]"));
		
		
		jse.executeScript("arguments[0].scrollIntoView(true)", scrollupto);
		Thread.sleep(2000);
		WebElement button = driver.findElement(By.xpath("//span[contains(text(),'View More Bikes')]"));
		action.moveToElement(button).click(button).perform();
		Thread.sleep(3000);
		
		String bikeModels =driver.findElement(By.xpath("//*[@id='carModels']/ul")).getText();
		
		ArrayList<String> bikeModelsElements = new ArrayList<String>();
		Collections.addAll(bikeModelsElements,bikeModels.split("\n"));
		
		ArrayList<String> NameList = new ArrayList<String>();
		ArrayList<String> DateList = new ArrayList<String>();
		ArrayList<String> PriceList =new ArrayList<String>();
		String[] arr = null;
		for(int i = 0 ; i < bikeModelsElements.size(); i++){
			String s = bikeModelsElements.get(i);
			if(s.contains("Honda")){
				NameList.add(s);
			}
			if(s.contains("Rs. ")){
				arr = s.split(" ");
				PriceList.add(arr[1]);
			}
			if(s.contains("Exp. Launch")){
				DateList.add(s);
			}
		}
		
		ArrayList<String> upcomingBikes = new ArrayList<String>();
		for(int i=0; i<NameList.size();i++){
			String temp = NameList.get(i);
			double price = Double.parseDouble(PriceList.get(i));
			String info=temp+"  "+PriceList.get(i)+" Lakh  "+DateList.get(i);
			if(info.contains(temp)){
				if(Double.compare(price, 4d)<0){
					upcomingBikes.add(info);
				}
			}
		}
		
		System.out.println("Upcoming Honda Bikes Below 4 Lakhs are as follows:");
		for(int i = 0 ; i < upcomingBikes.size(); i++){
			System.out.println(upcomingBikes.get(i));
		}
	}
	
	@BeforeTest
	public WebDriver getDriver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.zigwheels.com/");

		return driver;

	}

	@AfterTest
	public void quitDriver() {
		driver.quit();
	}
}
