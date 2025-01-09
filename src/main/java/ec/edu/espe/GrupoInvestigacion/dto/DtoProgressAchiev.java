package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtoProgressAchiev {
    private Long idLogro;
    private Long idFormRegGrupo;
    private Date fechaLogro;
    private String logro;
    private String descripcion;
    private String usuarioCreacionLogro;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
