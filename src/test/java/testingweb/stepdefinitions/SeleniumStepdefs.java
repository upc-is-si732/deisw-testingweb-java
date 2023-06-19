package testingweb.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testingweb.selenium.MyWebDriver;

public class SeleniumStepdefs {
  public static WebDriver webDriver;

  public SeleniumStepdefs() {
    webDriver = MyWebDriver.getWebDriver();
  }

  @Given("El policia ingresa a la webapp")
  public void elPoliciaIngresaALaWebapp() {
    webDriver.get("http://localhost:8081/onewebs/login");
    webDriver.manage().window().maximize();
  }

  @And("El policia ingresa el username, password y hace click en login")
  public void elPoliciaIngresaElUsernamePasswordYHaceClickEnLogin() {
    webDriver.findElement(By.id("inputUsername")).sendKeys("police1");
    webDriver.findElement(By.id("inputPassword")).sendKeys("police");
    webDriver.findElement(By.xpath("/html/body/div/form/button")).click();
  }
}
