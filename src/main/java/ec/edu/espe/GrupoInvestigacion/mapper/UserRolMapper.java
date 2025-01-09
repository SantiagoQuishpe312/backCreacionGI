package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoUserRol;

import ec.edu.espe.GrupoInvestigacion.model.ModelUserRol;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface UserRolMapper {

    @Mapping(source = "modelUser.idUser", target = "idUsuario")
    @Mapping(source = "modelRol.id", target = "idRoles")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoUserRol toDto(ModelUserRol model);

    @Mapping(source = "idRoles",target = "modelRol.id")
    @Mapping(source = "idUsuario",target = "modelUser.idUser")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelUserRol toEntity(DtoUserRol dtoUserRol);
}