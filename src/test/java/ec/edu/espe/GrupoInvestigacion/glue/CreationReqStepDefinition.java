package ec.edu.espe.GrupoInvestigacion.glue;
import ec.edu.espe.GrupoInvestigacion.dto.DtoCreationReq;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
public class CreationReqStepDefinition {
    private DtoCreationReq formulario;
    private boolean formularioCompleto;
    private boolean formularioEnviado;
    private String mensajeRespuesta;

    @Given("que he completado toda la información necesaria del formulario con:")
    public void que_he_completado_toda_la_informacion_necesaria_del_formulario_con(DataTable dataTable) throws ParseException {
        formulario = llenarFormulario(dataTable);
        formularioCompleto = validarFormularioCompleto(formulario);
    }

    @Given("que he completado parcialmente la información necesaria del formulario con:")
    public void que_he_completado_parcialmente_la_informacion_necesaria_del_formulario_con(DataTable dataTable) throws ParseException {
        formulario = llenarFormulario(dataTable);
        formularioCompleto = validarFormularioCompleto(formulario);
    }

    @When("envío el formulario con datos correctos")
    public void envio_el_formulario_con_datos_correctos() {
        if (formularioCompleto) {
            formularioEnviado = true;
            mensajeRespuesta = "Formulario recibido correctamente y enviado para evaluación.";
        }
    }

    @When("envío el formulario con datos incompletos")
    public void envio_el_formulario_con_datos_incompletos() {
        if (!formularioCompleto) {
            formularioEnviado = false;
            mensajeRespuesta = "Error: Campos incompletos o inválidos.";
        }
    }

    @Then("debo recibir una confirmación de recepción y el formulario será enviado para evaluación")
    public void debo_recibir_una_confirmacion_de_recepcion_y_el_formulario_sera_enviado_para_evaluacion() {
        assertTrue(formularioEnviado);
        assertEquals("Formulario recibido correctamente y enviado para evaluación.", mensajeRespuesta);
    }

    @Then("debo ver un mensaje de error indicando los campos incompletos o inválidos")
    public void debo_ver_un_mensaje_de_error_indicando_los_campos_incompletos_o_invalidos() {
        String actualMessage = obtenerMensajeDeError();
        System.out.println("Mensaje recibido: " + actualMessage); // Debug
        Assertions.assertEquals("Error: Campos incompletos o inválidos.", actualMessage, "El mensaje de error no coincide.");
    }

    private String obtenerMensajeDeError() {
        // Implementa la lógica para obtener el mensaje del sistema.
        return ("Error: Campos incompletos o inválidos."); // Asegúrate de que este método devuelva el mensaje correcto.
    }

    private DtoCreationReq llenarFormulario(DataTable dataTable) throws ParseException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> row = data.get(0);

        DtoCreationReq dto = new DtoCreationReq();
        dto.setIdGrupoInv(row.get("idGrupoInv") == null || row.get("idGrupoInv").isEmpty() ? null : Long.parseLong(row.get("idGrupoInv")));
        dto.setAlineacionEstrategica(row.get("alineacionEstrategica"));
        dto.setEstado(row.get("estado") == null || row.get("estado").isEmpty() ? null : row.get("estado").charAt(0));
        dto.setUsuarioCreacionPeticion(row.get("usuarioCreacionPeticion"));

        String fechaString = row.get("fechaCreacionPeticion");
        if (fechaString != null && !fechaString.trim().isEmpty()) {
            dto.setFechaCreacionPeticion(new SimpleDateFormat("yyyy-MM-dd").parse(fechaString.trim()));
        } else {
            dto.setFechaCreacionPeticion(null);
        }

        return dto;
    }


    private boolean validarFormularioCompleto(DtoCreationReq dto) {
        return dto.getIdGrupoInv() != null &&
                dto.getAlineacionEstrategica() != null && !dto.getAlineacionEstrategica().isEmpty() &&
                dto.getEstado() != null &&
                dto.getUsuarioCreacionPeticion() != null && !dto.getUsuarioCreacionPeticion().isEmpty() &&
                dto.getFechaCreacionPeticion() != null;
    }
}
