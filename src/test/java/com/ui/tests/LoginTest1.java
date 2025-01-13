package com.ui.tests;

import com.contants.Browser;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//import java.time.chrono.ChronoLocalDate;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.testng.Assert.*;

//mport org.testng.Assert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.contants.Browser.*;
@Listeners(com.ui.listners.TestListeners.class)
public final class LoginTest1 extends BaseTest
{

    Logger logger = LoggerUtility.GetLogger(this.getClass());


    @Test(description = "Base script writing",groups = {"e2e","sanity"},dataProviderClass = com.ui.dataproviders.LoginDataprovider.class,dataProvider = "testdataprovider")
    public void logintest(User user)
    {


       assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName(),"Kalyan S");
    }

    @Test(description = "Base script writing",groups = {"e2e","sanity"},dataProviderClass = com.ui.dataproviders.LoginDataprovider.class,dataProvider = "testdatacsvprovider",retryAnalyzer = com.ui.listners.MyRetryAnalyzer.class)
    public void logintest2(User user)
    {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName(),"Kalyan S");
    }



    @Test(description = "Base script writing",groups = {"e2e","sanity"},dataProviderClass = com.ui.dataproviders.LoginDataprovider.class,dataProvider = "testdataxlsxprovider")
    public void logintest3(User user)
    {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName(),"Kalyan S");
    }


    @Test(retryAnalyzer = com.ui.listners.MyRetryAnalyzer.class)
    public void logintest4()
    {

        assertEquals(homePage.goToLoginPage().doLoginWith("kalyanpabbathi158@gmail.com", "Password").getUserName(),"Kalyan S");

    }



}
