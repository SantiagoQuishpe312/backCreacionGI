package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoUserGetRol;
import ec.edu.espe.GrupoInvestigacion.dto.DtoUserRol;
import ec.edu.espe.GrupoInvestigacion.service.IServiceUserRol;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/user-roles")
@CrossOrigin(origins = "*")
@Tag(name = "UserRolController", description = "Controlador  para gestionar roles de usuarios")
public class UserRolController {
    @Autowired
    private IServiceUserRol userRolService;
    @Operation(summary = "Obtener todos los roles de usuario")
    @GetMapping("/")
    public ResponseEntity<List<DtoUserRol>> getAllUserRoles() {
        return new ResponseEntity<>(userRolService.findAll(), HttpStatus.OK);
    }
    @Operation(summary = "Obtener un rol de usuario por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<List<DtoUserRol>> getUserRoleById(@PathVariable Long id) {
        return new ResponseEntity<>(userRolService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crea una nueva relacion entre el el usuario y el rol asignado")
    @PostMapping("/create")
    public ResponseEntity<Long> createUserRol(@RequestBody DtoUserRol dtoUserRol){
        Long savedUserRol=userRolService.save(dtoUserRol);
        return new ResponseEntity<>(savedUserRol,HttpStatus.CREATED);
    }

    @Operation(summary = "Obtener los roles de un usuario por su username")
    @GetMapping("/byusername/{username}")
    public ResponseEntity<DtoUserGetRol> getUserRoleByUsername(@PathVariable String username) {
        return new ResponseEntity<>(userRolService.findByUsername(username), HttpStatus.OK);
    }
    @Operation(summary = "Eliminar un rol de usuario por su ID")
    @DeleteMapping("/{userId}/roles/{roleId}")
    public ResponseEntity<Void> deleteUserRole(@PathVariable Long userId, @PathVariable Long roleId) {
        userRolService.deleteRol(userId, roleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
