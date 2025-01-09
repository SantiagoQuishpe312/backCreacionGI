package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoCompliance;
import ec.edu.espe.GrupoInvestigacion.model.ModelCompliance;
import jakarta.persistence.Column;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")

public interface ComplianceMapper {
    @Mapping(source = "idReporteActividades", target = "modelActivityReport.id")
    @Mapping(source = "idObjEspecifico", target = "modelSpecificObjectives.id")
    @Mapping(source = "verificable", target = "verifiable")
    @Mapping(source = "porcentaje", target = "percentage")
    @Mapping(source = "usuarioCreacion", target = "userCreate")
    @Mapping(source = "fechaCreacion", target = "dateCreate")
    @Mapping(source = "usuarioModificacion", target = "userModificate")
    @Mapping(source = "fechaModificacion", target = "dateModificate")
    ModelCompliance toEntity(DtoCompliance dtoCompliance);

    @Mapping(source = "modelActivityReport.id", target = "idReporteActividades")
    @Mapping(source = "modelSpecificObjectives.id", target = "idObjEspecifico")
    @Mapping(source = "verifiable", target = "verificable")
    @Mapping(source = "percentage", target = "porcentaje")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoCompliance toDto(ModelCompliance modelCompliance);

}
