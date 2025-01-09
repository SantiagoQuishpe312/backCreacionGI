package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class DtoBudgetExecute {
    private Long IdPresupuesto;
    private Long idInformeActividades;
    private String actividad;
    private String item;
    private BigDecimal valorAsignado;
    private BigDecimal valorComprometido;
    private BigDecimal valorAcumulado;
    private String bienesAdquiridos;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
