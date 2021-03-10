package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportTNG {
	
	static ExtentReports extent;
	
	public static  ExtentReports getReportObject()
	{
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);	
	reporter.config().setReportName("Deep's Report");
	reporter.config().setDocumentTitle("Deep Document Title");
		
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	return extent;
	}

}
