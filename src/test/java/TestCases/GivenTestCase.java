package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CreditCardPage;
import PageObjects.EnterEmailPage;
import PageObjects.PersonalInfoPage;
import PageObjects.WelcomePage;


public class GivenTestCase extends BaseClass {
	
	//Test Method 1 but could be combined, added a priority to test annotations just to show how it can be executed sequentially
	@Test(priority=1) 
	public void ClickOnCreditCard() {
		//Create a object of CreditCardPage in order to use its methods
		CreditCardPage cc = new CreditCardPage(driver);
		
		//Verify the Cookie is present or not
		Assert.assertEquals(cc.GetCookie().getValue(), "kreditkarte");
		cc.ClickOnFirstCardEntry();

	}
	
	
	@Test(priority=2) 
	public void EnterEmail() throws InterruptedException {
		//Create a object of EnterEmailPage in order to use its methods
		EnterEmailPage em = new EnterEmailPage(driver);
		em.EnterEmail();
		driver.switchTo().defaultContent();		
		Thread.sleep(2000);
		em.ClickNext();
		
		Thread.sleep(2000);
		//Create a object of PersonalInfoPage in order to use its methods
		PersonalInfoPage piInfo = new PersonalInfoPage(driver);
		piInfo.ClickMochteIchLink();
		
		
		//Create a object of WelcomePage in order to use its methods
		WelcomePage wp =new WelcomePage(driver);
		
		wp.ClickNext();
		
		Thread.sleep(2000);//Wait for errors to be populated and can be seen visually
		
		//Calling isTextPresent Method to assert all the errors visible on the page
		Assert.assertTrue(wp.isTextPresent("Bitte wählen Sie Ihre Anrede aus."));
		Assert.assertTrue(wp.isTextPresent("Bitte geben Sie Ihren Vornamen an."));
		Assert.assertTrue(wp.isTextPresent("Bitte geben Sie Ihren Nachnamen an."));
		Assert.assertTrue(wp.isTextPresent("Bitte geben Sie Ihr Geburtsdatum an."));
		Assert.assertTrue(wp.isTextPresent("Bitte geben Sie Ihren Geburtsort an."));
		Assert.assertTrue(wp.isTextPresent("Bitte wählen Sie Ihren Familienstand aus."));
		Assert.assertTrue(wp.isTextPresent("Bitte wählen Sie Ihre Staatsangehörigkeit aus."));
		Assert.assertTrue(wp.isTextPresent("Bitte geben Sie Ihre Postleitzahl an."));
		Assert.assertTrue(wp.isTextPresent("Bitte überprüfen Sie Ihren Wohnort."));
		Assert.assertTrue(wp.isTextPresent("Bitte geben Sie Ihre Meldeadresse an."));
		Assert.assertTrue(wp.isTextPresent("Bitte geben Sie die Hausnummer Ihrer Meldeadresse an."));
		Assert.assertTrue(wp.isTextPresent("Bitte wählen Sie Ihre aktuelle Wohnsituation aus."));
		Assert.assertTrue(wp.isTextPresent("Für eventuelle Rückfragen benötigen wir Ihre deutsche Mobilnummer."));

		//Filling the form by calling in all the methods
		wp.ClickOnGender();
		wp.EnterFirstName("Pratyush");
		wp.EnterLastName("Deshpande");
		wp.EnterDateOfBirth("22.03.1991");
		wp.EnterPlaceOfBirth("Mumbai");
		wp.EnterMaritalStatus("verheiratet");
		wp.EnterNationality("Indien");
		wp.EnterStrasse("Trappentreustr.");
		wp.EnterHouseNumber("1");
		wp.EnterPostalCode("80339");
		wp.EnterHousingSituation("zur Miete");
		wp.EnterPhoneNumber("017656742149");
		wp.ClickNext();


		}
}
