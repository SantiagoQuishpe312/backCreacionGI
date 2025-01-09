package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoAnnualControl;
import ec.edu.espe.GrupoInvestigacion.model.ModelAnnualControl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnnualControlMapper {
    @Mapping(source = "idPlanAnual", target = "modelAnnualOperativePlan.id")
    @Mapping(source = "idPanelControl", target = "modelControlPanel.id")
    @Mapping(source = "objetivoAnual", target = "annualGoal")
    @Mapping(source = "producto", target = "product")
    @Mapping(source = "financiamiento", target = "financing")
    @Mapping(source = "monto", target = "amount")
    @Mapping(source = "presupuesto", target = "budget")
    @Mapping(source = "periodicidad", target = "periodicity")
    @Mapping(source = "fechaInicio", target = "startDate")
    @Mapping(source = "fechaFin", target = "endDate")
    @Mapping(source = "mediosVerificacion", target = "meansOfVerification")
    @Mapping(source = "montoCertificado", target = "certifiedAmount")
    @Mapping(source = "montoComprometido", target = "committedAmount")
    @Mapping(source = "valorDevengado", target = "accruedValue")
    @Mapping(source = "certificado", target = "certificate")
    @Mapping(source = "fechaSeguimiento", target = "followUpDate")
    @Mapping(source = "montoDisponible", target = "availableAmount")
    @Mapping(source = "cumplimiento", target = "compliance")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelAnnualControl toEntity(DtoAnnualControl dto);

    @Mapping(source = "modelAnnualOperativePlan.id", target = "idPlanAnual")
    @Mapping(source = "modelControlPanel.id", target = "idPanelControl")
    @Mapping(source = "annualGoal", target = "objetivoAnual")
    @Mapping(source = "product", target = "producto")
    @Mapping(source = "financing", target = "financiamiento")
    @Mapping(source = "amount", target = "monto")
    @Mapping(source = "budget", target = "presupuesto")
    @Mapping(source = "periodicity", target = "periodicidad")
    @Mapping(source = "startDate", target = "fechaInicio")
    @Mapping(source = "endDate", target = "fechaFin")
    @Mapping(source = "meansOfVerification", target = "mediosVerificacion")
    @Mapping(source = "certifiedAmount", target = "montoCertificado")
    @Mapping(source = "committedAmount", target = "montoComprometido")
    @Mapping(source = "accruedValue", target = "valorDevengado")
    @Mapping(source = "certificate", target = "certificado")
    @Mapping(source = "followUpDate", target = "fechaSeguimiento")
    @Mapping(source = "availableAmount", target = "montoDisponible")
    @Mapping(source = "compliance", target = "cumplimiento")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoAnnualControl toDto(ModelAnnualControl model);
}
