package testingweb.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testingweb.selenium.MyWebDriver;

public class DetaineeStepdefs {

  public static WebDriver webDriver;

  public DetaineeStepdefs() {
    webDriver = MyWebDriver.getWebDriver();
  }

  @Given("Hace click en la opción Detainee del menu")
  public void haceClickEnLaOpciónDetaineeDelMenu() {
    WebElement linkDetainee = webDriver.findElement(By.name("link-detainee"));
    linkDetainee.click();
  }

  @When("Hace click en el boton nuevo de la lista")
  public void haceClickEnElBotonNuevoDeLaLista() {
    webDriver.get("http://localhost:8081/onewebs/detainee/new");
  }

  @And("Ingresa los datos del detenido")
  public void ingresaLosDatosDelDetenido() {
    webDriver.findElement(By.id("dni")).sendKeys("70785698");
    webDriver.findElement(By.id("apellidos")).sendKeys("MOLINA");
    webDriver.findElement(By.id("nombres")).sendKeys("LIMENCIO");
    webDriver.findElement(By.id("fechaNacimiento")).sendKeys("25/05/1998");
    webDriver.findElement(By.id("distrito")).sendKeys("Monterrico");
  }

  @And("Hace click en el boton Grabar del formulario de detainee")
  public void haceClickEnElBotonGrabarDelFormularioDeDetainee() {
  }

  @Then("Verificar que el detenido fue registrado")
  public void verificarQueElDetenidoFueRegistrado() {
  }
}
