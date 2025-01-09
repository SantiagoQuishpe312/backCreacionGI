package ec.edu.espe.GrupoInvestigacion.controller;


import ec.edu.espe.GrupoInvestigacion.dto.DtoAssets_Details;
import ec.edu.espe.GrupoInvestigacion.service.IServiceAssets_Details;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH +"/assetsDetails/")
@CrossOrigin(origins = "*")
@Tag(name = "AssetsDetailsController", description = "Controlador para gestiaronar detalles de activos")
public class AssetsDetailsController {
    @Autowired
    private IServiceAssets_Details assets_detailsService;

    @Operation(summary = "Obtener todos los detalles")
    @GetMapping("/")
    public ResponseEntity<List<DtoAssets_Details>> getAllAssetsDetails() {
        return new ResponseEntity<>(assets_detailsService.findAll(), HttpStatus.OK);
    }
    @Operation(summary = "Obtener detalles por ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoAssets_Details> getAssetsDetailsById(@PathVariable Long id) {
        return new ResponseEntity<>(assets_detailsService.find(id), HttpStatus.OK);
    }
    @Operation(summary = "Crea nuevos detalles de activo")
    @PostMapping("/create")
    public ResponseEntity<Long>createAssetsDetails(@RequestBody DtoAssets_Details dtoAssetsDetail) {
        Long savedAssetsDetails = assets_detailsService.save(dtoAssetsDetail);
        return new ResponseEntity<>(savedAssetsDetails, HttpStatus.CREATED);
    }
    @Operation(summary = "Actualizar detalles de un Activo")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateAssetsDetails(@PathVariable Long id, @RequestBody DtoAssets_Details dtoAssetsDetail) {
        DtoAssets_Details existingAssetsDetails = assets_detailsService.find(id);
        if (existingAssetsDetails == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoAssetsDetail.setIdDetalles(id);
        assets_detailsService.update(dtoAssetsDetail);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
