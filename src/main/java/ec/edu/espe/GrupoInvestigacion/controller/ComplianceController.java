package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoCompliance;
import ec.edu.espe.GrupoInvestigacion.service.IServiceCompliance;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ec.edu.espe.GrupoInvestigacion.constant.GlobalConstant.PRIVATE_PATH;
import static ec.edu.espe.GrupoInvestigacion.constant.GlobalConstant.V1_API_VERSION;

@RestController
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/compliance")
@CrossOrigin(origins = "*")
@Tag(name = "ComplianceController", description = "Controlador para gestionar el cumplimiento de un objetivo de un Informe de Actividades")

public class ComplianceController {
    @Autowired
    private IServiceCompliance serviceCompliance;

    @Operation(summary = "Obtener el cumplimiento de los Objetivos por Reporte Anual")
    @GetMapping("/activityReport/{id}")
    public ResponseEntity<List<DtoCompliance>> getByActReportId(@PathVariable Long id){
        return new ResponseEntity<>(serviceCompliance.findByActReport(id), HttpStatus.OK);
    }

    @Operation(summary = "Obtener el cumplimiento de los Objetivos por Id del Objetivo")
    @GetMapping("/specificObj/{id}")
    public ResponseEntity<List<DtoCompliance>> getByObjId(@PathVariable Long id){
        return new ResponseEntity<>(serviceCompliance.findByObj(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo control de Cumplimiento")
    @PostMapping("/create")
    public ResponseEntity<Long> createCompliance(@RequestBody DtoCompliance dtoCompliance){
        Long saved= serviceCompliance.save(dtoCompliance);
        return new ResponseEntity<>(saved,HttpStatus.CREATED);
    }
}
