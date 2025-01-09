package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoAssetsReport;
import ec.edu.espe.GrupoInvestigacion.service.IServiceAssetsReport;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/assestsReport/")
@CrossOrigin(origins = "*")
@Tag(name = "AssetsReportController",description = "Controlador de informe de bienes y equipos de Grupos de investigacion")
public class AssetsReportController {
    @Autowired
    private IServiceAssetsReport assetsReportService;

    @Operation(summary = "Obtener todos los reportes")
    @GetMapping("/")
    public ResponseEntity<List<DtoAssetsReport>> getAllAssetsReport() {
        return new ResponseEntity<>(assetsReportService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener reportes por id")
    @GetMapping("/{id}")
    public ResponseEntity<DtoAssetsReport> getAssetsReportById(@PathVariable Long id) {
        return new ResponseEntity<>(assetsReportService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear nuevos reportes")
    @PostMapping("/create")
    public ResponseEntity<Long> createAssetsReport(@RequestBody DtoAssetsReport dtoAssetsReport) {
        Long savedAssetsReport = assetsReportService.save(dtoAssetsReport);
        return new ResponseEntity<>(savedAssetsReport, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar reporte")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateAssetsReport(@PathVariable Long id, @RequestBody DtoAssetsReport dtoAssetsReport){
        DtoAssetsReport existingAssetsReport = assetsReportService.find(id);
        if(existingAssetsReport == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoAssetsReport.setIdReporteActivos(id);
        assetsReportService.update(dtoAssetsReport);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
