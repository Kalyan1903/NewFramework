package com.ui.pages;

import com.contants.Browser;
import static com.contants.Env.*;
import com.utility.BroswerUtiltiy;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;
import com.utility.PropertiesUtil;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public final class HomePage extends BroswerUtiltiy
{
    Logger logger =  LoggerUtility.GetLogger(this.getClass());
    String filepath ="\\Config\\config.json";
    private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign')]");
     public HomePage(Browser Browsername, boolean isHeadless)
    {
       super(Browsername,isHeadless);
        //goToWebsite(PropertiesUtil.readProperties(QA,"URL"));
        logger.info("Launching the Browser");
        goToWebsite(JSONUtility.readJSON("DEV",filepath).getUrl());
    }
    public HomePage(WebDriver driver)
    {
        super(driver);
        //goToWebsite(PropertiesUtil.readProperties(QA,"URL"));
        logger.info("Launching the Browser");
        goToWebsite(JSONUtility.readJSON("DEV",filepath).getUrl());
    }


   public LoginPage goToLoginPage()//Page functions cannot have void return type
   {
       logger.info("clicking on sign in page");
       ClickOn(SIGN_IN_LINK_LOCATOR);
       LoginPage loginPage = new LoginPage (getDrvier());
       return loginPage;
   }

}
