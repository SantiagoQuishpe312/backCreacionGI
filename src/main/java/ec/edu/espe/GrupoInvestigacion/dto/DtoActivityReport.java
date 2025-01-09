package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;
import oracle.sql.CHAR;

import java.util.Date;
@Data
public class DtoActivityReport {
    private Long idInformeActividades;
    private Long idGrupo;
    private String antecedentes;
    private String conclusiones;
    private String recomendaciones;
    private Character estado;
    private String usuarioCreacionInforme;
    private Date fechaCreacionInforme;
    private String usuarioModificacionInforme;
    private Date fechaModificacionInforme;

}
