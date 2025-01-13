package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LamdaTestUtility
{
      public static final String HUB_URL = "https://hub.lamdatest.com/wd/hub";
      private static ThreadLocal<WebDriver> driverlocal = new ThreadLocal<WebDriver>();
      private static ThreadLocal<DesiredCapabilities> desiredCapabilities = new ThreadLocal<DesiredCapabilities>();
      public static WebDriver initialiseLamdaTestSession(String browser,String testName) {
          DesiredCapabilities capabilities =  new DesiredCapabilities();
          capabilities.setCapability("browserName",browser);
          capabilities.setCapability("browserVersion","131");
          Map<String,Object> Itoptions = new HashMap<>();
          Itoptions.put("user","kalyanpabbathi158");
          Itoptions.put("Access Key", "cPmfxPBlTdHYs9QoZVVAMzwvdYwRUDQOudnQ0eRcwWbzRIIZL1");
          Itoptions.put("build","Selenium 1");
          Itoptions.put("name",testName);
          Itoptions.put("platformName","Windows 10");
          Itoptions.put("seCdp",true);
          Itoptions.put("selenium_version","4.23.0");
          capabilities.setCapability("LT:Options",Itoptions);
          desiredCapabilities.set(capabilities);
          WebDriver driver = null;
          try {
              driver = new RemoteWebDriver(new URL(HUB_URL),desiredCapabilities.get());
          } catch (MalformedURLException e) {
              throw new RuntimeException(e);
          }
          driverlocal.set(driver);

return driverlocal.get();


      }
      public static void quitSession()
      {
          if(driverlocal.get()!=null )
          {
              driverlocal.get().quit();
          };
      }


}
