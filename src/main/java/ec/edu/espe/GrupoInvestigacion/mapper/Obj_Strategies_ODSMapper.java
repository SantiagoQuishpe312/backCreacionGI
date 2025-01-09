package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoObj_Strategies_ODS;
import ec.edu.espe.GrupoInvestigacion.model.ModelObj_Strategies_ODS;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface Obj_Strategies_ODSMapper {
    @Mapping(source = "modelStrategies.id", target = "idEstrategia")
    @Mapping(source = "modelSpecificObjectives.id", target = "idObjetivoEspecifico")
    @Mapping(source = "modelOds.id", target = "idODS")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoObj_Strategies_ODS toDto(ModelObj_Strategies_ODS model);

    @Mapping(source = "idEstrategia", target = "modelStrategies.id")
    @Mapping(source = "idObjetivoEspecifico", target = "modelSpecificObjectives.id")
    @Mapping(source = "idODS", target = "modelOds.id")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelObj_Strategies_ODS toEntity(DtoObj_Strategies_ODS dto);
}
