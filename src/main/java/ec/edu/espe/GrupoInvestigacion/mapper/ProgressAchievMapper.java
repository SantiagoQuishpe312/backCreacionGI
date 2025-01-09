package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoProgressAchiev;
import ec.edu.espe.GrupoInvestigacion.model.ModelProgressAchiev;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface ProgressAchievMapper {
    @Mapping(source = "id", target = "idLogro")
    @Mapping(source="modelGroupRegForm.idRegFormId",target="idFormRegGrupo")
    @Mapping(source = "achievementDate", target = "fechaLogro")
    @Mapping(source = "achievements", target = "logro")
    @Mapping(source = "description", target = "descripcion")
    @Mapping(source = "userCreate", target = "usuarioCreacionLogro")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoProgressAchiev toDto(ModelProgressAchiev model);
    @Mapping(source = "idLogro", target = "id")
    @Mapping(source="idFormRegGrupo",target="modelGroupRegForm.idRegFormId")
    @Mapping(source = "fechaLogro", target = "achievementDate")
    @Mapping(source = "logro", target = "achievements")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "usuarioCreacionLogro", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelProgressAchiev toEntity(DtoProgressAchiev dtoProgressAchiev);
}
