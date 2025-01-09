package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoDegreeTesis;
import ec.edu.espe.GrupoInvestigacion.service.IServiceDegreeTesis;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/degree-teses")
@CrossOrigin(origins = "*")
@Tag(name = "DegreeTesisController", description = "Controlador para gestionar tesis de grado")
public class DegreeTesisController {

    @Autowired
    private IServiceDegreeTesis degreeTesisService;

    @Operation(summary = "Obtener todas las tesis de grado")
    @GetMapping("/")
    public ResponseEntity<List<DtoDegreeTesis>> getAllDegreeTesis() {
        return new ResponseEntity<>(degreeTesisService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener una tesis de grado por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoDegreeTesis> getDegreeTesisById(@PathVariable Long id) {
        return new ResponseEntity<>(degreeTesisService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear una nueva tesis de grado")
    @PostMapping("/create")
    public ResponseEntity<Long> createDegreeTesis(@RequestBody DtoDegreeTesis dtoDegreeTesis) {
        Long savedDegreeTesis = degreeTesisService.save(dtoDegreeTesis);
        return new ResponseEntity<>(savedDegreeTesis, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualiza una tesis de grado existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateDegreeTesis(@PathVariable Long id,@RequestBody DtoDegreeTesis dtoDegreeTesis){
        DtoDegreeTesis existingTesis=degreeTesisService.find(id);
        if(existingTesis==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoDegreeTesis.setIdTesis(id);
        degreeTesisService.update(dtoDegreeTesis);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
