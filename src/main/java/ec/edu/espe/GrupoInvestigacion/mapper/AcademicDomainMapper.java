package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoAcademicDomain;
import ec.edu.espe.GrupoInvestigacion.model.ModelAcademicDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AcademicDomainMapper {
    @Mapping(target = "idDomimioAcademico", source = "id")
    @Mapping(target = "nombreDominioAcademico", source = "name")
    @Mapping(target = "estado", source = "state")
    @Mapping(target = "usuarioCreacionDominio", source = "userCreate")
    @Mapping(target = "fechaCreacionDominio", source = "dateCreate")
    @Mapping(target = "usuarioModificacionDominio", source = "userModificate")
    @Mapping(target = "fechaModificacionDominio", source = "dateModificate")
    DtoAcademicDomain toDTO(ModelAcademicDomain academicDomain);
    @Mapping(target = "id", source = "idDomimioAcademico")
    @Mapping(target = "name", source = "nombreDominioAcademico")
    @Mapping(target = "state", source = "estado")
    @Mapping(target = "userCreate", source = "usuarioCreacionDominio")
    @Mapping(target = "dateCreate", source = "fechaCreacionDominio")
    @Mapping(target = "userModificate", source = "usuarioModificacionDominio")
    @Mapping(target = "dateModificate", source = "fechaModificacionDominio")
    ModelAcademicDomain toEntity(DtoAcademicDomain dtoAcademicDomain);

}
