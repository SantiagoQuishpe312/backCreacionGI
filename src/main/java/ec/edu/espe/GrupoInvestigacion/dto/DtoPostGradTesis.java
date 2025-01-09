package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtoPostGradTesis {
    private Long idTesis;
    private Long idInformeActividades;
    private String nombre;
    private String tesistas;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
