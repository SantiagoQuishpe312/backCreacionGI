package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoBudgetExecute;
import ec.edu.espe.GrupoInvestigacion.service.IServiceBudgetExecute;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/budget-executes")
@CrossOrigin(origins = "*")
@Tag(name = "BudgetExecuteController", description = "Controlador para gestionar la ejecución de presupuestos")
public class BudgetExecuteController {

    @Autowired
    private IServiceBudgetExecute budgetExecuteService;

    @Operation(summary = "Obtener todas las ejecuciones de presupuestos")
    @GetMapping("/")
    public ResponseEntity<List<DtoBudgetExecute>> getAllBudgetExecutes() {
        return new ResponseEntity<>(budgetExecuteService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener una ejecución de presupuesto por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoBudgetExecute> getBudgetExecuteById(@PathVariable Long id) {
        return new ResponseEntity<>(budgetExecuteService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear una nueva ejecución de presupuesto")
    @PostMapping("/create")
    public ResponseEntity<Long> createBudgetExecute(@RequestBody DtoBudgetExecute dtoBudgetExecute) {
        Long savedBudgetExecute = budgetExecuteService.save(dtoBudgetExecute);
        return new ResponseEntity<>(savedBudgetExecute, HttpStatus.CREATED);
    }
    @Operation(summary = "Actualizar uns ejecucion de presupuesto existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateBudgetExecute(@PathVariable Long id, @RequestBody DtoBudgetExecute dtoBudgetExecute){
        DtoBudgetExecute existingBudget=budgetExecuteService.find(id);
        if(existingBudget==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoBudgetExecute.setIdPresupuesto(id);
        budgetExecuteService.update(dtoBudgetExecute);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
