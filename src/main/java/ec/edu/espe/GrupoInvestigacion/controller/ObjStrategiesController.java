package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoObjStrategies;
import ec.edu.espe.GrupoInvestigacion.service.IServiceObjStrategies;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH  +"/obj-strategies")
@CrossOrigin(origins = "*")
@Tag(name = "ObjStrategiesController", description = "Controlador para gestionar objetivos estratégicos")
public class ObjStrategiesController {

    @Autowired
    private IServiceObjStrategies objStrategiesService;

    @Operation(summary = "Obtener todos los objetivos estratégicos")
    @GetMapping("/")
    public ResponseEntity<List<DtoObjStrategies>> getAllObj() {
        return new ResponseEntity<>(objStrategiesService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener una objetivo estratégico por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoObjStrategies> getObjById(@PathVariable Long id) {
        return new ResponseEntity<>(objStrategiesService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo objetivo estratégico")
    @PostMapping("/create")
    public ResponseEntity <Long> createObjStrategies(@RequestBody DtoObjStrategies dtoObjStrategies){
        Long savedObj=objStrategiesService.save(dtoObjStrategies);
        return new ResponseEntity<>(savedObj,HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un objetivo estrategico existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateObjStrategies(@PathVariable Long id,@RequestBody DtoObjStrategies dtoObjStrategies){
        DtoObjStrategies existingObj=objStrategiesService.find(id);
        if(existingObj==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoObjStrategies.setIdObjetivo(id);
        objStrategiesService.update(dtoObjStrategies);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
