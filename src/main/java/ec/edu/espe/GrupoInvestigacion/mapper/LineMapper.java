package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoLine;
import ec.edu.espe.GrupoInvestigacion.model.ModelLine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LineMapper {
    @Mapping(source = "id", target = "idLinea")
    @Mapping(source = "modelArea.id", target = "idArea")
    @Mapping(source = "name", target = "nombreLinea")
    @Mapping(source = "state", target = "estado")
    @Mapping(source = "userCreate", target = "usuarioCreacionLinea")
    @Mapping(source = "dateCreate", target = "fechaCreacionLinea")
    @Mapping(source = "userModificate", target = "usuarioModificacionLinea")
    @Mapping(source = "dateModificate", target = "fechaModificacionLinea")
    DtoLine toDto(ModelLine model);
    @Mapping(source = "idLinea", target = "id")
    @Mapping(source = "idArea", target = "modelArea.id")
    @Mapping(source = "nombreLinea", target = "name")
    @Mapping(source = "estado", target = "state")
    @Mapping(source = "usuarioCreacionLinea", target = "userCreate")
    @Mapping(source = "fechaCreacionLinea", target = "dateCreate")
    @Mapping(source = "usuarioModificacionLinea", target = "userModificate")
    @Mapping(source = "fechaModificacionLinea", target = "dateModificate")
    ModelLine toEntity(DtoLine dtoLine);
}
