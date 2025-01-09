package ec.edu.espe.GrupoInvestigacion.config;

import ec.edu.espe.GrupoInvestigacion.GrupoInvestigacionApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { GrupoInvestigacionApplication.class })
public class CucumberSpringConfiguration {
}
