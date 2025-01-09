package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoAcademicDomain;
import ec.edu.espe.GrupoInvestigacion.dto.DtoActivityReport;
import ec.edu.espe.GrupoInvestigacion.model.ModelAcademicDomain;
import ec.edu.espe.GrupoInvestigacion.model.ModelActivityReport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ActivityReportMapper {
    @Mapping(target = "idInformeActividades", source = "id")
    @Mapping(target="idGrupo",source = "modelInvGroup.id")
    @Mapping(target = "antecedentes", source = "background")
    @Mapping(target = "conclusiones", source = "conclusion")
    @Mapping(target = "recomendaciones", source = "recommendations")
    @Mapping(target = "estado", source = "state")
    @Mapping(target = "usuarioCreacionInforme", source = "userCreate")
    @Mapping(target = "fechaCreacionInforme", source = "dateCreate")
    @Mapping(target = "usuarioModificacionInforme", source = "userModificate")
    @Mapping(target = "fechaModificacionInforme", source = "dateModificate")
    DtoActivityReport toDTO(ModelActivityReport modelActivityReport);
    @Mapping(target = "id", source = "idInformeActividades")
    @Mapping(target = "modelInvGroup.id",source = "idGrupo")
    @Mapping(target = "background", source = "antecedentes")
    @Mapping(target = "conclusion", source = "conclusiones")
    @Mapping(target = "recommendations", source = "recomendaciones")
    @Mapping(target = "state", source = "estado")
    @Mapping(target = "userCreate", source = "usuarioCreacionInforme")
    @Mapping(target = "dateCreate", source = "fechaCreacionInforme")
    @Mapping(target = "userModificate", source = "usuarioModificacionInforme")
    @Mapping(target = "dateModificate", source = "fechaModificacionInforme")
    ModelActivityReport toEntity(DtoActivityReport dtoActivityReport);

}
