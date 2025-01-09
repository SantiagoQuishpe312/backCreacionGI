package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoOds;
import ec.edu.espe.GrupoInvestigacion.model.ModelOds;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface OdsMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "description", target = "descripcion")
    @Mapping(source = "ods", target = "ods")
    @Mapping(source = "state", target = "estado")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoOds toDto(ModelOds modelOds);

    @InheritInverseConfiguration
    ModelOds toEntity(DtoOds dtoOds);
}
