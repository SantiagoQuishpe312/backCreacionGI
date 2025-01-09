package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInvMember;
import ec.edu.espe.GrupoInvestigacion.dto.DtoUser;
import ec.edu.espe.GrupoInvestigacion.service.IServiceInvMember;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/inv-members")
@CrossOrigin(origins = "*")
@Tag(name = "InvMemberController", description = "Controlador para gestionar miembros de investigación")
public class InvMemberController {

    @Autowired
    private IServiceInvMember invMemberService;

    @Operation(summary = "Obtener todos los miembros de investigación")
    @GetMapping("/")
    public ResponseEntity<List<DtoInvMember>> getAllInvMembers() {
        return new ResponseEntity<>(invMemberService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un miembro de investigación por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoInvMember> getInvMemberById(@PathVariable Long id) {
        return new ResponseEntity<>(invMemberService.find(id), HttpStatus.OK);
    }
    @Operation(summary = "Obtener los datos de los miembros del grupo de investigación por el id del grupo")
    @GetMapping("/groupId/{id}")
    public ResponseEntity<List<DtoUser>> getUsersData(@PathVariable Long id) {
        return new ResponseEntity<>(invMemberService.findInfoMembersByGroup(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo miembro de investigación")
    @PostMapping("/create")
    public ResponseEntity<Long> createInvMember(@RequestBody DtoInvMember dtoInvMember){
        Long savedInvMember=invMemberService.save(dtoInvMember);
        return new ResponseEntity<>(savedInvMember,HttpStatus.CREATED);
    }
    @Operation(summary="Obtiene miembros de investigacion por el id del grupo")
    @GetMapping("/group/{id}")
    public ResponseEntity<List<DtoInvMember>>getMembersByGroup(@PathVariable Long id){
        return new ResponseEntity<>(invMemberService.findGroup(id),HttpStatus.OK);
    }
    @Operation(summary = "Eliminar un usuario de un grupo por su ID")
    @DeleteMapping("/{userId}/group/{groupId}")
    public ResponseEntity<Void> deleteUserGroup(@PathVariable Long userId, @PathVariable Long groupId) {
        invMemberService.deleteUser(userId,groupId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Obtener información de un grupo de Investigación por su nombre de usuario")
    @GetMapping("/username/{username}")
    public ResponseEntity<DtoInvGroup> getInvMemberByUsername(@PathVariable String username) {
        return new ResponseEntity<>(invMemberService.findByUsername(username), HttpStatus.OK);
    }

}
