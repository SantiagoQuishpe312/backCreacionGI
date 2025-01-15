package ec.edu.espe.GrupoInvestigacion.glue;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class MemoResponseStepDefinition {
    private Map<String, String> memorando = new HashMap<>();
    private String mensaje;

    @Given("que tengo acceso al sistema con rol de {string}")
    public void que_tengo_acceso_al_sistema_como(String rol) {
        System.out.println("Acceso al sistema como: " + rol);
    }

    @Given("que el memorando incluye los siguientes datos:")
    public void que_el_memorando_incluye_los_siguientes_datos(io.cucumber.datatable.DataTable dataTable) {
        memorando.clear();
        memorando.putAll(dataTable.asMap(String.class, String.class));
    }

    @When("envío el memo")
    public void envio_el_memorando() {
        // Se asegura de que no se intente llamar a isEmpty() sobre un valor nulo
        if (isNullOrEmpty(memorando.get("asunto")) || isNullOrEmpty(memorando.get("contenido")) || isNullOrEmpty(memorando.get("destinatarios"))) {
            mensaje = "Asunto, Contenido, Destinatarios";
        } else {
            mensaje = "Envío exitoso";
        }
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }

    @Then("se confirma el envío del memorando a los destinatarios correspondientes con el asunto {string}")
    public void se_confirma_el_envio_del_memorando_a_los_destinatarios_correspondientes_con_el_asunto(String asuntoEsperado) {
        Assertions.assertEquals("Envío exitoso", mensaje, "El envío no se realizó correctamente.");
        Assertions.assertEquals(asuntoEsperado, memorando.get("asunto"), "El asunto no coincide.");
    }

    @Then("se muestra un mensaje indicando los datos requeridos: {string}")
    public void se_muestra_un_mensaje_indicando_los_datos_requeridos(String mensajeEsperado) {
        Assertions.assertEquals(mensajeEsperado, mensaje, "El mensaje de error no coincide.");
    }
}
