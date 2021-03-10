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

import jdk.internal.org.jline.utils.Log;
import pageObjects.Landingpage;
import pageObjects.Loginpage;
import resources.base;

public class NavPanel extends base{
	
	
	@BeforeMethod
	
	public void initializeTest() throws IOException {
		
		driver=initializeDriver();		
		driver.get(prop.getProperty("url"));
		
		
	}
	
	@Test
	public void validationPanel() throws IOException{
		
		
		Landingpage lp=new Landingpage(driver);
		Assert.assertTrue(lp.NavigationPanel().isDisplayed());
	
		
								
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
	}
	
	
}
