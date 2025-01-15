package ec.edu.espe.GrupoInvestigacion.glue;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

public class MemorandoStepDefinition {
    private String mensaje;
    private boolean memorandoValido;

    @Given("que el grupo de investigación está aprobado")
    public void que_el_grupo_de_investigacion_esta_aprobado() {
        // Simulación: El grupo está aprobado
        System.out.println("Grupo de investigación aprobado.");
    }

    @Given("que he completado el memorando con:")
    public void que_he_completado_el_memorando_con(io.cucumber.datatable.DataTable dataTable) {
        var datos = dataTable.asMaps(String.class, String.class).get(0);

        // Validar que todos los campos estén completos
        memorandoValido = datos.get("destinatario") != null && !datos.get("destinatario").isEmpty()
                && datos.get("asunto") != null && !datos.get("asunto").isEmpty()
                && datos.get("cuerpo") != null && !datos.get("cuerpo").isEmpty();

        if (!memorandoValido) {
            mensaje = "Error: Faltan datos en el memorando.";
        } else {
            mensaje = "Memorando enviado exitosamente.";
        }
    }

    @When("envío el memorando")
    public void envio_el_memorando() {
        // Simula el envío del memorando
        System.out.println("Enviando memorando...");
    }

    @Then("debo ver un mensaje de confirmación indicando el envío exitoso del memorando")
    public void debo_ver_un_mensaje_de_confirmacion_indicando_el_envio_exitoso() {
        Assertions.assertTrue(memorandoValido, "El memorando debería ser válido.");
        Assertions.assertEquals("Memorando enviado exitosamente.", mensaje, "El mensaje no coincide.");
    }

    @Then("debo ver un mensaje de error indicando qué datos faltan del memorando")
    public void debo_ver_un_mensaje_de_error_indicando_que_datos_faltan() {
        Assertions.assertFalse(memorandoValido, "El memorando debería ser inválido.");
        Assertions.assertEquals("Error: Faltan datos en el memorando.", mensaje, "El mensaje no coincide.");
    }
}
