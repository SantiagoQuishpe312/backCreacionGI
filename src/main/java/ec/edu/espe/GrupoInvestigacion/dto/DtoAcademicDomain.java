package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DtoAcademicDomain {
    private Long idDomimioAcademico;
    private String nombreDominioAcademico;
    private Boolean estado;
    private String usuarioCreacionDominio;
    private Date fechaCreacionDominio;
    private String usuarioModificacionDominio;
    private Date fechaModificacionDominio;

}
