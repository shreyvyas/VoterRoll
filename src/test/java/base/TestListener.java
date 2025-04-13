package base;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestListener extends BaseTest implements ITestListener{
	
    private static ExtentReports extent = ExtentReport.getInstance();
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();
    private Screenshot screenshot = new Screenshot();

    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getName());
        testThread.set(test); 
    }

    public void onTestSuccess(ITestResult result) {
        testThread.get().log(Status.PASS, "Test Passed: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        testThread.get().log(Status.FAIL, "Test Failed: " + result.getName());
        screenshot.takeScreenshot(result.getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("Failed Test Cases:");

        ExtentTest summaryTest = extent.createTest("Test Summary");
        summaryTest.log(Status.INFO, "Total Passed: " + context.getPassedTests().size());
        summaryTest.log(Status.INFO, "Total Failed: " + context.getFailedTests().size());
        summaryTest.log(Status.INFO, "Total Skipped: " + context.getSkippedTests().size());

        extent.flush();  
    }


}
