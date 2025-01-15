package ec.edu.espe.GrupoInvestigacion.glue;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;
public class InfoGroupStepDefinition {
    private Map<Long, DtoInvGroup> gruposRegistrados = new HashMap<>();
    private String mensaje;
    private DtoInvGroup grupoConsultado;

    @Given("que tengo acceso al sistema como {string}")
    public void que_tengo_acceso_al_sistema_como(String rol) {
        // Simula que el usuario tiene acceso al sistema con el rol especificado
        System.out.println("Acceso al sistema como: " + rol);
    }

    @Given("que existe un grupo registrado con:")
    public void que_existe_un_grupo_registrado_con(io.cucumber.datatable.DataTable dataTable) {
        var datos = dataTable.asMaps(String.class, String.class).get(0);

        DtoInvGroup grupo = new DtoInvGroup();
        grupo.setIdGrupoInv(Long.parseLong(datos.get("idGrupoInv")));
        grupo.setIdCoordinador(Long.parseLong(datos.get("idCoordinador")));
        grupo.setNombreGrupoInv(datos.get("nombreGrupoInv"));
        grupo.setEstadoGrupoInv(datos.get("estadoGrupoInv"));
        grupo.setAcronimoGrupoinv(datos.get("acronimoGrupoinv"));
        grupo.setMision(datos.get("mision"));
        grupo.setVision(datos.get("vision"));

        gruposRegistrados.put(grupo.getIdGrupoInv(), grupo);
    }

    @Given("que no existe un grupo registrado con ID {string}")
    public void que_no_existe_un_grupo_registrado_con_id(String idGrupoInv) {
        gruposRegistrados.remove(Long.parseLong(idGrupoInv));
    }

    @When("consulto la información del grupo con ID {string}")
    public void consulto_la_informacion_del_grupo_con_id(String idGrupoInv) {
        Long id = Long.parseLong(idGrupoInv);
        if (gruposRegistrados.containsKey(id)) {
            grupoConsultado = gruposRegistrados.get(id);
            mensaje = null;
        } else {
            grupoConsultado = null;
            mensaje = "No existe información para el grupo.";
        }
    }

    @Then("debo ver toda la información remitida de forma clara y organizada")
    public void debo_ver_toda_la_informacion_remitida_de_forma_clara_y_organizada() {
        Assertions.assertNotNull(grupoConsultado, "El grupo no debería ser nulo.");
        System.out.println("Información del grupo: " + grupoConsultado);
    }

    @Then("debo ver un mensaje indicando que no existe información para el grupo")
    public void debo_ver_un_mensaje_indicando_que_no_existe_informacion_para_el_grupo() {
        Assertions.assertNull(grupoConsultado, "El grupo debería ser nulo.");
        Assertions.assertEquals("No existe información para el grupo.", mensaje, "El mensaje no coincide.");
    }
}
