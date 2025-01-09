package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoUpperLevelPlan;
import ec.edu.espe.GrupoInvestigacion.model.ModelUpperLevelPlan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UpperLevelPlanMapper {

    @Mapping(source = "id", target = "idPlanNivelSuperior")
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "state", target = "estado")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoUpperLevelPlan toDto(ModelUpperLevelPlan model);

    @Mapping(source = "idPlanNivelSuperior", target = "id")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "estado", target = "state")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelUpperLevelPlan toEntity(DtoUpperLevelPlan dto);
}
