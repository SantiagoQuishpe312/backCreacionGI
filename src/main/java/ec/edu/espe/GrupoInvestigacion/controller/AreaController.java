package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoArea;
import ec.edu.espe.GrupoInvestigacion.service.IServiceArea;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH  +"/areas")
@CrossOrigin(origins = "*")
@Tag(name = "AreaController", description = "Controlador  para gestionar áreas")
public class AreaController {

    @Autowired
    private IServiceArea areaService;


    @Operation(summary = "Obtener todas las áreas")
    @GetMapping("/")
    public ResponseEntity<List<DtoArea>> getAllAreas() {
        return new ResponseEntity<>(areaService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un área por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoArea> getAreaById(@PathVariable Long id) {
        return new ResponseEntity<>(areaService.find(id), HttpStatus.OK);
    }
    @Operation(summary = "Crea una nueva Área")
    @PostMapping("/create")
    public ResponseEntity<Long>createArea(@RequestBody DtoArea dtoArea){
        Long savedArea= areaService.save(dtoArea);
        return new ResponseEntity<>(savedArea, HttpStatus.CREATED);
    }
    @Operation(summary = "Actualiza una área")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateArea(@PathVariable Long id,@RequestBody DtoArea dtoArea){
        DtoArea existingArea=areaService.find(id);
        if (existingArea==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoArea.setIdArea(id);
        areaService.update(dtoArea);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }
}
