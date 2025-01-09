package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class DtoObjStrategies {
    private Long idObjetivo;
    private Long idInformeActividades;
    private String objetivo ;
    private String estrategia;
    private String verificable;
    private BigDecimal cumplimiento;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
