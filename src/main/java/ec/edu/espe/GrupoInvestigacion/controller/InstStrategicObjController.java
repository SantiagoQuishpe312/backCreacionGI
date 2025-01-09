package ec.edu.espe.GrupoInvestigacion.controller;


import ec.edu.espe.GrupoInvestigacion.dto.DtoInstStrategicObj;
import ec.edu.espe.GrupoInvestigacion.service.IServiceInstStrategicObj;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/instStrategicObj/")
@CrossOrigin(origins = "*")
@Tag(name = "InstStrategicObjController", description = "Controlador para gestionar Objetivos estrategicos")
public class InstStrategicObjController {
    @Autowired
    private IServiceInstStrategicObj instStrategicObjservice;

    @Operation(summary = "Obtener los objetivos")
    @GetMapping("/")
    public ResponseEntity<List<DtoInstStrategicObj>> getAllInstStrategicObjs() {
        return new ResponseEntity<>(instStrategicObjservice.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener los objetivo estrategico por ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoInstStrategicObj> getInstStrategicObjById(@PathVariable Long id) {
        return new ResponseEntity<>(instStrategicObjservice.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear nuevos objetivos estrategicos")
    @PostMapping("/create")
    public ResponseEntity<Long>createInstStrategicObj(@RequestBody DtoInstStrategicObj dtoInstStrategicObj) {
        Long savedInstStrategicObj = instStrategicObjservice.save(dtoInstStrategicObj);
        return new ResponseEntity<>(savedInstStrategicObj, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar objetivos estrategicos")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateInstStrategicObj(@PathVariable Long id, @RequestBody DtoInstStrategicObj dtoInstStrategicObj) {
        DtoInstStrategicObj existingInstStrategicObj = instStrategicObjservice.find(id);
        if (existingInstStrategicObj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoInstStrategicObj.setIdObjetivoEstrategico(id);
        instStrategicObjservice.update(dtoInstStrategicObj);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
