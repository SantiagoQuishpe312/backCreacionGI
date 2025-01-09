package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtoObj_Strategies_ODS {
    private Long idEstrategia;
    private Long idObjetivoEspecifico;
    private Long idODS;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;

}
