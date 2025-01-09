package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoMagazines;
import ec.edu.espe.GrupoInvestigacion.service.IServiceMagazines;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/magazines")
@CrossOrigin(origins = "*")
@Tag(name = "MagazinesController", description = "Controlador para gestionar revistas")
public class MagazinesController {

    @Autowired
    private IServiceMagazines magazineService;

    @Operation(summary = "Obtener todas las revistas")
    @GetMapping("/")
    public ResponseEntity<List<DtoMagazines>> getAllMagazines() {
        return new ResponseEntity<>(magazineService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener una revista por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoMagazines> getMagazineById(@PathVariable Long id) {
        return new ResponseEntity<>(magazineService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear una nueva revista")
    @PostMapping("/create")
    public ResponseEntity<Long> createMagazine(@RequestBody DtoMagazines dtoMagazine) {
        Long savedMagazine = magazineService.save(dtoMagazine);
        return new ResponseEntity<>(savedMagazine, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar una revista existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateMagazine(@PathVariable Long id, @RequestBody DtoMagazines dtoMagazines){
        DtoMagazines existingMagazine=magazineService.find(id);
        if(existingMagazine==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoMagazines.setIdRevista(id);
        magazineService.update(dtoMagazines);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
