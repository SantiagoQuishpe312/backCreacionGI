package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoLegalFramework;
import ec.edu.espe.GrupoInvestigacion.model.ModelLegalFramework;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LegalFrameworkMapper {
    @Mapping(source = "idMarcoLegal", target = "id")
    @Mapping(source = "nombre", target = "name")
    @Mapping(source = "estado", target = "state")
    @Mapping(source = "usuarioCreacion", target = "createdByUser")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "modifiedByUser")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelLegalFramework toEntity(DtoLegalFramework dto);

    @Mapping(source = "id", target = "idMarcoLegal")
    @Mapping(source = "name", target = "nombre")
    @Mapping(source = "state", target = "estado")
    @Mapping(source = "createdByUser", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "modifiedByUser", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoLegalFramework toDto(ModelLegalFramework model);
}
