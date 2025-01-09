package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoDevGetNationalPlan;
import ec.edu.espe.GrupoInvestigacion.dto.DtoDevGetUpperLevelPlan;
import ec.edu.espe.GrupoInvestigacion.dto.DtoDeveUppe;
import ec.edu.espe.GrupoInvestigacion.service.IServiceDeveUppe;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/deve-uppes")
@CrossOrigin(origins = "*")
@Tag(name = "DeveUppeController", description = "Controlador para gestionar DeveUppes")
public class DeveUppeController {

    @Autowired
    private IServiceDeveUppe deveUppeService;

    @Operation(summary = "Obtener todos los DeveUppes")
    @GetMapping("/")
    public ResponseEntity<List<DtoDeveUppe>> getAllDeveUppes() {
        return new ResponseEntity<>(deveUppeService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un DeveUppe por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<List<DtoDeveUppe>> getDeveUppeById(@PathVariable Long id) {
        return new ResponseEntity<>(deveUppeService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo DeveUppe")
    @PostMapping("/create")
    public ResponseEntity<Long> createDeveUppe(@RequestBody DtoDeveUppe dtoDeveUppe) {
        Long savedDeveUppe = deveUppeService.save(dtoDeveUppe);
        return new ResponseEntity<>(savedDeveUppe, HttpStatus.CREATED);
    }
    @Operation(summary = "Obtiene los  planes de nivel superior por el id del Plan de Desarrollo")
    @GetMapping ("/bydev/{id}")
    public ResponseEntity <DtoDevGetUpperLevelPlan> devGetUpperLevelPlan(@PathVariable Long id){
        return new ResponseEntity<>(deveUppeService.findByDev(id),HttpStatus.OK);
    }
}
