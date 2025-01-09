package ec.edu.espe.GrupoInvestigacion.mapper;


import ec.edu.espe.GrupoInvestigacion.dto.DtoInstStrategicObj;
import ec.edu.espe.GrupoInvestigacion.model.ModelInstStrategicObj;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InstStrategicObjMapper {
    @Mapping(target = "id", source = "idObjetivoEstrategico")
    @Mapping(target = "obj", source = "objetivo")
    @Mapping(target = "state", source = "estado")
    @Mapping(target = "userCreate", source = "usuarioCreadoObj")
    @Mapping(target = "dateCreate", source = "fechaCreacionObj")
    @Mapping(target = "userModificate",source = "usuarioModificadoObj")
    @Mapping(target = "dateModificate", source = "fechaModificadoObj")
    ModelInstStrategicObj toEntity(DtoInstStrategicObj dtoInstStrategicObj);

    @Mapping(target = "idObjetivoEstrategico", source = "id")
    @Mapping(target = "objetivo", source = "obj")
    @Mapping(target = "estado", source = "state")
    @Mapping(target = "usuarioCreadoObj", source = "userCreate")
    @Mapping(target = "fechaCreacionObj", source = "dateCreate")
    @Mapping(target = "usuarioModificadoObj", source = "userModificate")
    @Mapping(target = "fechaModificadoObj", source = "dateModificate")
    DtoInstStrategicObj toDTO(ModelInstStrategicObj modelInstStrategicObj);




}
