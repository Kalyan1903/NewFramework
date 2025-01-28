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
      public static final String HUB_URL = "https://ondemand.eu-central-1.saucelabs.com:443/wd/hub";
      private static ThreadLocal<WebDriver> driverlocal = new ThreadLocal<WebDriver>();
      private static ThreadLocal<DesiredCapabilities> desiredCapabilities = new ThreadLocal<DesiredCapabilities>();
      public static WebDriver initialiseLamdaTestSession(String browser,String testName) {
          DesiredCapabilities capabilities =  new DesiredCapabilities();

          Map<String,Object> Itoptions = new HashMap<>();
          capabilities.setCapability("browserName",browser);
          capabilities.setCapability("browserVersion","131");
          capabilities.setCapability("sauce:options", Itoptions);


         // Itoptions.put("username","kalyanpabbathi158");


          Itoptions.put("username", "oauth-kalyanpabbathi158-fef04");
          Itoptions.put("accessKey", "e5a4aafd-0877-4e0c-9c00-465af489f86c");
          Itoptions.put("build", "selenium-build-KIZKK");
          Itoptions.put("name", testName);
                // capabilities.setCapability("LT:Options",Itoptions);
          desiredCapabilities.set(capabilities);
          WebDriver driver = null;
          try {
             // URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
              //RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);

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
