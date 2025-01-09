package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoDegreeTesis;
import ec.edu.espe.GrupoInvestigacion.model.ModelDegreeTesis;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DegreeTesisMapper {
    @Mapping(source = "id", target = "idTesis")
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "thesists", target = "tesistas")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    @Mapping(source = "modelActivityReport.id", target = "idInformeActividades")
    DtoDegreeTesis toDto(ModelDegreeTesis model);

    @Mapping(source = "idTesis", target = "id")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "tesistas", target = "thesists")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    @Mapping(source = "idInformeActividades", target = "modelActivityReport.id")
    ModelDegreeTesis toEntity(DtoDegreeTesis dto);
}
