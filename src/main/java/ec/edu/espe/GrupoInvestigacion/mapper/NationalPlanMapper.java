package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoNationalPlan;
import ec.edu.espe.GrupoInvestigacion.model.ModelNationalPlan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NationalPlanMapper {

    @Mapping(source = "id", target = "idPlanNacional")
    @Mapping(source = "NPolitics", target = "numeroPolitica")
    @Mapping(source = "description", target = "descripcion")
    @Mapping(source = "state", target = "estado")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoNationalPlan toDto(ModelNationalPlan model);

    @Mapping(source = "idPlanNacional", target = "id")
    @Mapping(source = "numeroPolitica", target = "NPolitics")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "estado", target = "state")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelNationalPlan toEntity(DtoNationalPlan dto);
    @Mapping(source = "idPlanNacional", target = "id")
    @Mapping(source = "numeroPolitica", target = "NPolitics")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "estado", target = "state")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    void updateFromDto(DtoNationalPlan dto, @MappingTarget ModelNationalPlan entity);
}
