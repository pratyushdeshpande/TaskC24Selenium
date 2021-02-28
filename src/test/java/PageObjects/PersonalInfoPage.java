package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PersonalInfoPage {
	//Create instance of WebDriver
	WebDriver ldriver;
	//Use Pagefactory to initialize the Elements and by creating the constructor
	public PersonalInfoPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Get the locator of the Element MochteIchLink
	@FindBy(how=How.XPATH, using="//*[@id='application-form']/div/div[3]/div/div/unified-login/div/div/div[3]/div[3]/a")
	WebElement MochteIchLink;
	
	//Method to Scroll down the page and click the button using Actions Class
	public void ClickMochteIchLink() throws InterruptedException {
		//Using JavascriptExecutor object to scroll Down the page
		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		
		//Using Actions Class object to move the cursor and click on the Button
		Actions actions = new Actions(ldriver);
	    actions.moveToElement(MochteIchLink).perform();
	    Thread.sleep(2000);
	    actions.moveToElement(MochteIchLink).click().perform();

	}
}
