package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtoInvGroup_AcademicDomain {
    private Long idGrupo;
    private Long idDomAcad;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
