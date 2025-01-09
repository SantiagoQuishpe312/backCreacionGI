package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoRelevanceReport;
import ec.edu.espe.GrupoInvestigacion.model.ModelRelevanceReport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RelevanceReportMapper {

    // Mapear de DTO a entidad
    @Mapping(source = "idInformePertinencia", target = "id")
    @Mapping(source = "idGrupo", target = "modelInvGroup.id")
    @Mapping(source = "numeroMemo", target = "memoN")
    @Mapping(source = "formularioCreacion", target = "creationReq")
    @Mapping(source = "planDesarrollo", target = "developmentPlan")
    @Mapping(source = "documentosAdicionales", target = "aditionalDocs")
    @Mapping(source = "objetivos", target = "objectives")
    @Mapping(source = "planEstrategico", target = "odsPlan")
    @Mapping(source = "pertinenciaAcademicaAporte", target = "academicRelevance")
    @Mapping(source = "coordinador", target = "coordinator")
    @Mapping(source = "miembros", target = "members")
    @Mapping(source = "objetivosPlanDesarrollo", target = "objectivesDevelopmentPlan")
    @Mapping(source = "conclusiones", target = "conclusions")
    @Mapping(source = "recomendaciones", target = "recomendations")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelRelevanceReport toEntity(DtoRelevanceReport dto);

    // Mapear de entidad a DTO
    @Mapping(source = "id", target = "idInformePertinencia")
    @Mapping(source = "modelInvGroup.id", target = "idGrupo")
    @Mapping(source = "memoN", target = "numeroMemo")
    @Mapping(source = "creationReq", target = "formularioCreacion")
    @Mapping(source = "developmentPlan", target = "planDesarrollo")
    @Mapping(source = "aditionalDocs", target = "documentosAdicionales")
    @Mapping(source = "objectives", target = "objetivos")
    @Mapping(source = "odsPlan", target = "planEstrategico")
    @Mapping(source = "academicRelevance", target = "pertinenciaAcademicaAporte")
    @Mapping(source = "coordinator", target = "coordinador")
    @Mapping(source = "members", target = "miembros")
    @Mapping(source = "objectivesDevelopmentPlan", target = "objetivosPlanDesarrollo")
    @Mapping(source = "conclusions", target = "conclusiones")
    @Mapping(source = "recomendations", target = "recomendaciones")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoRelevanceReport toDto(ModelRelevanceReport model);
}
