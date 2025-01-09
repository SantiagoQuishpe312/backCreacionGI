package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoUpperLevelPlan;
import ec.edu.espe.GrupoInvestigacion.service.IServiceUpperLevelPlan;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/upper-level-plans")
@CrossOrigin(origins = "*")
@Tag(name = "UpperLevelPlanController", description = "Controlador para gestionar planes de nivel superior")
public class UpperLevelPlanController {

    @Autowired
    private IServiceUpperLevelPlan upperLevelPlanService;

    @Operation(summary = "Obtener todos los planes de nivel superior")
    @GetMapping("/")
    public ResponseEntity<List<DtoUpperLevelPlan>> getAllUpperLevelPlans() {
        return new ResponseEntity<>(upperLevelPlanService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un plan de nivel superior por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoUpperLevelPlan> getUpperLevelPlanById(@PathVariable Long id) {
        return new ResponseEntity<>(upperLevelPlanService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo plan de nivel superior")
    @PostMapping("/create")
    public ResponseEntity<Long> createUpperLevelPlan(@RequestBody DtoUpperLevelPlan dtoUpperLevelPlan) {
        Long savedUpperLevelPlan = upperLevelPlanService.save(dtoUpperLevelPlan);
        return new ResponseEntity<>(savedUpperLevelPlan, HttpStatus.CREATED);
    }
    @Operation(summary = "Actualizar un plan de nivel superior por su ID")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUpperLevelPlan(@PathVariable Long id, @RequestBody DtoUpperLevelPlan dtoUpperLevelPlan) {
        DtoUpperLevelPlan existingPlan = upperLevelPlanService.find(id);
        if (existingPlan == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoUpperLevelPlan.setIdPlanNivelSuperior(id); // Ensure the ID is set correctly
        upperLevelPlanService.update(dtoUpperLevelPlan);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
