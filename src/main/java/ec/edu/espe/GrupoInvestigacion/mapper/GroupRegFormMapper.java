package ec.edu.espe.GrupoInvestigacion.mapper;
import ec.edu.espe.GrupoInvestigacion.dto.DtoGroupRegForm;
import ec.edu.espe.GrupoInvestigacion.model.ModelGroupRegForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface GroupRegFormMapper {
    @Mapping(source = "idRegFormId", target = "idFormularioRegistroGrupo")
    @Mapping(source = "modelInvGroup.id",target = "idGrupoInv")
    @Mapping(source = "resNum", target = "resolucion")
    @Mapping(source = "checkCreationForm", target = "creacionFormCheck")
    @Mapping(source = "checkDevPlan", target = "planDesarrolloCheck")
    @Mapping(source = "checkSummary", target = "sumarioCheck")
    @Mapping(source = "checkCatCertificate", target = "certificadoCategoriaCheck")
    @Mapping(source = "checkVitae", target = "curriculum")
    @Mapping(source = "checkMiniumTeachers", target = "minimoProfesoresCheck")
    @Mapping(source = "checkScMerits", target = "meritosCientificosCheck")
    @Mapping(source = "state", target = "estado")
    @Mapping(source = "userCreate", target = "usuarioCreacionFormReg")
    @Mapping(source = "dateCreate", target = "fechaCreacionFormReg")
    @Mapping(source = "userModificate", target = "usuarioModificacionFormReg")
    @Mapping(source = "dateModificate", target = "fechaModificacionFormReg")
    DtoGroupRegForm toDto(ModelGroupRegForm model);

    @Mapping(source = "idFormularioRegistroGrupo", target = "idRegFormId")
    @Mapping(source = "idGrupoInv",target = "modelInvGroup.id")
    @Mapping(source = "resolucion", target = "resNum")
    @Mapping(source = "creacionFormCheck", target = "checkCreationForm")
    @Mapping(source = "planDesarrolloCheck", target = "checkDevPlan")
    @Mapping(source = "sumarioCheck", target = "checkSummary")
    @Mapping(source = "certificadoCategoriaCheck", target = "checkCatCertificate")
    @Mapping(source = "curriculum", target = "checkVitae")
    @Mapping(source = "minimoProfesoresCheck", target = "checkMiniumTeachers")
    @Mapping(source = "meritosCientificosCheck", target = "checkScMerits")
    @Mapping(source = "estado", target = "state")
    @Mapping(source = "usuarioCreacionFormReg", target = "userCreate")
    @Mapping(source = "fechaCreacionFormReg", target = "dateCreate")
    @Mapping(source = "usuarioModificacionFormReg", target = "userModificate")
    @Mapping(source = "fechaModificacionFormReg", target = "dateModificate")
    ModelGroupRegForm toEntity(DtoGroupRegForm dto);


}
