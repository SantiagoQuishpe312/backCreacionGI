package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoDevGetLegalFramework;
import ec.edu.espe.GrupoInvestigacion.dto.DtoDevGetNationalPlan;
import ec.edu.espe.GrupoInvestigacion.dto.DtoDeveNati;
import ec.edu.espe.GrupoInvestigacion.service.IServiceDeveNati;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/deve-natis")
@CrossOrigin(origins = "*")
@Tag(name = "DeveNatiController", description = "Controlador para gestionar DeveNatis")
public class DeveNatiController {

    @Autowired
    private IServiceDeveNati deveNatiService;

    @Operation(summary = "Obtener todos los DeveNatis")
    @GetMapping("/")
    public ResponseEntity<List<DtoDeveNati>> getAllDeveNatis() {
        return new ResponseEntity<>(deveNatiService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un DeveNati por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<List<DtoDeveNati>> getDeveNatiById(@PathVariable Long id) {
        return new ResponseEntity<>(deveNatiService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo DeveNati")
    @PostMapping("/create")
    public ResponseEntity<Long> createDeveNati(@RequestBody DtoDeveNati dtoDeveNati) {
        Long savedDeveNati = deveNatiService.save(dtoDeveNati);
        return new ResponseEntity<>(savedDeveNati, HttpStatus.CREATED);
    }
    @Operation(summary = "Obtiene los  planes nacionales por el id del Plan de Desarrollo")
    @GetMapping ("/bydev/{id}")
    public ResponseEntity <DtoDevGetNationalPlan> devGetNationalPlan(@PathVariable Long id){
        return new ResponseEntity<>(deveNatiService.findByDev(id),HttpStatus.OK);
    }
}
