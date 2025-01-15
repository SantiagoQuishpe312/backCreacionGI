Feature: Enviar memorando de revisión de información remitida
  Como evaluador de grupos de investigación
  Quiero enviar un memorando con observaciones
  Para revisar la información remitida por los grupos de investigación

  Background:
    Given que tengo acceso al sistema con rol de "evaluador de grupos de investigación"

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
