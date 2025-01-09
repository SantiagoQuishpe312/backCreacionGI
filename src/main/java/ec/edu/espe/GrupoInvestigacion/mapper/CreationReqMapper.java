package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoCreationReq;

import ec.edu.espe.GrupoInvestigacion.model.ModelCreationReq;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreationReqMapper {
    @Mapping(source = "id", target = "idPeticionCreacion")
    @Mapping(source = "modelInvGroup.id",target = "idGrupoInv")
    @Mapping(source="strategicAlignment",target = "alineacionEstrategica")
    @Mapping(source = "state", target = "estado")
    @Mapping(source = "userCreate", target = "usuarioCreacionPeticion")
    @Mapping(source = "dateCreate", target = "fechaCreacionPeticion")
    @Mapping(source = "userModificate", target = "usuarioModificacionPeticion")
    @Mapping(source = "dateModificate", target = "fechaModificacionPeticion")
    DtoCreationReq toDto(ModelCreationReq model);
    @Mapping(source = "idPeticionCreacion", target = "id")
    @Mapping(source = "idGrupoInv",target = "modelInvGroup.id")
    @Mapping(source="alineacionEstrategica",target = "strategicAlignment")
    @Mapping(source = "estado", target = "state")
    @Mapping(source = "usuarioCreacionPeticion", target = "userCreate")
    @Mapping(source = "fechaCreacionPeticion", target = "dateCreate")
    @Mapping(source = "usuarioModificacionPeticion", target = "userModificate")
    @Mapping(source = "fechaModificacionPeticion", target = "dateModificate")
    ModelCreationReq toEntity(DtoCreationReq dtoCreationReq);
}
