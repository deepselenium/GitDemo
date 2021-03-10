package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class base {
	
	public WebDriver driver;
	public Properties prop;
	

	public WebDriver initializeDriver() throws IOException {
		
		prop=new Properties();
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		//String BrowserName=prop.getProperty("browser");
		String BrowserName=System.getProperty("browser");
		if(BrowserName.contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(BrowserName.contains("headless")) {
				
				options.addArguments("--headless");
			}
			driver = new ChromeDriver(options);
			
		}
		
		else if(BrowserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","E:\\Mission Selenium\\geckodriver-v0.29.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
				
	}
	
	public String Listen(String testcaseName,WebDriver driver) throws IOException {
				
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
		FileUtils.copyFile(source,new File(dest));
		return dest;
		
	}
		
}
