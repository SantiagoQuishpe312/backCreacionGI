@MGDGIYM-16
Feature: Enviar memorando de revisión de información remitida

  Scenario: Completar memorando con observaciones y enviarlo
    Given que el memorando incluye los siguientes datos:
      | campo        | valor                 |
      | asunto       | Revisión Observaciones |
      | contenido    | Observaciones detalladas |
      | destinatarios | evaluador@correo.com  |
    When envío el memo
    Then se confirma el envío del memorando a los destinatarios correspondientes con el asunto "Revisión Observaciones"

  Scenario: Intentar enviar memorando con datos faltantes
    Given que el memorando incluye los siguientes datos:
      | campo        | valor |
      | asunto       |       |
      | contenido    |       |
      | destinatarios |       |
    When envío el memo
    Then se muestra un mensaje indicando los datos requeridos: "Asunto, Contenido, Destinatarios"
