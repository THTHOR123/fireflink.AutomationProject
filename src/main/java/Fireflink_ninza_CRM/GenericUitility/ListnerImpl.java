package Fireflink_ninza_CRM.GenericUitility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class implements ITestListner interface
 */
@Listeners(Fireflink_ninza_CRM.GenericUitility.ListnerImpl.class)
public class ListnerImpl implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "======== Test Execution Started =========");
		
		//Intimate ExtentReports for @Test start
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "======== Test Execution Passed =========");
		
		//LOG THE STATUS OF @Test AS PASS for the report
		test.log(Status.PASS,methodName + "======== Test Execution Passed =========");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "======== Test Execution Failed =========");
		
		System.out.println(result.getThrowable());
		
		test.log(Status.WARNING, result.getThrowable());
		JavaUtility jutil = new JavaUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		
		String screenshotname = methodName+jutil.getSystemDate();
		
		try {
			String path = wutil.captureScreenShot(BaseClass.sdriver, screenshotname);
			
			//ATTACH SCREENSHOT to REPORT
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//LOG THE STATUS OF @Test AS FAIL for the report
		test.log(Status.FAIL,methodName + "======== Test Execution Failed =========");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + "======== Test Execution Skipped =========");
		
		System.out.println(result.getThrowable());
		test.log(Status.INFO, result.getThrowable());
		
		//LOG THE STATUS OF @Test AS SKIP for the report
		test.log(Status.SKIP,methodName + "======== Test Execution Skipped =========");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("========= Suite Execution started ==========");
		
		//REPORT CONFIGURATION
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReport\\Extent-Report-"+new JavaUtility().getSystemDate()+".html");
		esr.config().setDocumentTitle("Ninza CRM Automation Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Automation Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Url", "Test Env");
		report.setSystemInfo("Reporter Name", "Tushar Jadhav");
		report.setSystemInfo("For contact", "tj27862@gmail.com");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onFinish(context);
		System.out.println("========= Suite Execution ended ==========");
		
		//REPORT GENERATION
		report.flush();
		
	}

	
}
