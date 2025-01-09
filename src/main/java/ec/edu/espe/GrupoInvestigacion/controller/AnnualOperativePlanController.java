package ec.edu.espe.GrupoInvestigacion.controller;


import ec.edu.espe.GrupoInvestigacion.dto.DtoAnnualOperativePlan;
import ec.edu.espe.GrupoInvestigacion.service.IServiceAnnualOperativePlan;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

import static ec.edu.espe.GrupoInvestigacion.constant.GlobalConstant.PRIVATE_PATH;
import static ec.edu.espe.GrupoInvestigacion.constant.GlobalConstant.V1_API_VERSION;

@RestController
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/annualOperativePlan/")
@CrossOrigin("*")
@Tag(name = "AnnualOperativePlanController",description = " Controlodaro de plances anuales operativos")
public class AnnualOperativePlanController {
    @Autowired
    private IServiceAnnualOperativePlan annualOperativePlanService;

    @Operation(summary = "Obtener todos los planes operativos anuales")
    @GetMapping("/")
    public ResponseEntity<List<DtoAnnualOperativePlan>> getAllAnnualOperativePlans() {
        return new ResponseEntity<>(annualOperativePlanService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener Planes operativos anuales por id")
    @GetMapping("/{id}")
    public ResponseEntity<DtoAnnualOperativePlan> getAnnualOperativePlanById(@PathVariable Long id) {
        return new ResponseEntity<>(annualOperativePlanService.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "Creal nuevos planes operativos")
    @PostMapping("/created")
    public ResponseEntity<Long> createAnnualOperativePlan(@RequestBody DtoAnnualOperativePlan dtoAnnualOperativePlan) {
        Long savedAnnualOperativePlan = annualOperativePlanService.save(dtoAnnualOperativePlan);
        return new ResponseEntity<>(savedAnnualOperativePlan, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar planes operativos")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateAnnualOperativePlan(@PathVariable Long id, @RequestBody DtoAnnualOperativePlan dtoAnnualOperativePlan) {
        DtoAnnualOperativePlan existingAnnualOperativePlan = annualOperativePlanService.findById(id);
        if(existingAnnualOperativePlan == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoAnnualOperativePlan.setIdAnnualOperativePlan(id);
        annualOperativePlanService.update(dtoAnnualOperativePlan);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
