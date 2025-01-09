package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoAnnualControl;
import ec.edu.espe.GrupoInvestigacion.dto.DtoDeveLega;
import ec.edu.espe.GrupoInvestigacion.service.IServiceAnnualControl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ec.edu.espe.GrupoInvestigacion.constant.GlobalConstant.PRIVATE_PATH;
import static ec.edu.espe.GrupoInvestigacion.constant.GlobalConstant.V1_API_VERSION;

@RestController
@RequestMapping(V1_API_VERSION+PRIVATE_PATH+"/annualControl")
@CrossOrigin(origins="*")
@Tag(name="AnnualControlController",description = "Controlador para gestionar los controles Anuales")
public class AnnualControlController {
    @Autowired
    private IServiceAnnualControl serviceAnnualControl;

    @Operation(summary = "Obtener todos loS Controles Anuales por el id del plan de annual")
    @GetMapping("/AnnualPlan/{id}")
    public ResponseEntity<List<DtoAnnualControl>> getByAnnualPlan(@PathVariable Long id){
        return new ResponseEntity<>(serviceAnnualControl.findByPlan(id), HttpStatus.OK);
    }

    @Operation(summary = "Obtener todos loS Controles Anuales por el id del Panel de Control")
    @GetMapping("/ControlPanel/{id}")
    public ResponseEntity<List<DtoAnnualControl>> getByControlPanel(@PathVariable Long id){
        return new ResponseEntity<>(serviceAnnualControl.findByPanel(id), HttpStatus.OK);
    }

    @Operation(summary = "Obtener el Control Anual Filtrado especifico")
    @GetMapping("/")
    public ResponseEntity<DtoAnnualControl> getbyControlAndPlan(@PathVariable Long idPanel,@PathVariable Long idPlan) {
        return new ResponseEntity<>(serviceAnnualControl.findByIds(idPanel,idPlan), HttpStatus.OK);
    }

    @Operation(summary = "Crear una nueva DeveLega")
    @PostMapping("/create")
    public ResponseEntity<Long> createAnnualControl(@RequestBody DtoAnnualControl dtoAnnualControl) {
        Long saved = serviceAnnualControl.save(dtoAnnualControl);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
}
