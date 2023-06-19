Feature: El app permite registrar multas
  Background:
    Given El policia ingresa a la webapp
    And El policia ingresa el username, password y hace click en login
  Scenario: Registro de una nueva multa
    Given Hace click en la opción Mulct del menu
    And Hace click en el boton nuevo
    When Ingresa los datos del detenido y la multa
    And Hace click en el boton Grabar
    Then Los datos son registrados en el sistema
