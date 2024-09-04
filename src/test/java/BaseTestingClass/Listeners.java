package BaseTestingClass;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Resources.ExtentReportsUtility;

public class Listeners extends BaseClass implements ITestListener {
	
	ExtentReports report=ExtentReportsUtility.getTheExtentReportObject();
	ExtentTest test;
	
	ThreadLocal<ExtentTest> ts=new ThreadLocal<ExtentTest>();
	

	@Override
	public void onTestStart(ITestResult result) {
		
		test=report.createTest(result.getMethod().getMethodName());
		ts.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ts.get().log(Status.PASS, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ts.get().fail(result.getThrowable()); //get the error message	
		
		//screenshot
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		String filepath=null;
		try {
			filepath = getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ts.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ts.get().log(Status.SKIP, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
	}

	
}
