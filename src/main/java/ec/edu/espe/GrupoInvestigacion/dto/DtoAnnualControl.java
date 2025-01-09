package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class DtoAnnualControl {
    private Long idPanelControl;      // ID del panel de control
    private Long idPlanAnual;         // ID del plan anual
    private String objetivoAnual;     // Objetivo anual
    private String producto;           // Producto
    private String financiamiento;     // Financiamiento
    private BigDecimal monto;          // Monto
    private String presupuesto;        // Presupuesto
    private String periodicidad;       // Periodicidad
    private Date fechaInicio;          // Fecha de inicio
    private Date fechaFin;             // Fecha de fin
    private String mediosVerificacion; // Medios de verificación
    private BigDecimal montoCertificado; // Monto certificado
    private BigDecimal montoComprometido; // Monto comprometido
    private BigDecimal valorDevengado; // Valor devengado
    private String certificado;        // Certificado
    private Date fechaSeguimiento;     // Fecha de seguimiento
    private BigDecimal montoDisponible; // Monto disponible
    private BigDecimal cumplimiento;    // Cumplimiento
    private String usuarioCreacion;     // Usuario de creación
    private Date fechaCreacion;         // Fecha de creación
    private String usuarioModificacion; // Usuario de modificación
    private Date fechaModificacion;     // Fecha de modificación
}
