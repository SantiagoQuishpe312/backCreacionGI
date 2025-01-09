package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class DtoEvents {
    private Long idEvento;
    private Long idInformeActividades;
    private String nombre;
    private String ciudad;
    private String pais;
    private Date fecha;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
