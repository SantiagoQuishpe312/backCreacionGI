package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoRol;
import ec.edu.espe.GrupoInvestigacion.model.ModelRol;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface RolMapper {
    @Mapping(source = "id", target = "idRol")
    @Mapping(source = "name", target = "nombreRol")
    @Mapping(source = "userCreate", target = "usuarioCreacionRol")
    @Mapping(source = "dateCreate", target = "fechaCreacionRol")
    @Mapping(source = "userModificate", target = "usuarioModificacionRol")
    @Mapping(source = "dateModificate", target = "fechaModificacionRol")
    DtoRol toDto(ModelRol model);
}
