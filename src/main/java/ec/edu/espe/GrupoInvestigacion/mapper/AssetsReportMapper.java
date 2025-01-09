package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoAssetsReport;
import org.hibernate.sql.ast.tree.from.TableAliasResolver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ec.edu.espe.GrupoInvestigacion.model.ModelAssetsReport;

@Mapper(componentModel = "spring")

public interface AssetsReportMapper {
    @Mapping(target = "idReporteActivos", source = "id")
    @Mapping(target = "idGrupoInvestigacion", source = "modelInvGroup.id")
    @Mapping(target = "objetivoReporte", source = "obj")
    @Mapping(target = "contextoReporte", source = "context")
    @Mapping(target = "usoEstado", source = "useState")
    @Mapping(target = "condicionesGenerales", source = "generalCondition")
    @Mapping(target = "relevancia",source = "relevance")
    @Mapping(target = "conclusiones",source = "conclusion")
    @Mapping(target = "usuarioCreado",source = "userCreate")
    @Mapping(target = "fechaCreacionReporte",source = "dateCreate")
    @Mapping(target = "usuarioModificadoReporte",source = "userModificate")
    @Mapping(target = "fechaModificacionReporte",source = "dateModificate")

    DtoAssetsReport toDTO(ModelAssetsReport modelAssetsReport);
    @Mapping(target = "id",source = "idReporteActivos")
    @Mapping(target = "modelInvGroup.id",source = "idGrupoInvestigacion")
    @Mapping(target = "obj",source = "objetivoReporte")
    @Mapping(target = "context",source = "contextoReporte")
    @Mapping(target = "useState",source = "usoEstado")
    @Mapping(target = "generalCondition",source = "condicionesGenerales")
    @Mapping(target = "relevance",source = "relevancia")
    @Mapping(target = "conclusion",source = "conclusiones")
    @Mapping(target = "userCreate",source = "usuarioCreado")
    @Mapping(target = "dateCreate",source = "fechaCreacionReporte")
    @Mapping(target = "userModificate",source = "usuarioModificadoReporte")
    @Mapping(target = "dateModificate",source = "fechaModificacionReporte")

    ModelAssetsReport toEntity(DtoAssetsReport dtoAssetsReport);

}
