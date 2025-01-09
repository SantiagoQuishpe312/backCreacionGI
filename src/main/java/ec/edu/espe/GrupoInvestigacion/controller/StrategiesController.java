package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoStrategies;
import ec.edu.espe.GrupoInvestigacion.service.IServiceStrategies;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/strategies")
@CrossOrigin(origins = "*")
@Tag(name = "StrategiesController", description = "Controlador para gestionar estrategias")
public class StrategiesController {

    @Autowired
    private IServiceStrategies strategyService;

    @Operation(summary = "Obtener todas las estrategias")
    @GetMapping("/")
    public ResponseEntity<List<DtoStrategies>> getAllStrategies() {
        return new ResponseEntity<>(strategyService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener una estrategia por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoStrategies> getStrategyById(@PathVariable Long id) {
        return new ResponseEntity<>(strategyService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Obtener todas las estrategias por objetivo")
    @GetMapping("/byObj/{id}")
    public ResponseEntity<List<DtoStrategies>> getByObj(@PathVariable Long id) {
        return new ResponseEntity<>(strategyService.findByObj(id), HttpStatus.OK);
    }

  /*  @Operation(summary = "Obtener todas las estrategias por objetivo")
    @GetMapping("/complete/{idPlan}")
    public ResponseEntity<List<DtoObjGetStrategies>> getComplete(@PathVariable Long idPlan) {
        return new ResponseEntity<>(strategyService.findComplete(idPlan), HttpStatus.OK);
    }*/

    @Operation(summary = "Crear una nueva estrategia")
    @PostMapping("/create")
    public ResponseEntity<Long> createStrategy(@RequestBody DtoStrategies dtoStrategy) {
        Long savedStrategy = strategyService.save(dtoStrategy);
        return new ResponseEntity<>(savedStrategy, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar una estrategia existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateStrategy(@PathVariable Long id, @RequestBody DtoStrategies dtoStrategies){
        DtoStrategies existingStrategy=strategyService.find(id);
        if(existingStrategy==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoStrategies.setIdEstrategia(id);
        strategyService.update(dtoStrategies);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
