package ec.edu.espe.GrupoInvestigacion.mapper;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup_Area;
import ec.edu.espe.GrupoInvestigacion.model.ModelInvGroup_Area;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface InvGroup_AreaMapper {
    @Mapping(source = "modelArea.id", target = "idArea")
    @Mapping(source = "modelInvGroup.id", target = "idGrupo")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoInvGroup_Area toDto(ModelInvGroup_Area model);
    @Mapping(source = "idArea", target = "modelArea.id")
    @Mapping(source = "idGrupo", target = "modelInvGroup.id")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelInvGroup_Area toEntity(DtoInvGroup_Area dtoInvGroupArea);

}
