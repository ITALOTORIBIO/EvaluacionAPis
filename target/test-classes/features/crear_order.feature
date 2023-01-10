Feature: Crear orden PetStore

  @test1
  Scenario: Crear orden

    When creo la orden con el petId 10, quantity 40, status "placed"
    Then el código de respuesta es 500
    And el message es "something bad happened"

  @test2
  Scenario: Obtener orden

    When obtengo la orden con el id 2
    Then el código de respuesta sera 200
    And el status es "placed"
