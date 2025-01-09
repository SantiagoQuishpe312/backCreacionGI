package ec.edu.espe.GrupoInvestigacion.dto;
import lombok.Data;

import java.util.Date;

@Data
public class DtoInvGroup_Line {
    private Long idGrupo;
    private Long idLinea;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
