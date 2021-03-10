package Mission1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportTNG;
import resources.base;

public class Listeners extends base implements ITestListener{	
	
ExtentReports extent=ExtentReportTNG.getReportObject();
ExtentTest test;
ThreadLocal<ExtentTest> exentTest=new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		
		test=extent.createTest(result.getMethod().getMethodName());
		
		exentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		exentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		exentTest.get().fail(result.getThrowable());
		WebDriver driver=null;
		
	try {
		driver=	(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
		
		e1.printStackTrace();
	}
		String testcaseName=result.getMethod().getMethodName();
		
	
		try {
			exentTest.get().addScreenCaptureFromPath(Listen(testcaseName,driver),result.getMethod().getMethodName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
	extent.flush();
		
	}


	
	

}
