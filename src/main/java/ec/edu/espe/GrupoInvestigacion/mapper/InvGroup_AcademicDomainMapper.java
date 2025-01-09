package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup_AcademicDomain;
import ec.edu.espe.GrupoInvestigacion.model.ModelInvGroup_AcademicDomains;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InvGroup_AcademicDomainMapper {
    @Mapping(source = "modelAcademicDomain.id", target = "idDomAcad")
    @Mapping(source = "modelInvGroup.id", target = "idGrupo")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoInvGroup_AcademicDomain toDto(ModelInvGroup_AcademicDomains model);
    @Mapping(source = "idGrupo", target = "modelInvGroup.id")
    @Mapping(source = "idDomAcad", target = "modelAcademicDomain.id")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelInvGroup_AcademicDomains toEntity(DtoInvGroup_AcademicDomain dto);
}
