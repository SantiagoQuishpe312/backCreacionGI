package ec.edu.espe.GrupoInvestigacion.dto;
import lombok.Data;

import java.util.Date;


@Data
public class DtoInvMember {
    private Long idGrupoInv;
    private Long idUsuario;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;

}
