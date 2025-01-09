package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoDevGetLegalFramework;
import ec.edu.espe.GrupoInvestigacion.dto.DtoDeveLega;
import ec.edu.espe.GrupoInvestigacion.dto.DtoReqGetAcademicDom;
import ec.edu.espe.GrupoInvestigacion.service.IServiceDeveLega;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/deve-legas")
@CrossOrigin(origins = "*")
@Tag(name = "DeveLegaController", description = "Controlador para gestionar DeveLegas")
public class DeveLegaController {

    @Autowired
    private IServiceDeveLega deveLegaService;

    @Operation(summary = "Obtener todas las DeveLegas")
    @GetMapping("/")
    public ResponseEntity<List<DtoDeveLega>> getAllDeveLegas() {
        return new ResponseEntity<>(deveLegaService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener una DeveLega por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<List<DtoDeveLega>>  getDeveLegaById(@PathVariable Long id) {
        return new ResponseEntity<>(deveLegaService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear una nueva DeveLega")
    @PostMapping("/create")
    public ResponseEntity<Long> createDeveLega(@RequestBody DtoDeveLega dtoDeveLega) {
        Long savedDeveLega = deveLegaService.save(dtoDeveLega);
        return new ResponseEntity<>(savedDeveLega, HttpStatus.CREATED);
    }
    @Operation(summary = "Obtiene los  marcos legales por el id del Plan de Desarrollo")
    @GetMapping ("/bydev/{id}")
    public ResponseEntity <DtoDevGetLegalFramework> devGetLegalFramework(@PathVariable Long id){
        return new ResponseEntity<>(deveLegaService.findByDev(id),HttpStatus.OK);
    }
}
