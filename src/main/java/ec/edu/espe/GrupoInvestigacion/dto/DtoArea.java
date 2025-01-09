package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;
@Data
public class DtoArea {
    private Long idArea;
    private String nombreArea;
    private Boolean estado;
    private String usuarioCreacionArea;
    private Date fechaCreacionArea;
    private String usuarioModificacionArea;
    private Date fechaModificacionArea;
}
