package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoEvents;
import ec.edu.espe.GrupoInvestigacion.service.IServiceEvents;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/events")
@CrossOrigin(origins = "*")
@Tag(name = "EventsController", description = "Controlador para gestionar eventos")
public class EventsController {

    @Autowired
    private IServiceEvents eventService;

    @Operation(summary = "Obtener todos los eventos")
    @GetMapping("/")
    public ResponseEntity<List<DtoEvents>> getAllEvents() {
        return new ResponseEntity<>(eventService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un evento por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoEvents> getEventById(@PathVariable Long id) {
        return new ResponseEntity<>(eventService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo evento")
    @PostMapping("/create")
    public ResponseEntity<Long> createEvent(@RequestBody DtoEvents dtoEvent) {
        Long savedEvent = eventService.save(dtoEvent);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un evento existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateEvent(@PathVariable Long id,@RequestBody DtoEvents dtoEvents){
        DtoEvents existingEvent=eventService.find(id);
        if(existingEvent==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoEvents.setIdEvento(id);
        eventService.update(dtoEvents);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
