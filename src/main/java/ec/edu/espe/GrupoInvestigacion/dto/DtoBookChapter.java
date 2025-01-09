package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;
@Data
public class DtoBookChapter {
    private Long idLibroCapitulo;
    private Long idInformeActividades;
    private String titulo;
    private String autor;
    private String editorial;
    private String isbn;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
