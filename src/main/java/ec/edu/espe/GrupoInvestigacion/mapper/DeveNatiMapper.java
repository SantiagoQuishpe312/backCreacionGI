package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoDeveLega;
import ec.edu.espe.GrupoInvestigacion.dto.DtoDeveNati;
import ec.edu.espe.GrupoInvestigacion.model.ModelDeveLega;
import ec.edu.espe.GrupoInvestigacion.model.ModelDeveNati;
import ec.edu.espe.GrupoInvestigacion.model.ModelDeveNatiId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeveNatiMapper {
    @Mapping(source = "idPlan", target = "modelDevelopmentPlan.id")
    @Mapping(source = "idPlanNacional", target = "modelNationalPlan.id")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelDeveNati toEntity(DtoDeveNati dto);

    @Mapping(source = "modelDevelopmentPlan.id", target = "idPlan")
    @Mapping(source = "modelNationalPlan.id", target = "idPlanNacional")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoDeveNati toDto(ModelDeveNati model);
}
