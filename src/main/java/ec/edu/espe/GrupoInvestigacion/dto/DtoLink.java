package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;
@Data
public class DtoLink {
    private Long idVinculacion;
    private Long idGrupoInv;
    private Long idUser;
    private String justificacion;
    private Character estado;
    private Character estatus;
    private String tipo;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
