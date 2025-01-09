package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;
@Data
public class DtoAssets_Details {
    private Long idDetalles;
    private Long idReporte;
    private String codigo;
    private String descripcion;
    private Date fechaAdquisicion;
    private String estadoActual;
    private String ubicacionActual;
    private String usuarioCreacion;
    private Date fechaCreacionDetalle;
    private String usuarioModificacionDetalle;
    private Date fechaModificacionDetalle;
}
