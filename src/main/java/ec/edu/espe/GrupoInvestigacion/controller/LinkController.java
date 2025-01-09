package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoLink;
import ec.edu.espe.GrupoInvestigacion.service.IServiceLink;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/links")
@CrossOrigin(origins = "*")
@Tag(name = "LinkController", description = "Controlador para gestionar enlaces")
public class LinkController {

    @Autowired
    private IServiceLink linkService;

    @Operation(summary = "Obtener todos los enlaces")
    @GetMapping("/")
    public ResponseEntity<List<DtoLink>> getAllLinks() {
        return new ResponseEntity<>(linkService.findAll(), HttpStatus.OK);
    }
    @Operation(summary = "Obtener todas las solicitudes por estado")
    @GetMapping("/state/{estado}")
    public ResponseEntity<List<DtoLink>> getByState(@PathVariable Character estado) {
        return new ResponseEntity<>(linkService.findByState(estado), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un enlace por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoLink> getLinkById(@PathVariable Long id) {
        return new ResponseEntity<>(linkService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo enlace")
    @PostMapping("/create")
    public ResponseEntity<Long> createLink(@RequestBody DtoLink dtoLink) {
        Long savedLink = linkService.save(dtoLink);
        return new ResponseEntity<>(savedLink, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un formulario de vinculacion existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateLink(@PathVariable Long id, @RequestBody DtoLink dtoLink){
        DtoLink existingLink=linkService.find(id);
        if(existingLink==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoLink.setIdVinculacion(id);
        linkService.update(dtoLink);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
