package GoogleSignIn;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Common.Wait;
import UtilityFiles.Highlighter;
import UtilityFiles.WriteToExcel;

public class GoogleSignIn {

	WebDriver driver;
	public String filePath = null;

	public GoogleSignIn(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "des_lIcon")
	WebElement signInButton;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Continue with Google')]")
	WebElement google;
	@FindBy(how = How.CSS, using = "#identifierId")
	WebElement email;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Next')]")
	WebElement emailNextButton;
	@FindBy(how = How.XPATH, using = "//*[@id='view_container']/div/div")
	WebElement errorMessage;

	public void clickSignIn() {

		filePath = System.getProperty("user.dir") + "/Screenshots/GoogleSignIn/SignInButton.png";
		Highlighter.highLightElement(driver, signInButton, filePath);
		signInButton.click();
	}

	public void googleSignIn() {
		Actions action = new Actions(driver);
		filePath = System.getProperty("user.dir") + "/Screenshots/GoogleSignIn/GoogleSignInButton.png";
		Highlighter.highLightElement(driver, google, filePath);
		
		action.moveToElement(google).click(google).perform();
	}

	public void emailInput(String emailId) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String parent = iterator.next();
		String child = iterator.next();

		driver.switchTo().window(child);
		filePath = System.getProperty("user.dir") + "/Screenshots/GoogleSignIn/EmailIdField.png";
		Highlighter.highLightElement(driver, email, filePath);
		email.sendKeys(emailId);
	}

	public void emailNext() {
		Actions action = new Actions(driver);
		filePath = System.getProperty("user.dir") + "/Screenshots/GoogleSignIn/NextButton.png";
		Highlighter.highLightElement(driver, emailNextButton, filePath);
		action.moveToElement(emailNextButton).click(emailNextButton).perform();
	}

	public void getErrorMessage()  {
		Wait wait=new Wait();
		wait.waitImplicit(driver);
		String message = errorMessage.getText();
		filePath = System.getProperty("user.dir") + "/Screenshots/GoogleSignIn/ErrorMessage.png";
		Highlighter.highLightElement(driver, errorMessage, filePath);
		System.out.println(message);

		try {
			WriteToExcel.signInOutputoToExcel("Google Sign In Error", message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
