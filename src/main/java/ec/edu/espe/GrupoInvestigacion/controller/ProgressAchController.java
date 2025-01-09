package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoProgressAchiev;
import ec.edu.espe.GrupoInvestigacion.service.IServiceProgressAch;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH  +"/progress-ach")
@CrossOrigin(origins = "*")
@Tag(name = "ProgressAchController", description = "Controlador para gestionar avances de logros")
public class ProgressAchController {

    @Autowired
    private IServiceProgressAch progressAchService;

    @Operation(summary = "Obtener todos los avances de logros")
    @GetMapping("/")
    public ResponseEntity<List<DtoProgressAchiev>> getAllProgressArch(){
        return new ResponseEntity<>(progressAchService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un avance de logro por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoProgressAchiev> getProgressArchById(@PathVariable Long id){
        return new ResponseEntity<>(progressAchService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo avance de logro")
    @PostMapping("/create")
    public ResponseEntity <Long> createProgressAch(@RequestBody DtoProgressAchiev dtoProgressAchiev){
        Long savedProgress=progressAchService.save(dtoProgressAchiev);
        return new ResponseEntity<>(savedProgress,HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un logro existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateProgressAch(@PathVariable Long id, @RequestBody DtoProgressAchiev dtoProgressAchiev) {
        DtoProgressAchiev existingAchiev = progressAchService.find(id);
        if (existingAchiev == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoProgressAchiev.setIdLogro(id);
        progressAchService.update(dtoProgressAchiev);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
