package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class DtoCompliance {
    private Long idReporteActividades;
    private Long idObjEspecifico;
    private String verificable;
    private BigDecimal porcentaje;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;

}
