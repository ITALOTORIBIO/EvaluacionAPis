package com.nttdata.petstore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;
public class CrearOrderStepDefs {
    @Steps
    CrearOrder crearOrder;

    @When("creo la orden con el petId {int}, quantity {int}, status {string}")
    public void crearOrder(int petId, int quantity, String status){
        crearOrder.crearOrder(petId, quantity, status);
    }

    @Then("el código de respuesta es {int}")
    public void elCódigoDeRespuestaEs(int statusCode) {
        restAssuredThat(response -> response.log().all().statusCode(statusCode));
    }

    @And("el message es {string}")
    public void elTypeEs(String message) {
        restAssuredThat(response -> response.body("'message'", equalTo(message)));
        System.out.println("message: " + SerenityRest.lastResponse().body().path("message").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }

}
