package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoLink;
import ec.edu.espe.GrupoInvestigacion.model.ModelLink;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LinkMapper {
    @Mapping(source = "idVinculacion", target = "id")
    @Mapping(source = "idGrupoInv", target = "modelInvGroup.id")
    @Mapping(source = "idUser", target = "modelUser.idUser")
    @Mapping(source = "justificacion", target = "justification")
    @Mapping(source = "estado", target = "state")
    @Mapping(source = "estatus", target = "status")

    @Mapping(source = "tipo", target = "type")

    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelLink toEntity(DtoLink dto);

    @Mapping(source = "id", target = "idVinculacion")
    @Mapping(source = "modelInvGroup.id", target = "idGrupoInv")
    @Mapping(source = "modelUser.idUser", target = "idUser")
    @Mapping(source = "justification", target = "justificacion")
    @Mapping(source = "state", target = "estado")
    @Mapping(source = "status", target = "estatus")

    @Mapping(source = "type", target = "tipo")

    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoLink toDto(ModelLink model);
}
