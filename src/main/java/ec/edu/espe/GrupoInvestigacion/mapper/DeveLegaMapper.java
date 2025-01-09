package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoDeveLega;
import ec.edu.espe.GrupoInvestigacion.model.ModelDeveLega;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeveLegaMapper {
    @Mapping(source = "idPlan", target = "modelDevelopmentPlan.id")
    @Mapping(source = "idMarco", target = "modelLegalFramework.id")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelDeveLega toEntity(DtoDeveLega dto);

    @Mapping(source = "modelDevelopmentPlan.id", target = "idPlan")
    @Mapping(source = "modelLegalFramework.id", target = "idMarco")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoDeveLega toDto(ModelDeveLega model);
}
