@MGDGIYM-17
Feature: Emitir acta de registro en UGIN y registrar el grupo de investigación

  Scenario: Registrar un grupo aprobado
    Given que el grupo de investigación tiene el siguiente estado:
      | nombreGrupoInv     | estadoGrupoInv |
      | Grupo A            | Aprobado       |
    When registro el grupo de investigación
    Then se genera el acta de registro y el estado del grupo es "Activo"

  Scenario: Intentar registrar un grupo sin aprobación
    Given que el grupo de investigación tiene el siguiente estado:
      | nombreGrupoInv     | estadoGrupoInv |
      | Grupo B            | Pendiente      |
    When intento registrar el grupo de investigación
    Then se muestra un mensaje indicando que el grupo debe ser aprobado previamente
