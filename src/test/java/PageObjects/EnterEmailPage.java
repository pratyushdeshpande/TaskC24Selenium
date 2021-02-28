package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class EnterEmailPage {
	//Create instance of WebDriver
	WebDriver ldriver;
	//Use Pagefactory to initialize the Elements and by creating the constructor
	public EnterEmailPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Get the locator of the Element emailField
	@FindBy(how=How.XPATH, using="//*[@id='cl_login']")
	WebElement emailField;
	
	//Get the locator of the Element NextButton
	@FindBy(xpath ="/html/body/div[4]/div[3]/div/div/div/div/div/div[3]/div/div/unified-login/div/div/div[2]/form/div[1]/div[2]/button")
	WebElement NextButton;
	
	//Method to EnterEmail in the Text Field
	public void EnterEmail() throws InterruptedException {
		emailField.sendKeys("test@test.com");
	}
	
	//Method to Click Next Button on EnterEmail page
	public void ClickNext() {
		Actions actions = new Actions(ldriver);
	    actions.moveToElement(NextButton).perform();
	    actions.moveToElement(NextButton).click().perform();

	}

}

