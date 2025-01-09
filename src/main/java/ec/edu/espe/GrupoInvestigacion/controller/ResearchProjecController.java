package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoResearchProject;
import ec.edu.espe.GrupoInvestigacion.service.IServiceResearchProjec;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/research-projects")
@CrossOrigin(origins = "*")
@Tag(name = "ResearchProjectController", description = "Controlador para gestionar proyectos de investigación")
public class ResearchProjecController {

    @Autowired
    private IServiceResearchProjec researchProjectService;

    @Operation(summary = "Obtener todos los proyectos de investigación")
    @GetMapping("/")
    public ResponseEntity<List<DtoResearchProject>> getAllResearchProjects() {
        return new ResponseEntity<>(researchProjectService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un proyecto de investigación por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoResearchProject> getResearchProjectById(@PathVariable Long id) {
        return new ResponseEntity<>(researchProjectService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo proyecto de investigación")
    @PostMapping("/create")
    public ResponseEntity<Long> createResearchProject(@RequestBody DtoResearchProject dtoResearchProject) {
        Long savedResearchProject = researchProjectService.save(dtoResearchProject);
        return new ResponseEntity<>(savedResearchProject, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un proyecto de investigación existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateResearchProject(@PathVariable Long id, @RequestBody DtoResearchProject dtoResearchProject) {
        DtoResearchProject existingProject = researchProjectService.find(id);
        if (existingProject == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoResearchProject.setIdProyecto(id);
        researchProjectService.update(dtoResearchProject);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
