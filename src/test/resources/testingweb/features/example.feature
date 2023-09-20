Feature: Mostrar información de la carrera de Ingenieria de Software
  As a Student I want Visit the Software Engineer page so that view information
  Scenario: Load page successful
    Given El estudiante se encuentra en la pagina de la UPC
    And Selecciona la opcion carreras de pregrado
    And Selecciona la facultad de ingeniería
    When hace clic en la opción Ingeniería de Software
    Then Cargará la página