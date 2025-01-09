package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoCongress;
import ec.edu.espe.GrupoInvestigacion.service.IServiceCongress;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ec.edu.espe.GrupoInvestigacion.constant.GlobalConstant.PRIVATE_PATH;
import static ec.edu.espe.GrupoInvestigacion.constant.GlobalConstant.V1_API_VERSION;

@RestController
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/congresses")
@CrossOrigin(origins = "*")
@Tag(name = "CongressController", description = "Controlador para gestionar congresos")
public class CongressController {

    @Autowired
    private IServiceCongress congressService;

    @Operation(summary = "Obtener todos los congresos")
    @GetMapping("/")
    public ResponseEntity<List<DtoCongress>> getAllCongresses() {
        return new ResponseEntity<>(congressService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un congreso por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoCongress> getCongressById(@PathVariable Long id) {
        return new ResponseEntity<>(congressService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo congreso")
    @PostMapping("/create")
    public ResponseEntity<Long> createCongress(@RequestBody DtoCongress dtoCongress) {
        Long savedCongress = congressService.save(dtoCongress);
        return new ResponseEntity<>(savedCongress, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un  congreso existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateCongress(@PathVariable Long id,@RequestBody DtoCongress dtoCongress){
        DtoCongress existingCongress=congressService.find(id);
        if(existingCongress==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoCongress.setIdCongreso(id);
        congressService.update(dtoCongress);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
