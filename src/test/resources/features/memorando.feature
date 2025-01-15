Feature: Enviar un memorando de conformación de un grupo de investigación
  Como un usuario
  Quiero enviar un memorando de conformación de un grupo de investigación
  Para notificar a los destinatarios correspondientes

  Background:
    Given que el grupo de investigación está aprobado

  Scenario: Enviar memorando con la información correcta
    Given que he completado el memorando con:
      | destinatario       | asunto                   | cuerpo                             |
      | director@uni.edu   | Conformación del grupo   | Felicitaciones, su grupo ha sido aprobado. |
    When envío el memorando
    Then debo ver un mensaje de confirmación indicando el envío exitoso del memorando

  Scenario: Enviar memorando con campos incompletos
    Given que he completado el memorando con:
      | destinatario       | asunto                   | cuerpo |
      |                    | Conformación del grupo   |        |
    When envío el memorando
    Then debo ver un mensaje de error indicando qué datos faltan del memorando
