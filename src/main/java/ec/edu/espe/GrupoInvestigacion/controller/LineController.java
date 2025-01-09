package ec.edu.espe.GrupoInvestigacion.controller;


import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup;
import ec.edu.espe.GrupoInvestigacion.dto.DtoLine;
import ec.edu.espe.GrupoInvestigacion.dto.DtoLineGetArea;
import ec.edu.espe.GrupoInvestigacion.service.IServiceLine;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH  +"/line")
@CrossOrigin(origins = "*")
@Tag(name = "LineController", description = "Controlador para gestionar líneas de investigación")
public class LineController {

    @Autowired
    private IServiceLine lineService;

    @Operation(summary = "Obtener todas las líneas de investigación")
    @GetMapping("/")
    public ResponseEntity<List<DtoLine>> getAllLines(){
        return new ResponseEntity<>(lineService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener una línea de investigación por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoLine> getLineById(@PathVariable Long id) {

        return new ResponseEntity<>(lineService.find(id), HttpStatus.OK);
    }
    @Operation(summary = "Crea una nueva linea de Investigación")
    @PostMapping ("/create")
    public ResponseEntity<Long>createLine(@RequestBody DtoLine dtoLine){
        Long savedLine= lineService.save(dtoLine);
        return new ResponseEntity<>(savedLine,HttpStatus.CREATED);
    }

    @Operation(summary = "Obtiene una Linea de Investigación completa con el Area al que pertenece")
    @GetMapping ("/getAreaLine/{id}")
    public ResponseEntity<DtoLineGetArea>getAreaResponseEntity(@PathVariable Long id){
        return new ResponseEntity<>(lineService.findAreaByLine(id), HttpStatus.OK);

    }

    @Operation(summary = "Obtiene las lineas de investigación dependiendo del area al que pertenezca")
    @GetMapping ("/getLineByArea/{id}")
    public ResponseEntity<List<DtoLine>> getLineByArea(@PathVariable Long id){
        return new ResponseEntity<>(lineService.findLineByArea(id), HttpStatus.OK);

    }
    @Operation(summary = "Actualizar una linea de investigacion existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateLine(@PathVariable Long id, @RequestBody DtoLine dtoLine){
        DtoLine existingLine=lineService.find(id);
        if(existingLine==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoLine.setIdLinea(id);
        lineService.update(dtoLine);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
