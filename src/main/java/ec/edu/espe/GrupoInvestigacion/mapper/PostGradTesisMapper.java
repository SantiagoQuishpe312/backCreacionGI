package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoPostGradTesis;
import ec.edu.espe.GrupoInvestigacion.model.ModelPostGradTesis;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostGradTesisMapper {

    @Mapping(source = "id", target = "idTesis")
    @Mapping(source = "modelActivityReport.id", target = "idInformeActividades")
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "thesists", target = "tesistas")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoPostGradTesis toDto(ModelPostGradTesis model);

    @Mapping(source = "idTesis", target = "id")
    @Mapping(source = "idInformeActividades", target = "modelActivityReport.id")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "tesistas", target = "thesists")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelPostGradTesis toEntity(DtoPostGradTesis dto);
}
