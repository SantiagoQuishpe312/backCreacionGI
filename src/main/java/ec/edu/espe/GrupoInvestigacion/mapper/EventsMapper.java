package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoEvents;
import ec.edu.espe.GrupoInvestigacion.model.ModelEvents;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventsMapper {

    @Mapping(source = "idEvento", target = "id")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "ciudad", target = "city")
    @Mapping(source = "pais", target = "country")
    @Mapping(source = "fecha", target = "date")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    @Mapping(source = "idInformeActividades", target = "modelActivityReport.id")
    ModelEvents toEntity(DtoEvents dto);

    @Mapping(source = "id", target = "idEvento")
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "city", target = "ciudad")
    @Mapping(source = "country", target = "pais")
    @Mapping(source = "date", target = "fecha")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    @Mapping(source = "modelActivityReport.id", target = "idInformeActividades")
    DtoEvents toDto(ModelEvents model);
}
