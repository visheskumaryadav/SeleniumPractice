package ConfigurationClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportMaker {
    static ExtentReports extent;
    public static void createReport(){
        String path=System.getProperty("user.dir")+"\\Reports\\ExtentReport.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("Test Reports");
        reporter.config().setDocumentTitle("Report");
        extent=new ExtentReports();
        extent.attachReporter(reporter);
    }

    public static ExtentReports getExtentObject(){
        return extent;
    }
}
