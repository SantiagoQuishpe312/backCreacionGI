package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DtoAssetsReport {
    private Long idReporteActivos;
    private Long idGrupoInvestigacion;
    private String objetivoReporte;
    private String contextoReporte;
    private String usoEstado;
    private String condicionesGenerales;
    private String relevancia;
    private String conclusiones;
    private String usuarioCreado;
    private Date fechaCreacionReporte;
    private String usuarioModificadoReporte;
    private Date fechaModificacionReporte;
}
