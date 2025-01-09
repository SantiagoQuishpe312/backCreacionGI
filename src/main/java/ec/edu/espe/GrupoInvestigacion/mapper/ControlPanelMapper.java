package ec.edu.espe.GrupoInvestigacion.mapper;

import ec.edu.espe.GrupoInvestigacion.dto.DtoControlPanel;
import ec.edu.espe.GrupoInvestigacion.model.ModelControlPanel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Date;

@Mapper(componentModel = "spring")
public interface ControlPanelMapper {

    @Mapping(source = "id", target = "idPanelControl")
    @Mapping(source = "modelDevelopmentPlan.id", target = "idPlanDesarrollo")
    @Mapping(source = "modelSpecificObjectives.id", target = "idObjetivoEspecifico")
    @Mapping(source = "modelUser.idUser", target = "idResponsable")
    @Mapping(source = "activity", target = "actividad")
    @Mapping(source = "indicatorName", target = "indicadorNombre")
    @Mapping(source = "indicatorType", target = "indicadorTipo")
    @Mapping(source = "indicatorForm", target = "indicadorForma")
    @Mapping(source = "indicatorCondicional", target = "indicadorCondicional")
    @Mapping(source = "indicatorAccumulative", target = "indicadorAcumulativo")
    @Mapping(source = "goals1", target = "meta1")
    @Mapping(source = "goals2", target = "meta2")
    @Mapping(source = "goals3", target = "meta3")
    @Mapping(source = "goals4", target = "meta4")
    @Mapping(source = "financing", target = "financiamiento")
    @Mapping(source = "observation", target = "observacion")
    @Mapping(source = "userCreate", target = "usuarioCreacion")
    @Mapping(source = "dateCreate", target = "fechaCreacion")
    @Mapping(source = "userModificate", target = "usuarioModificacion")
    @Mapping(source = "dateModificate", target = "fechaModificacion")
    DtoControlPanel toDto(ModelControlPanel modelControlPanel);

    @InheritInverseConfiguration
    ModelControlPanel toEntity(DtoControlPanel dtoControlPanel);
}
