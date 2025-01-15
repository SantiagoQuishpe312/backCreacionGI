package ec.edu.espe.GrupoInvestigacion.glue;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
public class DevelopmentPlanStepDefinition {
    private String mensaje;
    private boolean formularioValido;

    @Given("que el formulario de plan de desarrollo está habilitado")
    public void que_el_formulario_de_plan_de_desarrollo_esta_habilitado() {
        // Simulación: El formulario está disponible
        System.out.println("Formulario habilitado.");
    }

    @Given("que he completado el formulario de plan de desarrollo con:")
    public void que_he_completado_el_formulario_de_plan_de_desarrollo_con(io.cucumber.datatable.DataTable dataTable) {
        var datos = dataTable.asMaps(String.class, String.class).get(0);

        // Simula la validación de los campos
        formularioValido = datos.get("nombreGrupo") != null && !datos.get("nombreGrupo").isEmpty()
                && datos.get("objetivoPlan") != null && !datos.get("objetivoPlan").isEmpty()
                && datos.get("fechaCreacion") != null && !datos.get("fechaCreacion").isEmpty();

        if (!formularioValido) {
            mensaje = "Error: Campos faltantes.";
        } else {
            mensaje = "Envío exitoso.";
        }
    }

    @When("envío el formulario de plan de desarrollo")
    public void envio_el_formulario_de_plan_de_desarrollo() {
        // Simula el envío del formulario
        System.out.println("Formulario enviado.");
    }

    @Then("debo ver un mensaje de confirmación indicando el envío exitoso")
    public void debo_ver_un_mensaje_de_confirmacion_indicando_el_envio_exitoso() {
        Assertions.assertTrue(formularioValido, "El formulario debería ser válido.");
        Assertions.assertEquals("Envío exitoso.", mensaje, "El mensaje no coincide.");
    }

    @Then("debo ver un mensaje de error indicando los campos faltantes")
    public void debo_ver_un_mensaje_de_error_indicando_los_campos_faltantes() {
        Assertions.assertFalse(formularioValido, "El formulario debería ser inválido.");
        Assertions.assertEquals("Error: Campos faltantes.", mensaje, "El mensaje no coincide.");
    }
}
