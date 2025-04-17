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
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BroswerUtiltiy
{
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public static WebDriver getDrvier()
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
    public void clickonefromlistofText(By locator,String value)
    {
        List<WebElement> listofElements =  driver.get().findElements(locator);
        System.out.println(value);
        System.out.println(listofElements);
        //driver.get().findElement(RelativeLocator.with())
        for (WebElement m : listofElements) {
            System.out.println(m.getText());
            if (m.getText().equalsIgnoreCase(value)) {
                try {
                    if (m.isDisplayed() && m.isEnabled()) {
                        try {
                            m.click();
                            System.out.println("Clicked normally.");
                        } catch (Exception e) {
                            System.out.println("Normal click failed, trying JS click.");
                            JavascriptExecutor js = (JavascriptExecutor) driver.get();
                            js.executeScript("arguments[0].click();", m);
                        }
                        break;
                    } else {
                        System.out.println("Element not visible/clickable: " + m.getText());
                    }
                } catch (Exception e) {
                    System.out.println("Exception during click: " + e.getMessage());
                }
            }
        }
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
    public void selectByVisibleText(By locator, String visibleText) {
        WebElement dropdown = driver.get().findElement(locator);
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }

    // Method to select by value
    public void selectByValue(By locator, String value) {
        WebElement dropdown = driver.get().findElement(locator);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    // Method to select by index
    public void selectByIndex(By locator, int index) {
        WebElement dropdown = driver.get().findElement(locator);
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    public void quit() {
        driver.get().quit();
    }

    public void waits()
    {
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }









}