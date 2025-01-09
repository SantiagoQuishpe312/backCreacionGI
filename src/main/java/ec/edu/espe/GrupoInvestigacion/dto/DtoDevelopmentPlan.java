package ec.edu.espe.GrupoInvestigacion.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;
@Data
public class DtoDevelopmentPlan {
    private Long idPlanDesarrollo;
    private Long idGrupoInv;
    private Long idObjetivoInst;
    private Character tipo;
    private Character estado;
    private String contexto;
    private String alcance;
    private String objGeneral;
    private String usuarioCreacionUsuario;
    private Date fechaCreacionUsuario;
    private String usuarioModificacionUsuario;
    private Date fechaModificacionUsuario;
}
