package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class DtoMagazines {
    private Long idRevista;
    private Long idInformeActividades;
    private String titulo;
    private String autores;
    private String revista;
    private String indice;
    private String doi;
    private String ifsjr;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
