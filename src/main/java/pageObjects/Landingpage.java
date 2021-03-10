package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
	
	public WebDriver driver;
	
	public Landingpage(WebDriver driver) {
		
		
		this.driver=driver;
	}
	
	
	By login=By.linkText("Login");
	By allcourses=By.linkText("VIEW ALL COURSES");
	By Navpanel = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	public Loginpage loginlink() {
		
		driver.findElement(login).click();
		Loginpage lg=new Loginpage(driver);
		return lg;
	}
	
	public WebElement courseslink() {
		
			return driver.findElement(allcourses);
	}
	
	public WebElement NavigationPanel() {
		
		return driver.findElement(Navpanel);
}

	
}
