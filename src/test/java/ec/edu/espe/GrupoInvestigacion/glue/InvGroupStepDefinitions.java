package ec.edu.espe.GrupoInvestigacion.glue;
import ec.edu.espe.GrupoInvestigacion.dao.DaoInvGroup;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup;
import ec.edu.espe.GrupoInvestigacion.model.ModelInvGroup;
import ec.edu.espe.GrupoInvestigacion.model.ModelUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
public class InvGroupStepDefinitions {
    private String baseUrl = "http://localhost:8080/api/v1.0/private/inv-group";
    private ResponseEntity<String> response;
    private DtoInvGroup dtoInvGroup;

    @Autowired
    private DaoInvGroup daoInvGroup;

    @Given("the user with ID {long} exists and has an associated research group")
    public void theUserWithIdExistsAndHasAnAssociatedResearchGroup(Long userId) {
        // Valida que el usuario tenga grupos asociados en la base de datos
        var groups = daoInvGroup.findByIdUser(userId);
        assertThat(groups).isPresent().as("Expected user with ID %d to have associated groups", userId);
    }

    @Given("the user with ID {long} exists but has no associated groups")
    public void theUserWithIdExistsButHasNoAssociatedGroups(Long userId) {
        // Valida que el usuario no tenga grupos asociados en la base de datos
        var groups = daoInvGroup.findByIdUser(userId);
        assertThat(groups).isEmpty().as("Expected user with ID %d to have no associated groups", userId);
    }

    @When("the user sends a GET request to {string}")
    public void theUserSendsAGetRequestTo(String endpoint) {
        RestTemplate restTemplate = new RestTemplate();
        String finalUrl = endpoint.startsWith("http") ? endpoint : baseUrl + endpoint; // Verifica si ya es una URL completa
        response = restTemplate.getForEntity(finalUrl, String.class);
    }


    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int statusCode) {
        assertThat(response.getStatusCodeValue()).isEqualTo(statusCode);
    }

    @Then("the response should contain group data")
    public void theResponseShouldContainGroupData() {
        assertThat(response.getBody()).isNotEmpty();
    }

    @Then("the response should contain an empty body")
    public void theResponseShouldContainAnEmptyBody() {
        String body = response.getBody();
        // Verifica si el cuerpo contiene un objeto DtoInvGroup con todos los campos vacíos
        assertThat(body).matches("<DtoInvGroup>.*<idGrupoInv/>.*<idCoordinador/>.*<nombreGrupoInv/>.*<estadoGrupoInv/>.*<acronimoGrupoinv/>.*<mision/>.*<vision/>.*<departamento/>.*<proceso/>.*<usuarioCreacion/>.*<fechaCreacion/>.*<usuarioModificacion/>.*<fechaModificacion/>.*</DtoInvGroup>");
    }

    @Given("el siguiente grupo de investigación a crear")
    public void elSiguienteGrupoDeInvestigacionACrear(io.cucumber.datatable.DataTable dataTable) {
        var data = dataTable.asMaps(String.class, String.class).get(0);
        dtoInvGroup = new DtoInvGroup();

        // Manejo del idCoordinador como número obligatorio
        String idCoordinadorStr = data.get("idCoordinador");
        if (idCoordinadorStr != null && !idCoordinadorStr.isEmpty()) {
            dtoInvGroup.setIdCoordinador(Long.parseLong(idCoordinadorStr));
        } else {
            throw new IllegalArgumentException("El campo idCoordinador es obligatorio y debe ser un número.");
        }

        dtoInvGroup.setNombreGrupoInv(data.get("nombreGrupoInv"));
        dtoInvGroup.setEstadoGrupoInv(data.get("estadoGrupoInv"));
        dtoInvGroup.setAcronimoGrupoinv(data.get("acronimoGrupoinv"));
        dtoInvGroup.setMision(data.get("mision"));
        dtoInvGroup.setVision(data.get("vision"));
        dtoInvGroup.setDepartamento(data.get("departamento"));
        dtoInvGroup.setProceso(data.get("proceso"));
        dtoInvGroup.setUsuarioCreacion(data.get("usuarioCreacion"));

        // Conversión de fecha
        String fechaCreacionStr = data.get("fechaCreacion");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaCreacion = formatter.parse(fechaCreacionStr);
            dtoInvGroup.setFechaCreacion(fechaCreacion);
        } catch (ParseException e) {
            throw new RuntimeException("Error al parsear la fecha: " + fechaCreacionStr, e);
        }
    }


    @When("el usuario envía una solicitud POST a {string} con los datos del grupo")
    public void elUsuarioEnviaUnaSolicitudPOSTAConLosDatosDelGrupo(String endpoint) {
        RestTemplate restTemplate = new RestTemplate();
        response = restTemplate.postForEntity(endpoint, dtoInvGroup, String.class);
    }

    @Then("el estado de la respuesta debería ser {int}")
    public void elEstadoDeLaRespuestaDeberiaSer(int statusCode) {
        assertThat(response.getStatusCodeValue()).isEqualTo(statusCode);
    }

    @Then("la respuesta debería contener el ID del nuevo grupo creado")
    public void laRespuestaDeberiaContenerElIdDelNuevoGrupoCreado() {
        String body = response.getBody();
        // Extraer el número del XML o JSON
        String idRegex = "<Long>(\\d+)</Long>"; // Adaptar según el formato exacto
        Pattern pattern = Pattern.compile(idRegex);
        Matcher matcher = pattern.matcher(body);
        assertThat(matcher.find()).isTrue();
        String id = matcher.group(1);
        assertThat(id).matches("\\d+");
    }

    @Then("la respuesta debería contener un mensaje de error indicando los campos faltantes")
    public void laRespuestaDeberiaContenerUnMensajeDeErrorIndicandoLosCamposFaltantes() {
        assertThat(response.getBody()).contains("error");
    }
}
