package ec.edu.espe.GrupoInvestigacion.dto;
import lombok.Data;

import java.util.Date;

@Data
public class DtoRelevanceReport {
    private Long idInformePertinencia;
    private Long idGrupo;
    private String numeroMemo;
    private Long formularioCreacion;
    private Long planDesarrollo;
    private Long documentosAdicionales;
    private String objetivos;
    private Long planEstrategico;
    private Long pertinenciaAcademicaAporte;
    private Long coordinador;
    private Long miembros;
    private Long objetivosPlanDesarrollo;
    private String conclusiones;
    private String recomendaciones;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
