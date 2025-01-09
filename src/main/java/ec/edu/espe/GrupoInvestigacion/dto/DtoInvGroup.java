package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;
@Data
public class DtoInvGroup {
    private Long idGrupoInv;
    private Long idCoordinador;
    private String nombreGrupoInv;
    private String estadoGrupoInv;
    private String acronimoGrupoinv;
    private String mision;
    private String vision;
    private String departamento;
    private String proceso;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;

}
