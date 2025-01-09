package ec.edu.espe.GrupoInvestigacion.dto;
import lombok.Data;

import java.util.Date;

@Data
public class DtoInvGroup_Area {
    private Long idArea;
    private Long idGrupo;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;

}
