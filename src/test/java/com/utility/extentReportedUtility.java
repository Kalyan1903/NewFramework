package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportedUtility
{
    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    public static void setUpSparKreporter(String filename)
    {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//"+filename);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

    }
    public static void CreateTestReport(String testName) {
        ExtentTest test = extentReports.createTest(testName);
      extentTest.set(test);
    }
    public  static ExtentTest GettestReports()
    {
        return extentTest.get();
    }
    public static void flush()
    {
        extentReports.flush();
    }

}
