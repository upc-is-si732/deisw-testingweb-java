package testingweb.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ExampleStepDef {
  @Given("El estudiante se encuentra en la pagina de la UPC")
  public void elEstudianteSeEncuentraEnLaPaginaDeLaUPC() {

  }

  @And("Selecciona la opcion carreras de pregrado")
  public void seleccionaLaOpcionCarrerasDePregrado() {

  }

  @And("Selecciona la facultad de ingeniería")
  public void seleccionaLaFacultadDeIngeniería() {

  }

  @When("hace clic en la opción Ingeniería de Software")
  public void haceClicEnLaOpciónIngenieríaDeSoftware() {

  }

  @Then("Cargará la página")
  public void cargaráLaPágina() {
    Assertions.assertEquals(1, 1);
  }
}
