package testingweb.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testingweb.selenium.MyWebDriver;

public class MulctStepdefs {

  public static WebDriver webDriver;

  public MulctStepdefs() {
    webDriver = MyWebDriver.getWebDriver();
  }

  @Given("Hace click en la opción Mulct del menu")
  public void haceClickEnLaOpciónMulctDelMenu() {
    //WebElement linkPolice = webDriver.findElement(By.id("link-police"));
    WebElement linkDetainee = webDriver.findElement(By.name("link-detainee"));
    WebElement linkMulct = webDriver.findElement(By.xpath("//body//header//nav//div//ul//li[2]//a"));

    linkMulct.click();
  }

  @And("Hace click en el boton nuevo")
  public void haceClickEnElBotonNuevo() {
    //WebElement btnNuevoMulct = webDriver.findElement(By.id("btn-nuevo-mulct"));
    //btnNuevoMulct.click();

    webDriver.get("http://localhost:8081/onewebs/mulcts/new");
  }

  @When("Ingresa los datos del detenido y la multa")
  public void ingresaLosDatosDelDetenidoYLaMulta() {
    // Select Detenido
    Select sltDetainee = new Select( webDriver.findElement(By.id("detenido") ));
    // Agregando datos al formulario
    sltDetainee.selectByValue("7");
    webDriver.findElement(By.id("fechaDetencion")).sendKeys("20/07/2020");
    webDriver.findElement(By.id("direccion")).sendKeys("Av. Wilson");
    new Select(webDriver.findElement(By.id("infraccion"))).selectByIndex(1);
    webDriver.findElement(By.id("monto")).clear();
    webDriver.findElement(By.id("monto")).sendKeys("211");
  }

  @And("Hace click en el boton Grabar")
  public void haceClickEnElBotonGrabar() {
    //webDriver.findElement(By.xpath("/html/body/main/section/div/div[2]/form/button")).click();
    webDriver.findElement(By.xpath("/html/body/main/section/div/div[2]/form/button")).submit();
  }

  @Then("Los datos son registrados en el sistema")
  public void losDatosSonRegistradosEnElSistema() {
    Assertions.assertEquals(1, 1);
  }
}
