package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;
@Data
public class DtoNationalPlan {

    private Long idPlanNacional;
    private String numeroPolitica;
    private String descripcion;

    private Boolean estado;
    private String usuarioCreacion;
    private Date fechaCreacion;
    private String usuarioModificacion;
    private Date fechaModificacion;
}
