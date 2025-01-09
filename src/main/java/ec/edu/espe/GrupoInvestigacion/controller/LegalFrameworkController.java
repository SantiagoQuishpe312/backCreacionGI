package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoLegalFramework;
import ec.edu.espe.GrupoInvestigacion.service.IServiceLegalFramework;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/legal-frameworks")
@CrossOrigin(origins = "*")
@Tag(name = "LegalFrameworkController", description = "Controlador para gestionar marcos legales")
public class LegalFrameworkController {

    @Autowired
    private IServiceLegalFramework legalFrameworkService;

    @Operation(summary = "Obtener todos los marcos legales")
    @GetMapping("/")
    public ResponseEntity<List<DtoLegalFramework>> getAllLegalFrameworks() {
        return new ResponseEntity<>(legalFrameworkService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un marco legal por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoLegalFramework> getLegalFrameworkById(@PathVariable Long id) {
        return new ResponseEntity<>(legalFrameworkService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo marco legal")
    @PostMapping("/create")
    public ResponseEntity<Long> createLegalFramework(@RequestBody DtoLegalFramework dtoLegalFramework) {
        Long savedLegalFramework = legalFrameworkService.save(dtoLegalFramework);
        return new ResponseEntity<>(savedLegalFramework, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un marco legal existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateLegalFramework(@PathVariable Long id, @RequestBody DtoLegalFramework dtoLegalFramework){
        DtoLegalFramework existingLegalFramework=legalFrameworkService.find(id);
        if(existingLegalFramework==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoLegalFramework.setIdMarcoLegal(id);
        legalFrameworkService.update(dtoLegalFramework);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
