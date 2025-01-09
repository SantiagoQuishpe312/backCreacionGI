package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;
@Data
public class DtoAnnexes {
    private Long idAnexo;
    private Long idGrupo;
    private String nombreAnexo;
    private String rutaAnexo;
    private String usuarioCreacionAnexo;
    private Date fechaCreacionAnexo;
    private String usuarioModificacionAnexo;
    private Date fechaModificacionAnexo;
}
