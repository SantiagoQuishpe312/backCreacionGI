package ec.edu.espe.GrupoInvestigacion.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Grupo Investigación",
                version = "1.0.0",
                description = "Proyecto Grupos de Investigación"
        )
)
public class SwaggerConfig {
}

//Link de documentacion de APIS:
//http://localhost:8080/swagger-ui/index.html