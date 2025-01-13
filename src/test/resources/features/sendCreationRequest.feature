Feature: Creación de una nueva petición de grupo de investigación

  Scenario: Creación exitosa de una nueva petición
    Given el sistema está en funcionamiento
    When el usuario envía una solicitud POST a "/create" con los datos del grupo
    Then la respuesta debería ser 201 "Created"
    And la respuesta debería contener el ID del nuevo grupo creado
