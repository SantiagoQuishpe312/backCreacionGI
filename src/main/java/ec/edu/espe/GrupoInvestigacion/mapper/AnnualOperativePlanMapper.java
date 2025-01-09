package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoAnnualOperativePlan;
import ec.edu.espe.GrupoInvestigacion.model.ModelAnnualOperativePlan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface AnnualOperativePlanMapper {
    @Mapping(target = "idAnnualOperativePlan",source = "id")
    @Mapping(target = "idGrupoInvestigacion", source = "modelInvGroup.id")
    @Mapping(target = "objetivoGeneral", source = "generalObj")
    @Mapping(target = "usuarioCreado", source = "userCreate")
    @Mapping(target = "fechaCreacion", source = "dateCreate")
    @Mapping(target = "usuarioModificado", source = "userModificate")
    @Mapping(target = "fechaModificacion", source = "dateModificate")
    DtoAnnualOperativePlan toDto(ModelAnnualOperativePlan modelAnnualOperativePlan);
    @Mapping(target = "id",source = "idAnnualOperativePlan")
    @Mapping(target = "modelInvGroup.id", source = "idGrupoInvestigacion")
    @Mapping(target = "generalObj", source = "objetivoGeneral")
    @Mapping(target = "userCreate", source = "usuarioCreado")
    @Mapping(target = "dateCreate", source = "fechaCreacion")
    @Mapping(target = "userModificate", source = "usuarioModificado")
    @Mapping(target = "dateModificate", source = "fechaModificacion")
    ModelAnnualOperativePlan toEntity(DtoAnnualOperativePlan dtoAnnualOperativePlan);
}
