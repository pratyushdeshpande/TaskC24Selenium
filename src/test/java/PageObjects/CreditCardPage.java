package PageObjects;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class CreditCardPage {
	//Create instance of WebDriver
	WebDriver ldriver;
	
	//Use Pagefactory to initialize the Elements and by creating the constructor
	public CreditCardPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Find the Locator Next button for 1st entry
	@FindBy(how=How.XPATH, using="//*[@id='200007']/div[4]/div[3]/a")
	WebElement firstCardEntry;
	
	
    //Method to get the cookie
	public Cookie GetCookie() {
	    Cookie ppset = ldriver.manage().getCookieNamed("ppset");
	    return ppset;
	}
	
	//Method to ClickOnFirstCardEntry Next Button
	public void ClickOnFirstCardEntry() {
		firstCardEntry.click();
	}

}
