package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoSpecificObjectives;
import ec.edu.espe.GrupoInvestigacion.model.ModelSpecificObjectives;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SpecificObjectivesMapper {

    @Mapping(source = "id", target = "idObjetivo")
    @Mapping(source = "objective", target = "objetivo")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoSpecificObjectives toDto(ModelSpecificObjectives model);

    @Mapping(source = "idObjetivo", target = "id")
    @Mapping(source = "objetivo", target = "objective")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelSpecificObjectives toEntity(DtoSpecificObjectives dto);
}
