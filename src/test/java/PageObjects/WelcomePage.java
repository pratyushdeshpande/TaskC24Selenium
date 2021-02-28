package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class WelcomePage {
	//Create instance of WebDriver
	WebDriver ldriver;
	//Use Pagefactory to initialize the Elements and by creating the constructor
	public WelcomePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Get the locator of the WebElement NextButton
	@FindBy(xpath ="//*[@id=\"application-form\"]/div/div[3]/form/div/div/a")
	WebElement NextButton;

	//Get the locator of the WebElement errMessageLabel
	@FindBy(xpath ="//*[@id=\"application-form\"]/div/div[3]/form/section[1]/div[1]/div[2]/div[2]/label")
	WebElement errMessageLabel;
	
	//Get the locator of the WebElement Gender Male
	@FindBy(xpath ="//*[@id=\"application-form\"]/div/div[3]/form/section[1]/div[1]/div[2]/div[1]/div/div/div[2]/label")
	WebElement Gender;
	
	//Get the locator of the WebElement GivenName
	@FindBy(xpath ="//*[@id=\"GIVEN_NAME\"]")
	WebElement GIVEN_NAME;
	
	//Get the locator of the WebElement LastName
	@FindBy(xpath ="//*[@id=\"LAST_NAME\"]")
	WebElement LAST_NAME;
	
	//Get the locator of the WebElement Date Of Birth
	@FindBy(xpath ="//*[@id=\"DATE_OF_BIRTH\"]")
	WebElement DateOfBirth;
	
	//Get the locator of the WebElement Place of Birth
	@FindBy(xpath ="//*[@id=\"PLACE_OF_BIRTH\"]")
	WebElement PlaceOfBirth;
	
	//Get the locator of the WebElement MaritalStatus
	@FindBy(xpath ="//*[@id=\"MARITAL_STATUS\"]")
	WebElement MaritalStatus;
	
	//Get the locator of the WebElement Nationality
	@FindBy(xpath ="//*[@id=\"NATIONALITY\"]")
	WebElement Nationality;

	//Get the locator of the WebElement PostalCode
	@FindBy(xpath ="//*[@id=\"POSTAL_CODE\"]")
	WebElement PostalCode;
	
	//Get the locator of the WebElement Strasse
	@FindBy(xpath ="//*[@id=\"application-form\"]/div/div[3]/form/section[2]/div[2]/div[2]/div[1]/div[1]/div/input")
	WebElement Strasse;
	
	//Get the locator of the WebElement HouseNumber
	@FindBy(xpath ="//*[@id=\"HOUSE_NUMBER\"]")
	WebElement HouseNumber;
	
	//Get the locator of the WebElement HousingSituation
	@FindBy(xpath ="//*[@id=\"HOUSING_SITUATION\"]")
	WebElement HousingSituation;
	
	//Get the locator of the WebElement PhoneNumber
	@FindBy(xpath ="//*[@id=\"PHONENUMBER_MOBILE\"]")
	WebElement PhoneNumber;
	
	
	
	
	//Method to Click Next Button on WelcomPage
	public void ClickNext() throws InterruptedException {
		
		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(2000);
		NextButton.click();

	}	
	
	//Method to Check if Error Messages are present in the page with isTextPresent
	public boolean isTextPresent(String text) {
		try{
            boolean errMsg = ldriver.getPageSource().contains(text);
            return errMsg;
        }
        catch(Exception e){
            return false;
        }
	}
	
	//Method to Click on Gender
	public void ClickOnGender() {		
		Gender.click();
	}
	
	//Method to EnterFirstName in Text Field
	public void EnterFirstName(String text) {
		GIVEN_NAME.sendKeys(text);
	}
	
	//Method to EnterLastName in Text Field
	public void EnterLastName(String text) {
		LAST_NAME.sendKeys(text);
	}
	
	//Method to DateOfBirth in Text Field
	public void EnterDateOfBirth(String text) {
		DateOfBirth.sendKeys(text);
	}
	
	//Method to PlaceOfBirth in Text Field
	public void EnterPlaceOfBirth(String text) {
		PlaceOfBirth.sendKeys(text);
	}
	
	//Method to EnterMaritalStatus in Dropdown Field
	public void EnterMaritalStatus(String text) {
		Select dropdownMaritalStatus =  new Select(MaritalStatus);
		dropdownMaritalStatus.selectByVisibleText(text);
	}

	//Method to EnterNationality in Dropdown Field
	public void EnterNationality(String text) {
		Select dropdownNationality =  new Select(Nationality);
		dropdownNationality.selectByVisibleText(text);
	}

	//Method to Strasse in Text Field
	public void EnterStrasse(String text) {
		Strasse.sendKeys(text);
	}
	
	//Method to EnterHouseNumber in Text Field
	public void EnterHouseNumber(String text) {
		HouseNumber.sendKeys(text);
	}
	
	//Method to EnterHousingSituation in Dropdown Field
	public void EnterHousingSituation(String text) {
		Select dropdownHousingSituation =  new Select(HousingSituation);
		dropdownHousingSituation.selectByVisibleText(text);	
	}

	//Method to PhoneNumber in Text Field
	public void EnterPhoneNumber(String text) {
		PhoneNumber.sendKeys(text);
	}
	
	//Method to PostalCode in Text Field
	public void EnterPostalCode(String text) {
		PostalCode.sendKeys(text);
	}
}
