package testingweb.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyWebDriver {
  public static WebDriver webDriver;

  private MyWebDriver() {  }
  public static WebDriver getWebDriver() {
    if (webDriver == null)  {
      // For Win
      String pathDriver = System.getProperty("user.dir") + "\\driver\\chromedriver_117.exe";
      // for Mac
      // String pathDriver = System.getProperty("user.dir") + "/driver/chromedriver_114";
      System.setProperty("webdriver.chrome.driver", pathDriver);
      webDriver = new ChromeDriver();
    }
    return webDriver;
  }
}
