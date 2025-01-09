package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.model.ModelUser;
import ec.edu.espe.GrupoInvestigacion.dto.DtoUser;
import ec.edu.espe.GrupoInvestigacion.service.IServiceUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH  +"/user")
@CrossOrigin(origins = "*")
@Tag(name = "UserController resource", description = "Controlador para gestionar usuarios")
public class UserController {

    @Autowired
    private IServiceUser userService;
    @Operation(summary = "Obtener todos los usuarios")
    @GetMapping("/")
    public ResponseEntity<List<DtoUser>> getAllUserRol() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
    @Operation(summary = "Obtener usuario por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoUser> getUserRolById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.find(id), HttpStatus.OK);
    }
    @GetMapping("/userName/{user}")
    public ResponseEntity<DtoUser> getUserByUserName(@PathVariable String user){
        return new ResponseEntity<>(userService.findByUser(user),HttpStatus.OK);
    }
    @Operation(summary = "Crear un nuevo usuario")
    @PostMapping("/create")
    public ResponseEntity<Long> createUser(@RequestBody DtoUser dtoUser){
        Long savedUser= userService.save(dtoUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

}
