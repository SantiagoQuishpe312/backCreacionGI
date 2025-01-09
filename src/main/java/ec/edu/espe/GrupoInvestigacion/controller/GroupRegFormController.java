package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoGroupRegForm;
import ec.edu.espe.GrupoInvestigacion.service.IServiceGroupRegForm;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH  + "/group-reg-form")
@CrossOrigin(origins = "*")
@Tag(name = "GroupRegFormController", description = "Controlador para gestionar formularios de registro de grupos de investigación")
public class GroupRegFormController {

    @Autowired
    private IServiceGroupRegForm groupRegFormService;

    @Operation(summary = "Obtener todos los formularios de registro de grupos de investigación")
    @GetMapping("/")
    public ResponseEntity<List<DtoGroupRegForm>> getAllGroupRegForms() {
        return new ResponseEntity<>(groupRegFormService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un formulario de registro de grupo de investigación por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoGroupRegForm> getGroupRegFormById(@PathVariable Long id) {
        return new ResponseEntity<>(groupRegFormService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo formulario de registro de grupo de investigación")
    @PostMapping("/add")
    public ResponseEntity<Long> createGroupRegForm(@RequestBody DtoGroupRegForm dtoGroupRegForm) {
        Long createdGroupId = groupRegFormService.create(dtoGroupRegForm);
        return new ResponseEntity<>(createdGroupId, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un formulario de registro de grupo de investigaciónexistente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateGroupRegForm(@PathVariable Long id, @RequestBody DtoGroupRegForm dtoGroupRegForm){
        DtoGroupRegForm existingForm=groupRegFormService.find(id);
        if(existingForm==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoGroupRegForm.setIdFormularioRegistroGrupo(id);
        groupRegFormService.update(dtoGroupRegForm);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
