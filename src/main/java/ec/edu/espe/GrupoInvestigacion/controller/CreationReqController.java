package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoCreationReq;
import ec.edu.espe.GrupoInvestigacion.service.IServiceCreationReq;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH  +"/creation-req")
@CrossOrigin(origins = "*")
@Tag(name = "CreationReqController", description = "Controlador para gestionar petición de creación")
public class CreationReqController {

    @Autowired
    private IServiceCreationReq creationReqService;

    @Operation(summary = "Obtener todas las peticiones de creación")
    @GetMapping("/")
    public ResponseEntity<List<DtoCreationReq>> getAllCreationReqs() {
        return new ResponseEntity<>(creationReqService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener una petición de creación por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoCreationReq> getCreationReqlistById(@PathVariable Long id) {
        return new ResponseEntity<>(creationReqService.find(id), HttpStatus.OK);
    }
    @Operation(summary = "Obtener una petición de creación por su grupo")
    @GetMapping("/byGroup/{id}")
    public ResponseEntity<DtoCreationReq> getCreationReqlistByGroup(@PathVariable Long id) {
        return new ResponseEntity<>(creationReqService.findByGroup(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear una nueva petición de creación")
    @PostMapping("/create")
    public ResponseEntity<Long> createReq(@RequestBody DtoCreationReq dtoCreationReq) {
        Long savedCreationReq=creationReqService.save(dtoCreationReq);
        return new ResponseEntity<>(savedCreationReq, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualiza una petición de creación")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateReq(@PathVariable Long id,@RequestBody DtoCreationReq dtoCreationReq) {
        DtoCreationReq existingReq=creationReqService.find(id);
        if(existingReq==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoCreationReq.setIdPeticionCreacion(id);
        creationReqService.update(dtoCreationReq);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
