package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoCongress;
import ec.edu.espe.GrupoInvestigacion.dto.DtoControlPanel;
import ec.edu.espe.GrupoInvestigacion.model.ModelCongress;
import ec.edu.espe.GrupoInvestigacion.model.ModelControlPanel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface CongressMapper {

    @Mapping(source = "id", target = "idCongreso")
    @Mapping(source = "modelActivityReport.id",target = "idInformeActividad")
    @Mapping(source = "title", target = "titulo")
    @Mapping(source = "author", target = "autores")
    @Mapping(source = "congress", target = "congreso")
    @Mapping(source = "index", target = "doi")
    @Mapping(source = "ifSjr", target = "ifSjr")
    @Mapping(source = "quartil", target = "cuartil")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoCongress toDto(ModelCongress model);
    @Mapping(source = "idCongreso", target = "id")
    @Mapping(source = "idInformeActividad",target = "modelActivityReport.id")
    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "autores", target = "author")
    @Mapping(source = "congreso", target = "congress")
    @Mapping(source = "doi", target = "index")
    @Mapping(source = "ifSjr", target = "ifSjr")
    @Mapping(source = "cuartil", target = "quartil")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelCongress toEntity(DtoCongress dtoCongress);
}
