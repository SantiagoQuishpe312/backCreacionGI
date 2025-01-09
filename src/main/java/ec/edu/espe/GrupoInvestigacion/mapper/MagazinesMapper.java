package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoMagazines;
import ec.edu.espe.GrupoInvestigacion.model.ModelMagazines;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MagazinesMapper {
    @Mapping(source = "idRevista", target = "id")
    @Mapping(source = "idInformeActividades", target = "modelActivityReport.id")
    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "autores", target = "authors")
    @Mapping(source = "revista", target = "magazine")
    @Mapping(source = "indice", target = "index")
    @Mapping(source = "doi", target = "doi")
    @Mapping(source = "ifsjr", target = "quartilIfSjr")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelMagazines toEntity(DtoMagazines dto);

    @Mapping(source = "id", target = "idRevista")
    @Mapping(source = "modelActivityReport.id", target = "idInformeActividades")
    @Mapping(source = "title", target = "titulo")
    @Mapping(source = "authors", target = "autores")
    @Mapping(source = "magazine", target = "revista")
    @Mapping(source = "index", target = "indice")
    @Mapping(source = "doi", target = "doi")
    @Mapping(source = "quartilIfSjr", target = "ifsjr")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoMagazines toDto(ModelMagazines model);
}
