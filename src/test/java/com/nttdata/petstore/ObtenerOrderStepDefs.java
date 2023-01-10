package com.nttdata.petstore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ObtenerOrderStepDefs {

    @When("obtengo la orden con el id {int}")
    public void obtenerOrder(int id){
        String GET_ORDER="https://petstore.swagger.io/v2/store/order/"+id;

        SerenityRest.given().contentType("application/json")
                .get(GET_ORDER);
    }

    @Then("el código de respuesta sera {int}")
    public void codRespuesta(int code) {
        restAssuredThat(response -> response.log().all().statusCode(code));
    }

    @And("el status es {string}")
    public void elStatusEs(String status) {
        restAssuredThat(response -> response.body("'status'", equalTo(status)));
        System.out.println("status: " + SerenityRest.lastResponse().body().path("status").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }
}
