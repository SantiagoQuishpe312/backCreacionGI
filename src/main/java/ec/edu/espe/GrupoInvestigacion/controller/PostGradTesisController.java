package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoPostGradTesis;
import ec.edu.espe.GrupoInvestigacion.service.IServicePostGradTesis;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/post-grad-tesis")
@CrossOrigin(origins = "*")
@Tag(name = "PostGradTesisController", description = "Controlador para gestionar tesis de postgrado")
public class PostGradTesisController {

    @Autowired
    private IServicePostGradTesis postGradTesisService;

    @Operation(summary = "Obtener todas las tesis de postgrado")
    @GetMapping("/")
    public ResponseEntity<List<DtoPostGradTesis>> getAllPostGradTesis() {
        return new ResponseEntity<>(postGradTesisService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener una tesis de postgrado por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoPostGradTesis> getPostGradTesisById(@PathVariable Long id) {
        return new ResponseEntity<>(postGradTesisService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear una nueva tesis de postgrado")
    @PostMapping("/create")
    public ResponseEntity<Long> createPostGradTesis(@RequestBody DtoPostGradTesis dtoPostGradTesis) {
        Long savedPostGradTesis = postGradTesisService.save(dtoPostGradTesis);
        return new ResponseEntity<>(savedPostGradTesis, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar una tesis de postgrado existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updatePostGradTesis(@PathVariable Long id, @RequestBody DtoPostGradTesis dtoPostGradTesis){
        DtoPostGradTesis existingTesis=postGradTesisService.find(id);
        if(existingTesis==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoPostGradTesis.setIdTesis(id);
        postGradTesisService.update(dtoPostGradTesis);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
