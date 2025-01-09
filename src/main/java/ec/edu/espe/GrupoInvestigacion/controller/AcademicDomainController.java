package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoAcademicDomain;
import ec.edu.espe.GrupoInvestigacion.dto.DtoNationalPlan;
import ec.edu.espe.GrupoInvestigacion.service.IServiceAcademicDomain;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH  +"/academic-domains")
@CrossOrigin(origins = "*")
@Tag(name = "AcademicDomainController", description = "Controlador para gestionar dominios académicos")
public class AcademicDomainController {

    @Autowired
    private IServiceAcademicDomain academicDomainService;

    @Operation(summary = "Obtener todos los dominios académicos")
    @GetMapping("/")
    public ResponseEntity<List<DtoAcademicDomain>> getAllAcademicDomains() {
        return new ResponseEntity<>(academicDomainService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un dominio académico por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoAcademicDomain> getAcademicDomainById(@PathVariable Long id) {
        return new ResponseEntity<>(academicDomainService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crea un nuevo Dominio Academico")
    @PostMapping("/create")
    public ResponseEntity<Long>createAcademicDomain(@RequestBody DtoAcademicDomain dtoAcademicDomain){
        Long savedAcademicDomain=academicDomainService.save(dtoAcademicDomain);
        return new ResponseEntity<>(savedAcademicDomain, HttpStatus.CREATED);
    }
    @Operation(summary = "Actualizar un dominio academico existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateAcademicDomain(@PathVariable Long id, @RequestBody DtoAcademicDomain dtoAcademicDomain) {
        DtoAcademicDomain existingAcadDom=academicDomainService.find(id);
        if (existingAcadDom == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoAcademicDomain.setIdDomimioAcademico(id);
        academicDomainService.update(dtoAcademicDomain);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
