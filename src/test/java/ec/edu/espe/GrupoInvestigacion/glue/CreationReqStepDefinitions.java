package ec.edu.espe.GrupoInvestigacion.glue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreationReqStepDefinitions {

    private ResponseEntity<String> response;

    @Autowired
    private RestTemplate restTemplate;

    @Given("el sistema está en funcionamiento")
    public void elSistemaEstaEnFuncionamiento() {
        // Aquí podrías verificar que el servidor esté en funcionamiento si es necesario.
        // Para propósitos de este caso, asumimos que el sistema está corriendo.
    }

    @When("el usuario envía una solicitud POST a {string} con los datos del grupo")
    public void elUsuarioEnviaUnaSolicitudPOSTAConLosDatosDelGrupo(String endpoint) {
        String url = "http://localhost:8080/api/v1.0/private/creation-req" + endpoint;

        // Datos de entrada para la solicitud
        String requestJson = """
        {
            "idGrupoInv": 1,
            "alineacionEstrategica": "Innovación",
            "estado": "A",
            "usuarioCreacionPeticion": "user1",
            "fechaCreacionPeticion": "2025-01-04"
        }
        """;

        response = restTemplate.postForEntity(url, requestJson, String.class);
    }

    @Then("la respuesta debería ser {int} {string}")
    public void laRespuestaDeberiaSer(int statusCode, String statusText) {
        assertEquals(statusCode, response.getStatusCodeValue());
    }

    @Then("la respuesta debería contener el ID del nuevo grupo creado")
    public void laRespuestaDeberiaContenerElIdDelNuevoGrupoCreado() {
        // Aquí podrías verificar que el cuerpo de la respuesta contenga un ID válido
        String responseBody = response.getBody();
        assert responseBody != null;
        boolean idPresent = responseBody.matches("\\d+");
        assertEquals(true, idPresent, "La respuesta debería contener un ID numérico.");
    }
}
