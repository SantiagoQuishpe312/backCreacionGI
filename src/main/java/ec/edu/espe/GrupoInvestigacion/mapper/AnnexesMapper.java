package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoAnnexes;
import ec.edu.espe.GrupoInvestigacion.model.ModelAnnexes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnnexesMapper {

    @Mapping(source = "id", target = "idAnexo")
    @Mapping(source = "modelInvGroup.id", target = "idGrupo")
    @Mapping(source = "name", target = "nombreAnexo")
    @Mapping(source = "route", target = "rutaAnexo")
    @Mapping(source = "userCreate", target = "usuarioCreacionAnexo")
    @Mapping(source = "dateCreate", target = "fechaCreacionAnexo")
    @Mapping(source = "userModificate", target = "usuarioModificacionAnexo")
    @Mapping(source = "dateModificate", target = "fechaModificacionAnexo")
    DtoAnnexes toDto(ModelAnnexes model);

    @Mapping(source = "idAnexo", target = "id")
    @Mapping(source = "idGrupo", target = "modelInvGroup.id")
    @Mapping(source = "nombreAnexo", target = "name")
    @Mapping(source = "rutaAnexo", target = "route")
    @Mapping(source = "usuarioCreacionAnexo", target = "userCreate")
    @Mapping(source = "fechaCreacionAnexo", target = "dateCreate")
    @Mapping(source = "usuarioModificacionAnexo", target = "userModificate")
    @Mapping(source = "fechaModificacionAnexo", target = "dateModificate")
    ModelAnnexes toEntity(DtoAnnexes dto);



}
