package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoNationalPlan;
import ec.edu.espe.GrupoInvestigacion.service.IServiceNationalPlan;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/national-plans")
@CrossOrigin(origins = "*")
@Tag(name = "NationalPlanController", description = "Controlador para gestionar planes nacionales")
public class NationalPlanController {

    @Autowired
    private IServiceNationalPlan nationalPlanService;

    @Operation(summary = "Obtener todos los planes nacionales")
    @GetMapping("/")
    public ResponseEntity<List<DtoNationalPlan>> getAllNationalPlans() {
        return new ResponseEntity<>(nationalPlanService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un plan nacional por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoNationalPlan> getNationalPlanById(@PathVariable Long id) {
        return new ResponseEntity<>(nationalPlanService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo plan nacional")
    @PostMapping("/create")
    public ResponseEntity<Long> createNationalPlan(@RequestBody DtoNationalPlan dtoNationalPlan) {
        Long savedNationalPlan = nationalPlanService.save(dtoNationalPlan);
        return new ResponseEntity<>(savedNationalPlan, HttpStatus.CREATED);
    }
    @Operation(summary = "Actualizar un plan nacional existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateNationalPlan(@PathVariable Long id, @RequestBody DtoNationalPlan dtoNationalPlan) {
       DtoNationalPlan existingPlan=nationalPlanService.find(id);
        if (existingPlan == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoNationalPlan.setIdPlanNacional(id);
        nationalPlanService.update(dtoNationalPlan);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
