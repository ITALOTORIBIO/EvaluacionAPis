package com.nttdata.petstore;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CrearOrder {
    private static String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order";

    @Step
    public void crearOrder(int petId, int quantity, String status){
        SerenityRest.given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"petId\": \""+petId+"\",\n" +
                        "  \"quantity\": \""+quantity+"\",\n" +
                        "  \"status\": \""+status+"\",\n" +
                        "  \"complete\": \"boolean\",\n" +
                        "}")
                .post(CREATE_ORDER);

    }
}
