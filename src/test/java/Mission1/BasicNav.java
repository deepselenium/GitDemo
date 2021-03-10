package Mission1;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
import pageObjects.Landingpage;
import pageObjects.Loginpage;
import resources.base;

public class BasicNav extends base{
	
	
	@BeforeMethod
	
	public void initializeTest() throws IOException {
		
		driver=initializeDriver();		
		driver.get(prop.getProperty("url"));
	
		
	}
	
	@Test(dataProvider="getData")
	public void basepageNav(String uname, String pwd) throws IOException {
		
	
		Landingpage lp=new Landingpage(driver);
		Loginpage lg=lp.loginlink();
			
		lg.username().sendKeys(uname);
		lg.password().sendKeys(pwd);
		lg.loginbtn().click();

		
						
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data=new Object[2][2];
		data[0][0]="Hello user 1";
		data[0][1]="Hello pwd 1";
		
		data[1][0]="Hello user 2";
		data[1][1]="Hello pwd 2";
		
		return data;
		
	}

}
