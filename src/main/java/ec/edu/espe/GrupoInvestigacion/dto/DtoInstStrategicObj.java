package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtoInstStrategicObj {
    private Long idObjetivoEstrategico;
    private String objetivo;
    private Boolean estado;

    private String usuarioCreadoObj;
    private Date fechaCreacionObj;
    private String usuarioModificadoObj;
    private Date fechaModificadoObj;
}
