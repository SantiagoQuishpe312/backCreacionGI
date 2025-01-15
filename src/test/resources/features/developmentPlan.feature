Feature: Enviar el plan de desarrollo del grupo de investigación
  Como un usuario
  Quiero enviar un plan de desarrollo del grupo de investigación
  Para que sea almacenado para evaluación

  Background:
    Given que el formulario de plan de desarrollo está habilitado

  Scenario: Completar el formulario con datos correctos
    Given que he completado el formulario de plan de desarrollo con:
      | nombreGrupo       | objetivoPlan        | fechaCreacion |
      | Grupo Innovación  | Mejora continua     | 2025-01-15    |
    When envío el formulario de plan de desarrollo
    Then debo ver un mensaje de confirmación indicando el envío exitoso

  Scenario: Completar el formulario con datos incompletos
    Given que he completado el formulario de plan de desarrollo con:
      | nombreGrupo       | objetivoPlan        | fechaCreacion |
      |                   | Mejora continua     |               |
    When envío el formulario de plan de desarrollo
    Then debo ver un mensaje de error indicando los campos faltantes
