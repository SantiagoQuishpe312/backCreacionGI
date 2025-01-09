package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtoCongress {
    private Long idCongreso;
    private Long idInformeActividad;
    private Long numero;
    private String titulo;
    private String autores;
    private String congreso;
    private String doi;
    private String ifSjr;
    private String cuartil;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
