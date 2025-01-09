package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup;
import ec.edu.espe.GrupoInvestigacion.model.ModelInvGroup;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "Spring")
public interface InvGroupMapper {
    @Mapping(source = "id", target = "idGrupoInv")
    @Mapping(source = "modelUser.idUser", target = "idCoordinador")
    @Mapping(source = "name", target = "nombreGrupoInv")
    @Mapping(source = "state", target = "estadoGrupoInv")
    @Mapping(source = "mission", target = "mision")
    @Mapping(source = "vision", target = "vision")
    @Mapping(source = "acronym", target = "acronimoGrupoinv")
    @Mapping(source = "department", target = "departamento")
    @Mapping(source = "process", target = "proceso")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoInvGroup toDto(ModelInvGroup model);
    @Mapping(source = "idGrupoInv", target = "id")
    @Mapping(source = "idCoordinador", target = "modelUser.idUser")
    @Mapping(source = "nombreGrupoInv", target = "name")
    @Mapping(source = "estadoGrupoInv", target = "state")
    @Mapping(source = "acronimoGrupoinv", target = "acronym")
    @Mapping(source = "mision", target = "mission")
    @Mapping(source = "vision", target = "vision")
    @Mapping(source = "departamento", target = "department")
    @Mapping(source = "proceso", target = "process")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelInvGroup toEntity(DtoInvGroup dtoInvGroup);

}
