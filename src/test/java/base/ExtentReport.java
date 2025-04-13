package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.Constants;

public class ExtentReport {
	
	private static ExtentReports extent;
	
    public static ExtentReports getInstance() {
        
    	if (extent == null) {
            
    		String path = Constants.testReports;
            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            reporter.config().setReportName("Automation Test Results");
            reporter.config().setDocumentTitle("Voter Roll Test Report");
            reporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            
            extent.setSystemInfo("Tester", "Shrey Vyas");
        
        }
        
        return extent;
    }

}
