package com.utility;
import com.contants.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BroswerUtiltiy
{
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public WebDriver getDrvier()
    {

        return driver.get();
    }

    public BroswerUtiltiy(WebDriver driver) {
        super();
        this.driver.set(driver);//initialize the instance variable driver;
    }
    public BroswerUtiltiy(Browser browser)
    {
        if(browser == Browser.CHROME)
        {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        }
        else if(browser == Browser.FIREFOX)
        {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        }
        else if(browser == Browser.EDGE)
        {
            WebDriverManager.edgedriver().setup();
            driver.set( new InternetExplorerDriver());
        }
    }
    public BroswerUtiltiy(Browser browser, boolean isHeadless)
    {
        if(browser == Browser.CHROME) {
            if (isHeadless) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                options.addArguments("--window=1920,1080");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-gpu");
                driver.set(new ChromeDriver(options));
            } else {
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
            }
        }
        else if(browser == Browser.FIREFOX)
        {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        }
        else if(browser == Browser.EDGE)
        {
            WebDriverManager.edgedriver().setup();
            driver.set( new InternetExplorerDriver());
        }
    }
    public void goToWebsite(String url)
    {
        driver.get().get(url);
    }
    public void maximizeWindow()
    {
        driver.get().manage().window().maximize();
    }
    public void ClickOn(By locator)
    {
        WebElement elementtobeClicked = driver.get().findElement(locator);
        elementtobeClicked.click();
    }
    public  void enterText(By locator,String textToEnter)
    {
        WebElement elementToEnterText = driver.get().findElement(locator);
        elementToEnterText.sendKeys(textToEnter);
    }
    public  void enterKey(By locator,Keys keystoEnter)
    {
        WebElement elementToEnterkeys = driver.get().findElement(locator);
        elementToEnterkeys.sendKeys(keystoEnter);
    }
    public String getText(By locator)
    {
        WebElement elementToGetText = driver.get().findElement(locator);
        //driver.get().findElement(RelativeLocator.with())
       return elementToGetText.getText();
    }
    public List<String> getlistofText(By locator)
    {
      List<WebElement> listofElements =  driver.get().findElements(locator);
        //driver.get().findElement(RelativeLocator.with())
        List<String> listOfTexts = new ArrayList<>();
        for(WebElement ele : listofElements)
        {
           listOfTexts.add(getText(ele));
        }
        return listOfTexts;
    }
    public String getText(WebElement element)
    {
        //driver.get().findElement(RelativeLocator.with())
        return element.getText();
    }
    public String TakeScreenshotof(String name)
    {
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver.get();
        File Screenshotdata = takesScreenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH-mm-ss");
        String Date  = simpleDateFormat.format(date);
        String Path = "./screenshots/"+name + " -" + Date + ".png";
        File Screenshotfile = new File(Path);
        try {
            FileUtils.copyFile(Screenshotdata,Screenshotfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Path;
    }
    public void quit() {
        driver.get().quit();
    }








}