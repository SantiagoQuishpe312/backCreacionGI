package ec.edu.espe.GrupoInvestigacion.mapper;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup_AcademicDomain;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup_Line;
import ec.edu.espe.GrupoInvestigacion.model.ModelInvGroup_Line;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InvGroup_LineMapper {
    @Mapping(source = "modelLine.id", target = "idLinea")
    @Mapping(source = "modelInvGroup.id", target = "idGrupo")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoInvGroup_Line toDto(ModelInvGroup_Line modelInvGroupLine);

    @Mapping(source = "idGrupo", target = "modelInvGroup.id")
    @Mapping(source = "idLinea", target = "modelLine.id")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelInvGroup_Line toEntity(DtoInvGroup_Line dtoInvGroupLine);
}
