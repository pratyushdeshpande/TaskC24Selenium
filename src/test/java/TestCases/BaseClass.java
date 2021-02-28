package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class BaseClass {
	
	public static WebDriver driver;
	
	//This is a Setup Method to be executed Before all the Test Cases are run
	@Parameters({"browser","url"})
	@BeforeClass
	public void setup(String browser, String url) throws InterruptedException {
		
		//This browser is taken from parameter annotation of TestNG, currently it is chrome
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}

		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		Thread.sleep(2000);
		//Checking if Accept Cookie Screen is available , if present then it is accepted otherwise a catch block is placed to bypass the execution
		try {
			if(driver.findElement(By.linkText("Akzeptieren")).isDisplayed()) {
				driver.findElement(By.linkText("Akzeptieren")).click();
			}
			
		}
		catch(Exception e) {
			System.out.println("Accept Cookies popup was not present");
			
		}
		
	}
	
	
	//This is a Tear Down Method to be executed after all the Test Cases are run
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	
}
