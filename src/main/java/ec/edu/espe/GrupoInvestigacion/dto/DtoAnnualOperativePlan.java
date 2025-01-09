package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtoAnnualOperativePlan {
    private Long idAnnualOperativePlan;
    private Long idGrupoInvestigacion;
    private String objetivoGeneral;
    private String usuarioCreado;
    private Date fechaCreacion;
    private String usuarioModificado;
    private Date fechaModificacion;
}
