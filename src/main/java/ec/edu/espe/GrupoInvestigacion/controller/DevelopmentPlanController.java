package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoDevelopmentPlan;
import ec.edu.espe.GrupoInvestigacion.dto.DtoGroupRegForm;
import ec.edu.espe.GrupoInvestigacion.service.IServiceDevelopmentPlan;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ec.edu.espe.GrupoInvestigacion.constant.GlobalConstant.PRIVATE_PATH;
import static ec.edu.espe.GrupoInvestigacion.constant.GlobalConstant.V1_API_VERSION;

@RestController
@RequestMapping(V1_API_VERSION + PRIVATE_PATH  +"/development-plan")
@CrossOrigin(origins = "*")
@Tag(name = "DevelopmentPlanController", description = "Controlador para gestionar el plan de operación")
public class DevelopmentPlanController {

    @Autowired
    private IServiceDevelopmentPlan developmentPlanService;

    @Operation(summary = "Obtener todos los planes de operación")
    @GetMapping("/")
    public ResponseEntity<List<DtoDevelopmentPlan>> getAllDevelopmentPlans() {
        return new ResponseEntity<>(developmentPlanService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un plan de operación por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoDevelopmentPlan> getDevelopmentPlanById(@PathVariable Long id) {
        return new ResponseEntity<>(developmentPlanService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un plan de operación por el ID de su grupo")
    @GetMapping("groupC/{id}")
    public ResponseEntity<List<DtoDevelopmentPlan>> getDevelopmentPlanByGroupC(@PathVariable Long id) {
        return new ResponseEntity<>(developmentPlanService.findGroupC(id), HttpStatus.OK);
    }
    @Operation(summary = "Obtener un plan de operación por el ID de su grupo y el tipo de Plan de Desarrollo")
    @GetMapping("group/{id}/Type/{tipo}")
    public ResponseEntity<List<DtoDevelopmentPlan>> getDevelopmentPlanByGroupType(@PathVariable Long id, @PathVariable String tipo) {
        return new ResponseEntity<>(developmentPlanService.findGroupType(id, tipo.charAt(0)), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo plan de operación")
    @PostMapping("/create")
    public ResponseEntity<Long> createDevelopmentPlan(@RequestBody DtoDevelopmentPlan dtoDevelopmentPlan) {
        Long createdDevPlanId = developmentPlanService.create(dtoDevelopmentPlan);
        return new ResponseEntity<>(createdDevPlanId, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualiza un plan de operacion")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateDevelopmentPlan(@PathVariable Long id,@RequestBody DtoDevelopmentPlan dtoDevelopmentPlan){
        DtoDevelopmentPlan existingPlan=developmentPlanService.find(id);
        if(existingPlan==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoDevelopmentPlan.setIdPlanDesarrollo(id);
        developmentPlanService.update(dtoDevelopmentPlan);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
