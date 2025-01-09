package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtoCreationReq {
    private Long idPeticionCreacion;
    private Long idGrupoInv;
    private String alineacionEstrategica;
    private Character estado;
    private String usuarioCreacionPeticion;
    private Date fechaCreacionPeticion;
    private String usuarioModificacionPeticion;
    private Date fechaModificacionPeticion;
}
