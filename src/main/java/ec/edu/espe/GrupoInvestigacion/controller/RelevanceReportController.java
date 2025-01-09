package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoRelevanceReport;
import ec.edu.espe.GrupoInvestigacion.service.IServiceRelevanceReport;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH  +"/relevance-report")
@CrossOrigin(origins = "*")
@Tag(name = "ProgressAchController", description = "Controlador para gestionar avances de logros")
public class RelevanceReportController {
    @Autowired
    private IServiceRelevanceReport serviceRelevanceReport;

    @Operation(summary = "Obtener todos los informes de pertinencia")
    @GetMapping("/")
    public ResponseEntity<List<DtoRelevanceReport>> getAll() {
        return new ResponseEntity<>(serviceRelevanceReport.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un informe de pertinencia por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoRelevanceReport> getById(@PathVariable Long id) {
        return new ResponseEntity<>(serviceRelevanceReport.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un informe de pertinencia por su ID")
    @GetMapping("/group/{id}")
    public ResponseEntity<DtoRelevanceReport> getByGroup(@PathVariable Long id) {
        return new ResponseEntity<>(serviceRelevanceReport.findGroup(id), HttpStatus.OK);
    }


    @Operation(summary = "Crear un nuevo informe de pertinencia")
    @PostMapping("/create")
    public ResponseEntity<Long> create(@RequestBody DtoRelevanceReport dtoRelevanceReport) {
        Long savedResearchProject = serviceRelevanceReport.save(dtoRelevanceReport);
        return new ResponseEntity<>(savedResearchProject, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un informe de pertinencia existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody DtoRelevanceReport dtoResearchProject) {
        DtoRelevanceReport existingProject = serviceRelevanceReport.find(id);
        if (existingProject == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoResearchProject.setIdInformePertinencia(id);
        serviceRelevanceReport.update(dtoResearchProject);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
