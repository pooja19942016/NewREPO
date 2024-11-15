package genericUtilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class provides  implementation to ITestListener
 * @author pooja
 */
public class ListenersImplementation implements ITestListener 
{
    /*Capture the current system date and time for screenshot name and Report Name*/
	
	Date d= new Date();//import it from java.uil package, o/p--> 05-Nov-2024 19:15:25
    
	SimpleDateFormat f = new SimpleDateFormat(" dd-MM-yyyy hh-mm-ss ");//date will be formated in this type
    String date=f.format(d);

    //For Extent Report
    ExtentReports report;
    ExtentTest test;
    
	@Override
	public void onTestStart(ITestResult result) {
		
		//Capture the method name of @Test
		String methodName= result.getMethod().getMethodName();
		
		/*@Test execution is PASS*/
		System.out.println(methodName+"-->Test Script Execution started");
		
		/*Intimate extent Reports for @Test execution*/
		test=report.createTest(methodName);
		
			}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		//Capture the method name of @Test
		String methodName=result.getMethod().getMethodName();
		
		/*@Test execution is PASS*/
		System.out.println(methodName+"-->Test script is PASS ");
		
		/*Log the status of test as PASS in Extent Report*/
		test.log(Status.PASS, methodName+" ->Test script is PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//Capture the method Name of @Test
		String methodName= result.getMethod().getMethodName();
		
		/* @Test execution is FAIL*/
		System.out.println(methodName+"-->"+ "Test Script is FAIL");
		
		//Capture the exception
		System.out.println(result.getThrowable());
		
		/*Log the status of test as PASS in Extent Report*/
		test.log(Status.FAIL, methodName+" ->Test script is FAIL");
		
		/**/
		test.log(Status.WARNING, result.getThrowable() );
		
		
		/*Capture the screenshot*/
		SeleniumUtility s = new SeleniumUtility();
		
		//ScreenShot name configured
		String screenshotName = methodName+date;
		
		try 
		{
			String path = s.captureScreenShot(BaseClass.sdriver, screenshotName);
			
			/*Attach the screenshot in extent report*/
			
			test.addScreenCaptureFromPath(path);
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		//Capture the method Name of @Test
		String methodName = result.getMethod().getMethodName();
		
		/* @Test execution is SKIP*/
		System.out.println(methodName+"-->Test Script is SKIP");
		
		//Capture the Execution
		System.out.println(result.getThrowable());
		
		/*Log the status of test as PASS in Extent Report*/
		test.log(Status.SKIP, methodName+" ->Test script is SKIP");
		
		/*Log the exception in extent Report*/
		test.log(Status.WARNING, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result)
	{
	
	}

	@Override
	public void onStart(ITestContext context) {
	
		/*Suite level execution - <suite> */
		System.out.println("Sutie Execution started");
		
		/*Basic Configuration of Extent Report*/
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report - "+date+".html");
		esr.config().setDocumentTitle("SWAG LABS Execution Report");
		esr.config().setReportName("Execution Build version 1.12");
		esr.config().setTheme(Theme.DARK);
		
		/*Feeds the configuration to Extent reports class*/
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Env", "Test Env");
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "windows Family");
		report.setSystemInfo("Base URL", "TestEnv.com");
		report.setSystemInfo("Reproter Name", "Pooja");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		/*Suite level execution*/
		System.out.println("Sutie Execution finished");
		
		
		/*Generate the extent Report*/
		report.flush();//flush means END OF EXECUTION,WITHOUT THIS WILL NOT GENERATE THE REPORT
	}
	

}
