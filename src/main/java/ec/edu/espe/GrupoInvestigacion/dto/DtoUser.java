package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtoUser {
    private Long id;
    private String usuario;
    private String nombre;
    private String idInstitucional;
    private String cedula;
    private String telefono;
    private String correo;
    private String departamento;
    private String institucion;
    private String cargo;
    private String nacionalidad;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private String usuarioCreacion;
    private String usuarioModificacion;
}
