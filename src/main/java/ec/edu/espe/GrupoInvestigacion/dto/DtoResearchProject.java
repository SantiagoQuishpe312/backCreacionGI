package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data

public class DtoResearchProject {
    private Long idProyecto;
    private Long idInformeActividades;
    private String titulo;
    private String entidadFinanciera;
    private String institucionColaboradora;
    private Integer horas;
    private Integer minutos;
    private BigDecimal presupuesto;
    private String responsable;
    private String participantes;
    private String tipo;
    private String estado;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
