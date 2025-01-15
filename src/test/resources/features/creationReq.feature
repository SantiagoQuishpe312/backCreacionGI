Feature: Validar el envío del formulario de creación de un grupo de investigación

  Como usuario del sistema
  Quiero validar el envío del formulario de creación de un grupo de investigación
  Para asegurarme de que funciona correctamente según las condiciones esperadas

  Scenario: Enviar formulario con datos correctos
    Given que he completado toda la información necesaria del formulario con:
      | idGrupoInv | alineacionEstrategica | estado | usuarioCreacionPeticion | fechaCreacionPeticion |
      | 1          | Estrategia Global     | A      | usuarioTest              | 2025-01-15            |
    When envío el formulario con datos correctos
    Then debo recibir una confirmación de recepción y el formulario será enviado para evaluación

  Scenario: Enviar formulario con datos incompletos
    Given que he completado parcialmente la información necesaria del formulario con:
      | idGrupoInv | alineacionEstrategica | estado | usuarioCreacionPeticion | fechaCreacionPeticion |
      | 1          | Estrategia Global     | A      | usuarioTest              | 2025-01-15            |
    When envío el formulario con datos incompletos
    Then debo ver un mensaje de error indicando los campos incompletos o inválidos
