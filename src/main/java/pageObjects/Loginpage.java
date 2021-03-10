package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {
	
	WebDriver driver;
	public Loginpage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	By uname=By.id("user_email");
	By passwrd=By.id("user_password");
	By submitlgn=By.xpath("//input[@type='submit']");
	
	public WebElement username() {
		
		return driver.findElement(uname);
	}
	
	public WebElement password() {
		
		return driver.findElement(passwrd);
	}
	
	public WebElement loginbtn() {
		
		return driver.findElement(submitlgn);
	}
	

}
