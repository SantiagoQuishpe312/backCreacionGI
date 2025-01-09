package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoActivityReport;
import ec.edu.espe.GrupoInvestigacion.service.IServiceActivityReport;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH  +"/actReport")
@CrossOrigin(origins = "*")
@Tag(name = "ActivityReportController", description = "Controlador para gestionar reporte de actividades")

public class ActivityReportController {
    @Autowired
    private IServiceActivityReport serviceActivityReport;
    @Operation(summary = "Obtener todos los Informes de Actividades ")
    @GetMapping("/")
    public ResponseEntity<List<DtoActivityReport>> getAllActivityReports(){
        return new ResponseEntity<>(serviceActivityReport.findAll(), HttpStatus.OK);
    }
    @Operation(summary = "Obtener todos los Informes de Actividades por estado ")
    @GetMapping("/state/{state}")
    public ResponseEntity<List<DtoActivityReport>> getAllActivityReportsByState(@PathVariable Character state){
        return new ResponseEntity<>(serviceActivityReport.findByState(state), HttpStatus.OK);
    }
    @Operation(summary = "Obtiene un Informe Academico Por su Id")
    @GetMapping("/{id}")
    public ResponseEntity<DtoActivityReport> getActivityReportById(@PathVariable Long id){
        return new ResponseEntity<>(serviceActivityReport.find(id),HttpStatus.OK);
    }
    @Operation(summary = "Crea un nuevo Informe Academico")
    @PostMapping("/create")
    public ResponseEntity<Long> createActivityReport(@RequestBody DtoActivityReport dtoActivityReport){
        Long saved=serviceActivityReport.save(dtoActivityReport);
        return new ResponseEntity<>(saved,HttpStatus.CREATED);
    }
    @Operation(summary = "Actualizar un informe Academico existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateActivityReport(@PathVariable Long id, @RequestBody DtoActivityReport dtoActivityReport) {
        DtoActivityReport existingReport=serviceActivityReport.find(id);
        if (existingReport == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoActivityReport.setIdInformeActividades(id);
        serviceActivityReport.update(dtoActivityReport);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
