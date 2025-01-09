package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoResearchProject;
import ec.edu.espe.GrupoInvestigacion.model.ModelResearchProjec;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ResearchProjecMapper {
    @Mapping(source = "id", target = "idProyecto")
    @Mapping(source = "modelActivityReport.id", target = "idInformeActividades")
    @Mapping(source = "title", target = "titulo")
    @Mapping(source = "financeEntity", target = "entidadFinanciera")
    @Mapping(source = "collaboratingInstitution", target = "institucionColaboradora")
    @Mapping(source = "hours", target = "horas")
    @Mapping(source = "minutes", target = "minutos")
    @Mapping(source = "budget", target = "presupuesto")
    @Mapping(source = "responsible", target = "responsable")
    @Mapping(source = "participants", target = "participantes")
    @Mapping(source = "type", target = "tipo")
    @Mapping(source = "state", target = "estado")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoResearchProject toDto(ModelResearchProjec model);

    @Mapping(source = "idProyecto", target = "id")
    @Mapping(source = "idInformeActividades", target = "modelActivityReport.id")
    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "entidadFinanciera", target = "financeEntity")
    @Mapping(source = "institucionColaboradora", target = "collaboratingInstitution")
    @Mapping(source = "horas", target = "hours")
    @Mapping(source = "minutos", target = "minutes")
    @Mapping(source = "presupuesto", target = "budget")
    @Mapping(source = "responsable", target = "responsible")
    @Mapping(source = "participantes", target = "participants")
    @Mapping(source = "tipo", target = "type")
    @Mapping(source = "estado", target = "state")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelResearchProjec toEntity(DtoResearchProject dto);
}
