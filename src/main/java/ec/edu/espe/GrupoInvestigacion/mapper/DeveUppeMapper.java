package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoDeveUppe;
import ec.edu.espe.GrupoInvestigacion.model.ModelDeveUppe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeveUppeMapper {
    @Mapping(source = "idPlan", target = "modelDevelopmentPlan.id")
    @Mapping(source = "idPlanNivelSuperior", target = "modelUpperLevelPlan.id")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelDeveUppe toEntity(DtoDeveUppe dto);

    @Mapping(source = "modelDevelopmentPlan.id", target = "idPlan")
    @Mapping(source = "modelUpperLevelPlan.id", target = "idPlanNivelSuperior")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoDeveUppe toDto(ModelDeveUppe model);
}
