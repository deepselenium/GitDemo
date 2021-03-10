package Mission1;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Landingpage;
import pageObjects.Loginpage;
import resources.base;

public class AssertVal extends base{
	public WebDriver driver;
	
	@BeforeTest
	
	public void initializeTest() throws IOException {
		
		driver=initializeDriver();		
		driver.get(prop.getProperty("url"));
		
		
	}
	@Test
	public void validationAs() throws IOException{
		
		
		Landingpage lp=new Landingpage(driver);
		Assert.assertEquals(lp.courseslink().getText(),"VIEW ALL COURSES");
		

										
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
	}
	
	
}
