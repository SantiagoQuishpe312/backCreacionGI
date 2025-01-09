package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoBookChapter;
import ec.edu.espe.GrupoInvestigacion.dto.DtoBudgetExecute;
import ec.edu.espe.GrupoInvestigacion.model.ModelBookChapter;
import ec.edu.espe.GrupoInvestigacion.model.ModelBudgetExecute;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BudgetExecuteMapper {
    @Mapping(source = "id", target = "idPresupuesto")
    @Mapping(source = "modelActivityReport.id", target = "idInformeActividades")
    @Mapping(source = "activity", target = "actividad")
    @Mapping(source = "budgetItem", target = "item")
    @Mapping(source = "assignedValue", target = "valorAsignado")
    @Mapping(source = "committedValue", target = "valorComprometido")
    @Mapping(source = "accruedValue", target = "valorAcumulado")
    @Mapping(source = "acquiredStatus", target = "bienesAdquiridos")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoBudgetExecute toDto(ModelBudgetExecute model);

    @Mapping(source = "idPresupuesto", target = "id")
    @Mapping(source = "idInformeActividades", target = "modelActivityReport.id")
    @Mapping(source = "actividad", target = "activity")
    @Mapping(source = "item", target = "budgetItem")
    @Mapping(source = "valorAsignado", target = "assignedValue")
    @Mapping(source = "valorComprometido", target = "committedValue")
    @Mapping(source = "valorAcumulado", target = "accruedValue")
    @Mapping(source = "bienesAdquiridos", target = "acquiredStatus")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelBudgetExecute toEntity(DtoBudgetExecute dto);
}
