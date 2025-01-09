package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class DtoControlPanel {
    private Long idPanelControl;
    private Long idPlanDesarrollo;
    private Long idObjetivoEspecifico;
    private Long idResponsable;
    private String actividad;
    private String indicadorNombre;
    private String indicadorTipo;
    private String indicadorForma;
    private String indicadorCondicional;
    private String indicadorAcumulativo;
    private BigDecimal meta1;
    private BigDecimal meta2;
    private BigDecimal meta3;
    private BigDecimal meta4;
    private BigDecimal financiamiento;
    private String observacion;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;



}
