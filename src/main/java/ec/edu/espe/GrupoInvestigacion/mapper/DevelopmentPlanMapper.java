package ec.edu.espe.GrupoInvestigacion.mapper;
import ec.edu.espe.GrupoInvestigacion.dto.DtoDevelopmentPlan;
import ec.edu.espe.GrupoInvestigacion.dto.DtoGroupRegForm;
import ec.edu.espe.GrupoInvestigacion.model.ModelDevelopmentPlan;
import ec.edu.espe.GrupoInvestigacion.model.ModelGroupRegForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface DevelopmentPlanMapper {
    @Mapping(source = "id", target = "idPlanDesarrollo")
    @Mapping(source = "modelInvGroup.id",target = "idGrupoInv")
    @Mapping(source = "modelInstStrategicObj.id",target = "idObjetivoInst")

    @Mapping(source = "context",target = "contexto")
    @Mapping(source = "scope",target = "alcance")
    @Mapping(source = "generalObj",target = "objGeneral")
    @Mapping(source = "type", target = "tipo")
    @Mapping(source = "state", target = "estado")
    @Mapping(source = "userCreate", target = "usuarioCreacionUsuario")
    @Mapping(source = "dateCreate", target = "fechaCreacionUsuario")
    @Mapping(source = "userModificate", target = "usuarioModificacionUsuario")
    @Mapping(source = "dateModificate", target = "fechaModificacionUsuario")
    DtoDevelopmentPlan toDto(ModelDevelopmentPlan model);

    @Mapping(source = "idPlanDesarrollo", target = "id")
    @Mapping(source = "idGrupoInv",target = "modelInvGroup.id")
    @Mapping(source = "idObjetivoInst",target = "modelInstStrategicObj.id")
    @Mapping(source = "contexto",target = "context")
    @Mapping(source = "alcance",target = "scope")
    @Mapping(source = "objGeneral",target = "generalObj")
    @Mapping(source = "tipo", target = "type")
    @Mapping(source = "estado", target = "state")
    @Mapping(source = "usuarioCreacionUsuario", target = "userCreate")
    @Mapping(source = "fechaCreacionUsuario", target = "dateCreate")
    @Mapping(source = "usuarioModificacionUsuario", target = "userModificate")
    @Mapping(source = "fechaModificacionUsuario", target = "dateModificate")
    ModelDevelopmentPlan toEntity(DtoDevelopmentPlan dto);

}
