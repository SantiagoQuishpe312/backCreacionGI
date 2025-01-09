package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoArea;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup_Area;
import ec.edu.espe.GrupoInvestigacion.dto.DtoReqGetArea;
import ec.edu.espe.GrupoInvestigacion.service.IServiceInvGroup_Area;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/invGroup_area")
@CrossOrigin(origins = "*")
@Tag(name = "CreaAreaController", description = "Controlador para gestionar petición de creación de areas")
public class InvGroup_AreaController {

    @Autowired
    private IServiceInvGroup_Area creaAreaService;

    @Operation(summary = "Obtener todas las peticiones de creación de areas")
    @GetMapping("/")
    public ResponseEntity<List<DtoInvGroup_Area>> getAllCreaAreas() {
        return new ResponseEntity<>(creaAreaService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener peticiones de creación de areas por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<List<DtoInvGroup_Area>> getCreaAreaById(@PathVariable Long id) {
        return new ResponseEntity<>(creaAreaService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear una nueva peticion de areas")
    @PostMapping("/create")
    public ResponseEntity <Long> createCreaArea(@RequestBody DtoInvGroup_Area dtoInvGroupArea){
        Long savedCreaArea=creaAreaService.save(dtoInvGroupArea);
        return new ResponseEntity<>(savedCreaArea,HttpStatus.CREATED);
    }
    @Operation(summary = "Obtiene las areas por el id del Formulario de Creacion")
    @GetMapping ("/byGroup/{id}")
    public ResponseEntity <List<DtoArea>> reqGetArea(@PathVariable Long id){
        return new ResponseEntity<>(creaAreaService.findByGroup(id),HttpStatus.OK);
    }

    @Operation(summary = "Eliminar ")
    @DeleteMapping("/{areaId}/group/{groupId}")
    public ResponseEntity<Void> delete(@PathVariable Long areaId, @PathVariable Long groupId) {
        creaAreaService.delete(groupId,areaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
