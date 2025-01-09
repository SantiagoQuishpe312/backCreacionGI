package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtoRol {
    private Long idRol;
    private String nombreRol;
    private Date fechaCreacionRol;
    private String usuarioCreacionRol;
    private Date fechaModificacionRol;
    private String usuarioModificacionRol;
}
