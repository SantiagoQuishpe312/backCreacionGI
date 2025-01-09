package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtoLine {
    private Long idLinea;
    private Long idArea;
    private String nombreLinea;
    private Boolean estado;
    private String usuarioCreacionLinea;
    private Date fechaCreacionLinea;
    private String usuarioModificacionLinea;
    private Date fechaModificacionLinea;
}
