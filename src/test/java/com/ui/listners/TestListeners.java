package com.ui.listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.BaseTest;
import com.utility.BroswerUtiltiy;
import com.utility.LoggerUtility;
import com.utility.extentReportedUtility;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListeners  implements ITestListener
{
    Logger logger =  LoggerUtility.GetLogger(this.getClass());
    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    ExtentTest extentTest;
    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        extentReportedUtility.CreateTestReport(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {

        logger.info(result.getMethod().getMethodName() + " "+ "PASSED");
        extentReportedUtility.GettestReports().log(Status.PASS,result.getMethod().getMethodName()+" "+ "PASSED");
    }

    public void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName() + " "+ "+FAILED");
        logger.error(result.getThrowable().getMessage());
        extentReportedUtility.GettestReports().log(Status.FAIL,result.getMethod().getMethodName()+" "+ "FAILED");
        extentReportedUtility.GettestReports().log(Status.FAIL,result.getThrowable().getMessage());
        Object TestObject = result.getInstance();
        BroswerUtiltiy broswerUtiltiy = ((BaseTest)TestObject).getInstance();
      String ScreenshotPath =  broswerUtiltiy.TakeScreenshotof(result.getMethod().getMethodName());
      extentReportedUtility.GettestReports().addScreenCaptureFromPath(ScreenshotPath);

    }

    public void onTestSkipped(ITestResult result) {

        logger.warn(result.getMethod().getMethodName()+" "+"SKIPPED");
        extentReportedUtility.GettestReports().log(Status.SKIP,result.getMethod().getMethodName()+" "+ "SKIPPED");
    }

    public void onStart(ITestContext context) {
        logger.info("Test suite Started");
        extentReportedUtility.setUpSparKreporter("Report.html");
    }

    public void onFinish(ITestContext context) {
        logger.info("Test suite ended");
        extentReportedUtility.flush();
    }
}
