package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.model.ModelRol;
import ec.edu.espe.GrupoInvestigacion.dto.DtoRol;
import ec.edu.espe.GrupoInvestigacion.service.IServiceRol;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ec.edu.espe.GrupoInvestigacion.constant.GlobalConstant.PRIVATE_PATH;
import static ec.edu.espe.GrupoInvestigacion.constant.GlobalConstant.V1_API_VERSION;

@RestController
@RequestMapping(V1_API_VERSION + PRIVATE_PATH  +"/rol")
@CrossOrigin(origins = "*")
@Tag(name = "RolController", description = "Controlador para gestionar roles")
public class RolController {

    @Autowired
    private IServiceRol rolService;

    @Operation(summary = "Obtener un rol por su ID")
    @GetMapping("/{id}")

    public ResponseEntity<DtoRol> getRolById(@PathVariable Long id) {

        return new ResponseEntity<>(rolService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Obtener todos los roles")
    @GetMapping("/")
    public ResponseEntity<List<DtoRol>> getAllRoles() {
        return new ResponseEntity<>(rolService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo rol")
    @PostMapping
    public ModelRol createRol(@RequestBody ModelRol rol) {
        return rol;
    }

    @Operation(summary = "Actualizar un rol existente")
    @PutMapping("/{roleId}")
    public ModelRol updateRol(@PathVariable Long roleId, @RequestBody ModelRol updatedRol) {
        return updatedRol;
    }

    @Operation(summary = "Eliminar un rol por su ID")
    @ApiResponse(responseCode = "204", description = "Rol eliminado correctamente")
    @DeleteMapping("/{roleId}")
    public void deleteRol(@PathVariable Long roleId) {
    }
}
