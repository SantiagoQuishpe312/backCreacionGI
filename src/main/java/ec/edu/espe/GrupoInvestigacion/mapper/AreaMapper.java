package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoArea;
import ec.edu.espe.GrupoInvestigacion.model.ModelArea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AreaMapper {

    @Mapping(source = "id", target = "idArea")
    @Mapping(source = "name", target = "nombreArea")
    @Mapping(source = "state", target = "estado")
    @Mapping(source = "userCreate", target = "usuarioCreacionArea")
    @Mapping(source = "dateCreate", target = "fechaCreacionArea")
    @Mapping(source = "userModificate", target = "usuarioModificacionArea")
    @Mapping(source = "dateModificate", target = "fechaModificacionArea")
    DtoArea toDto(ModelArea model);
    @Mapping(source = "idArea", target = "id")
    @Mapping(source = "nombreArea", target = "name")
    @Mapping(source = "estado", target = "state")
    @Mapping(source = "usuarioCreacionArea", target = "userCreate")
    @Mapping(source = "fechaCreacionArea", target = "dateCreate")
    @Mapping(source = "usuarioModificacionArea", target = "userModificate")
    @Mapping(source = "fechaModificacionArea", target = "dateModificate")
    ModelArea toEntity(DtoArea dtoArea);
}
