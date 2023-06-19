package testingweb.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class HomeStepdefs {
    @Given("Ingreso a la pagina de la UPC")
    public void ingresoALaPaginaDeLaUPC() {
        Assertions.assertEquals(1, 1);
    }

    @When("Selecciono la opcion carrera")
    public void seleccionoLaOpcionCarrera() {
        Assertions.assertEquals(1, 1);
    }

    @Then("Muestra información de las carreras")
    public void muestraInformacionDeLasCarreras() {
        Assertions.assertEquals(1, 1);
    }
}
