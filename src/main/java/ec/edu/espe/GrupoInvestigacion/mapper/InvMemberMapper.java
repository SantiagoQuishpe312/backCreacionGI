package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInvMember;
import ec.edu.espe.GrupoInvestigacion.dto.DtoUserRol;
import ec.edu.espe.GrupoInvestigacion.model.ModelInvMember;
import ec.edu.espe.GrupoInvestigacion.model.ModelUserRol;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface InvMemberMapper {

    @Mapping(source = "modelInvGroup.id", target = "idGrupoInv")
    @Mapping(source = "modelUser.idUser", target = "idUsuario")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoInvMember toDto(ModelInvMember model);

    @Mapping(source = "idGrupoInv", target = "modelInvGroup.id")
    @Mapping(source = "idUsuario", target = "modelUser.idUser")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelInvMember toEntity(DtoInvMember dtoInvMember);
}
