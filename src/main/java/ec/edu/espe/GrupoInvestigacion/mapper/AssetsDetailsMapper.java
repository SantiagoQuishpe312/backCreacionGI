package ec.edu.espe.GrupoInvestigacion.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ec.edu.espe.GrupoInvestigacion.dto.DtoAssets_Details;
import ec.edu.espe.GrupoInvestigacion.model.ModelAssets_Details;

@Mapper(componentModel = "spring")

public interface AssetsDetailsMapper {
    @Mapping(target = "idDetalles", source = "id")
    @Mapping(target = "idReporte", source = "modelAssetsReport.id")
    @Mapping(target = "descripcion", source = "description")
    @Mapping(target = "codigo", source = "code")
    @Mapping(target = "fechaAdquisicion", source = "adquisitionDate")
    @Mapping(target = "estadoActual", source = "currentStatus")
    @Mapping(target = "ubicacionActual", source = "currentLocation")
    @Mapping(target = "usuarioCreacion", source = "userCreate")
    @Mapping(target = "fechaCreacionDetalle", source = "dateCreate")
    @Mapping(target = "usuarioModificacionDetalle", source = "userModificate")
    @Mapping(target = "fechaModificacionDetalle", source = "dateModificate")

    DtoAssets_Details toDTO(ModelAssets_Details modelAssets_details);
    @Mapping(target = "id", source = "idDetalles")
    @Mapping(target = "modelAssetsReport.id",source = "idReporte")
    @Mapping(target = "description", source = "descripcion")
    @Mapping(target = "code",source = "codigo")
    @Mapping(target = "adquisitionDate", source = "fechaAdquisicion")
    @Mapping(target = "currentStatus",source = "estadoActual")
    @Mapping(target = "currentLocation",source = "ubicacionActual")
    @Mapping(target = "userCreate",source = "usuarioCreacion")
    @Mapping(target = "dateCreate",source = "fechaCreacionDetalle")
    @Mapping(target = "userModificate",source = "usuarioModificacionDetalle")
    @Mapping(target = "dateModificate",source = "fechaModificacionDetalle")

    ModelAssets_Details toEntity(DtoAssets_Details modelAssets_details);
}
