Feature: Consultar información remitida por un grupo de investigación
  Como un director, coordinador o miembro del comité
  Quiero consultar la información remitida por un grupo de investigación
  Para visualizarla de manera clara y organizada

  Background:
    Given que tengo acceso al sistema como "director"

  Scenario: Consultar información remitida por un grupo válido
    Given que existe un grupo registrado con:
      | idGrupoInv | idCoordinador | nombreGrupoInv     | estadoGrupoInv | acronimoGrupoinv | mision           | vision           |
      | 1          | 1001          | Grupo Innovación   | Activo         | GI2025           | Investigación    | Excelencia       |
    When consulto la información del grupo con ID "1"
    Then debo ver toda la información remitida de forma clara y organizada

  Scenario: Consultar información de un grupo no registrado
    Given que no existe un grupo registrado con ID "9999"
    When consulto la información del grupo con ID "9999"
    Then debo ver un mensaje indicando que no existe información para el grupo
