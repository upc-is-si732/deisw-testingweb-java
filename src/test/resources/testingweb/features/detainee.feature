Feature: El App permite el registro de un nuevo detenido
  Yo Como policia quiero registrar lo nuevos detenido para tener el registro completo
  Background:
    Given El policia ingresa a la webapp
    And El policia ingresa el username, password y hace click en login
  Scenario: Registro de un nuevo detenido
    Given Hace click en la opción Detainee del menu
    When Hace click en el boton nuevo de la lista
    And Ingresa los datos del detenido
    And Hace click en el boton Grabar del formulario de detainee
    Then Verificar que el detenido fue registrado
