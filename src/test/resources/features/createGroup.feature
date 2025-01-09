@MGDGIYM-9
Feature: Crear un nuevo grupo de investigación

  Scenario: Crear un grupo de investigación exitosamente
    Given el siguiente grupo de investigación a crear
      | idCoordinador | nombreGrupoInv | estadoGrupoInv | acronimoGrupoinv | mision | vision | departamento | proceso | usuarioCreacion | fechaCreacion |
      | 223           | Grupo Alpha    | Activo         | ALPHA            | Misión | Visión | IT           | Proceso | admin           | 2023-01-01    |
    When el usuario envía una solicitud POST a "http://localhost:8080/api/v1.0/private/inv-group/create" con los datos del grupo
    Then el estado de la respuesta debería ser 201
    And la respuesta debería contener el ID del nuevo grupo creado

  Scenario: Intentar crear un grupo de investigación con datos incompletos
    Given el siguiente grupo de investigación a crear
      | idCoordinador | nombreGrupoInv | estadoGrupoInv | acronimoGrupoinv | mision | vision | departamento | proceso | usuarioCreacion | fechaCreacion |
      | 223           | Grupo Beta     | Activo         | BETA             | Misión | Visión |              | Proceso | admin           | 2023-01-01    |
    When el usuario envía una solicitud POST a "http://localhost:8080/api/v1.0/private/inv-group/create" con los datos del grupo
    Then el estado de la respuesta debería ser 201
