package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoAnnexes;
import ec.edu.espe.GrupoInvestigacion.dto.DtoGroupRegForm;
import ec.edu.espe.GrupoInvestigacion.service.IServiceAnnexes;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH  +"/annexes")
@CrossOrigin(origins = "*")
@Tag(name = "AnnexesController", description = "Controlador  para gestionar anexos")
public class AnnexesController {

    @Autowired
    private IServiceAnnexes annexesService;

    @Operation(summary = "Obtener todos los anexos")
    @GetMapping("/")
    public ResponseEntity<List<DtoAnnexes>> getAllAnnexes() {
        return new ResponseEntity<>(annexesService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un anexo por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoAnnexes> getAnnexById(@PathVariable Long id) {
        return new ResponseEntity<>(annexesService.find(id), HttpStatus.OK);
    }
    @Operation(summary = "Obtener un anexo cuando sea un baremo por el Id del grupo")
    @GetMapping("/group/{id}/type/{tipo}")
    public ResponseEntity<List<DtoAnnexes>> getAnnexBarById(@PathVariable Long id, @PathVariable String tipo) {

        String tipoWithWildcards = "%" + tipo + "%";
        System.out.println("ID: " + id);
        System.out.println("Tipo: " + tipo);
        return new ResponseEntity<>(annexesService.findBar(id,tipoWithWildcards), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo anexo")
    @PostMapping("/create")
    public ResponseEntity<Long> createAnnexes(@RequestBody DtoAnnexes dtoAnnexes) {
        Long annexesId = annexesService.create(dtoAnnexes);
        return new ResponseEntity<>(annexesId, HttpStatus.CREATED);
    }
    @Operation(summary = "Actualiza un Annexo existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateAnnexes(@PathVariable Long id, @RequestBody DtoAnnexes dtoAnnexes){
        DtoAnnexes existingAnnexes=annexesService.find(id);
        if(existingAnnexes==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoAnnexes.setIdAnexo(id);
        annexesService.update(dtoAnnexes);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
