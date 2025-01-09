package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroupGetData;
import ec.edu.espe.GrupoInvestigacion.service.IServiceInvGroup;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH  +"/inv-group")
@CrossOrigin(origins = "*")
@Tag(name = "InvGroupController", description = "Controlador para gestionar grupos de investigación")
public class InvGroupController {

    @Autowired
    private IServiceInvGroup invGroupService;

    @Operation(summary = "Obtener todos los grupos de investigación")
    @GetMapping("/")
    public ResponseEntity<List<DtoInvGroup>> getAllInvGroups() {
        return new ResponseEntity<>(invGroupService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un grupo de investigación por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoInvGroup> getInvGroupById(@PathVariable Long id) {

        return new ResponseEntity<>(invGroupService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Obtener toda la informacion grupo de investigación por su ID")
    @GetMapping("/all/{id}")
    public ResponseEntity<DtoInvGroupGetData> getAllDataInvGroupById(@PathVariable Long id) {

        return new ResponseEntity<>(invGroupService.findAllData(id), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un grupo de investigación por su nombre")
    @GetMapping("/user/{id}")
    public ResponseEntity<DtoInvGroup> getInvGroupByUser(@PathVariable Long id) {

        return new ResponseEntity<>(invGroupService.findByUser(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo grupo de investigación")
    @PostMapping("/create")
    public ResponseEntity<Long> createInvGroup(@RequestBody DtoInvGroup dtoInvGroup){
      Long savedInvGroup=invGroupService.save(dtoInvGroup);
      return new ResponseEntity<>(savedInvGroup,HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un grupo de investigación existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateInvGroup(@PathVariable Long id, @RequestBody DtoInvGroup dtoInvGroup){
        DtoInvGroup existingGroup=invGroupService.find(id);
        if(existingGroup==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoInvGroup.setIdGrupoInv(id);
        invGroupService.update(dtoInvGroup);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
