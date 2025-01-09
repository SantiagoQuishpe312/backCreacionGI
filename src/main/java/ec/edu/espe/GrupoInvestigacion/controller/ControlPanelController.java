package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoControlPanel;
import ec.edu.espe.GrupoInvestigacion.service.IServiceControlPanel;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH  +"/control-panel")
@CrossOrigin(origins = "*")
@Tag(name = "ControlPanelController", description = "Controlador para gestionar paneles de control")
public class ControlPanelController {

    @Autowired
    private IServiceControlPanel controlPanelService;

    @Operation(summary = "Obtener todos los paneles de control")
    @GetMapping("/")
    public ResponseEntity<List<DtoControlPanel>> getAllControlPanel() {
        return new ResponseEntity<>(controlPanelService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener todos los paneles de control por plan de desarrollo")
    @GetMapping("/bydev/{id}")
    public ResponseEntity<List<DtoControlPanel>> getAllControlPanelByDev(@PathVariable Long id) {
        return new ResponseEntity<>(controlPanelService.findByDev(id), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un panel de control por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoControlPanel> getControlPanellistById(@PathVariable Long id) {
        return new ResponseEntity<>(controlPanelService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo panel de control")
    @PostMapping("/create")
    public ResponseEntity <Long> createControlPanel(@RequestBody DtoControlPanel dtoControlPanel){
        Long savedControl=controlPanelService.save(dtoControlPanel);
        return new ResponseEntity<>(savedControl,HttpStatus.CREATED);
    }

    @Operation(summary = "Actualiza un panel de control")
    @PutMapping("/update/{id}")
    public ResponseEntity <Void> updateControlPanel(@PathVariable Long id,@RequestBody DtoControlPanel dtoControlPanel) {
    DtoControlPanel existingPlan=controlPanelService.find(id);
        if (existingPlan == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoControlPanel.setIdPanelControl(id);
        controlPanelService.update(dtoControlPanel);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}


