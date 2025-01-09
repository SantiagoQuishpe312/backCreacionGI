package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoObjStrategies;
import ec.edu.espe.GrupoInvestigacion.model.ModelObjStrategies;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ObjStrategiesMapper {


    @Mapping(source = "id", target = "idObjetivo")
    @Mapping(source = "modelActivityReport.id", target = "idInformeActividades")
    @Mapping(source = "obj", target = "objetivo")
    @Mapping(source = "strategy", target = "estrategia")
    @Mapping(source = "verifiable", target = "verificable")
    @Mapping(source = "compliance", target = "cumplimiento")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoObjStrategies toDto(ModelObjStrategies model);

    @Mapping(source = "idObjetivo", target = "id")
    @Mapping(source = "idInformeActividades", target = "modelActivityReport.id")
    @Mapping(source = "objetivo", target = "obj")
    @Mapping(source = "estrategia", target = "strategy")
    @Mapping(source = "verificable", target = "verifiable")
    @Mapping(source = "cumplimiento", target = "compliance")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelObjStrategies toEntity(DtoObjStrategies dto);
}
