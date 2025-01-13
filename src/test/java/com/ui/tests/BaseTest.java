package com.ui.tests;

import com.contants.Browser;
import com.ui.pages.HomePage;
import com.utility.BroswerUtiltiy;
import com.utility.LamdaTestUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static com.contants.Browser.CHROME;

public class BaseTest
{
    HomePage homePage;
    private boolean isLamda;
    private  boolean isHeadless;
    Logger logger = LoggerUtility.GetLogger(this.getClass());
    WebDriver driverlamda;

@Parameters({"browser","isHeadless","isLamda"})
    @BeforeMethod(description = "load the homepage of the website")
    public void setUpMethod(
        @Optional("chrome") String browser,
        @Optional("true") boolean isHeadless,
        @Optional("false") boolean isLamda, ITestResult result) {
    this.isLamda = isLamda;
    this.isHeadless = isHeadless;

        if (isLamda) {
        driverlamda =  LamdaTestUtility.initialiseLamdaTestSession(browser,result.getMethod().getMethodName());
        homePage = new HomePage(driverlamda);
        } else {
            logger.info("Launching the website");
            homePage = new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
        }
    }
    public BroswerUtiltiy getInstance()
    {
        return homePage;
    }
    @AfterMethod(description = "Tear down the browser")
    public void Teardown()
    {
        if(isLamda)
        {
            LamdaTestUtility.quitSession();
        }
    }

}
