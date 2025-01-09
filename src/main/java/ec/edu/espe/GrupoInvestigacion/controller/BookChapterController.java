package ec.edu.espe.GrupoInvestigacion.controller;

import ec.edu.espe.GrupoInvestigacion.dto.DtoBookChapter;
import ec.edu.espe.GrupoInvestigacion.service.IServiceBookChapter;
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
@RequestMapping(V1_API_VERSION + PRIVATE_PATH + "/book-chapters")
@CrossOrigin(origins = "*")
@Tag(name = "BookChapterController", description = "Controlador para gestionar capítulos de libros")
public class BookChapterController {

    @Autowired
    private IServiceBookChapter bookChapterService;

    @Operation(summary = "Obtener todos los capítulos de libros")
    @GetMapping("/")
    public ResponseEntity<List<DtoBookChapter>> getAllBookChapters() {
        return new ResponseEntity<>(bookChapterService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un capítulo de libro por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DtoBookChapter> getBookChapterById(@PathVariable Long id) {
        return new ResponseEntity<>(bookChapterService.find(id), HttpStatus.OK);
    }

    @Operation(summary = "Crear un nuevo capítulo de libro")
    @PostMapping("/create")
    public ResponseEntity<Long> createBookChapter(@RequestBody DtoBookChapter dtoBookChapter) {
        Long savedBookChapter = bookChapterService.save(dtoBookChapter);
        return new ResponseEntity<>(savedBookChapter, HttpStatus.CREATED);
    }
    @Operation(summary = "Actualizar un capitulo de libro existente")
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateBookChapter(@PathVariable Long id, @RequestBody DtoBookChapter dtoBookChapter){
        DtoBookChapter existingPlan=bookChapterService.find(id);
        if(existingPlan==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dtoBookChapter.setIdLibroCapitulo(id);
        bookChapterService.update(dtoBookChapter);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
