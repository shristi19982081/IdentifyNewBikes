package Hackathon.IdentifyNewBikes;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSignIn {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//Maximize the window
		driver.manage().window().maximize();
		//Go to the URL
		driver.get("https://www.zigwheels.com/");
		
		driver.findElement(By.id("des_lIcon")).click();
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		
		//WebElement google = driver.findElement(By.id("googleSignIn"));
		WebElement google = driver.findElement(By.cssSelector("body.modal-open:nth-child(2) div.modal.fade.in:nth-child(29) div.modal-dialog.fo-nw-loginWrap div.modal-content div.fo-nw-login.txt-c.d-tbl.wth-100:nth-child(1) div.d-tblc.rel div.fo-nw-step1:nth-child(5) div.lgn-sc.c-p.txt-l.pl-30.pr-30:nth-child(3) > span.fnt-18"));
		
		action.moveToElement(google).click(google).perform();
		
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String parent = iterator.next();
		String child = iterator.next();
		
		driver.switchTo().window(child);
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#identifierId")).sendKeys("abc@xyz.com");
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		Thread.sleep(2000);
		
		driver.quit();

	}

}
