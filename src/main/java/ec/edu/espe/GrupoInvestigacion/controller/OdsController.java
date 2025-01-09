package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoOds;
import ec.edu.espe.GrupoInvestigacion.service.IServiceOds;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH  +"/ods")
@CrossOrigin(origins = "*")
@Tag(name = "ODSController", description = "Controlador para administrar los Objetivos de Desarrollo Sostenible")

public class OdsController {
    @Autowired
    private IServiceOds serviceOds;

    @Operation(summary = "Obtener todos los objetivos de desarrollo sostenible ODS")
    @GetMapping("/")
    public ResponseEntity<List<DtoOds>> getAll(){
        return new ResponseEntity<>(serviceOds.findAll(), HttpStatus.OK);

    }
    @Operation(summary = "Obtener un objetivo de desarrollo sostenible ODS por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoOds> getOds(@PathVariable Long id){
        return new ResponseEntity<>(serviceOds.find(id),HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo objetivo de desarrollo sostenible ODS")
    @PostMapping("/create")
    public ResponseEntity<Long> createODS(@RequestBody DtoOds dtoOds){
        return new ResponseEntity<>(serviceOds.save(dtoOds),HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un objetivo de desarrollo sostenible ODS existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody DtoOds dtoOds){
        DtoOds exist=serviceOds.find(id);
        if (exist==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoOds.setId(id);
        serviceOds.update(dtoOds);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
