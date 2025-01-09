package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoObj_Strategies_ODS;
import ec.edu.espe.GrupoInvestigacion.dao.DaoSpecificObjectives;
import ec.edu.espe.GrupoInvestigacion.dao.DaoOds;
import ec.edu.espe.GrupoInvestigacion.dao.DaoStrategies;
import ec.edu.espe.GrupoInvestigacion.dto.DtoObjGetStrategies;
import ec.edu.espe.GrupoInvestigacion.dto.DtoObj_Strategies_ODS;
import ec.edu.espe.GrupoInvestigacion.dto.DtoSpecificObjectives;
import ec.edu.espe.GrupoInvestigacion.mapper.Obj_Strategies_ODSMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.OdsMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.SpecificObjectivesMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.StrategiesMapper;
import ec.edu.espe.GrupoInvestigacion.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceObj_Strategies_ODS implements IServiceObj_Strategies_ODS {
    @Autowired
    private DaoStrategies daoStrategies;
    @Autowired
   private DaoSpecificObjectives daoSpecificObjectives;
    @Autowired
    private DaoOds daoOds;
@Autowired
private SpecificObjectivesMapper specificObjectivesMapper;
@Autowired
private OdsMapper odsMapper;
@Autowired
private StrategiesMapper strategiesMapper;
    @Autowired
    private Obj_Strategies_ODSMapper objStrategiesOdsMapper;
    @Autowired
    private DaoObj_Strategies_ODS daoObjStrategiesOds;

    public ServiceObj_Strategies_ODS(Obj_Strategies_ODSMapper objStrategiesOdsMapper, DaoObj_Strategies_ODS daoObjStrategiesOds) {
        this.objStrategiesOdsMapper = objStrategiesOdsMapper;
        this.daoObjStrategiesOds = daoObjStrategiesOds;
    }

    @Override
    public List<DtoObj_Strategies_ODS> findByObj(Long id) {

        return daoObjStrategiesOds.findByObjEnable(id)
                .orElse(new ArrayList<>())
                .stream()
                .map(objStrategiesOdsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DtoObjGetStrategies> findCompleteByPlan(Long id) {
        // Buscar los objetivos específicos asociados al plan
        Optional<List<ModelSpecificObjectives>> modelObj = daoObjStrategiesOds.findOdsObjByPlan(id);

        // Lista para almacenar los DTOs
        List<DtoObjGetStrategies> list = new ArrayList<>();

        // Validar si existen objetivos específicos asociados
        if (modelObj.isPresent() && !modelObj.get().isEmpty()) {
            for (ModelSpecificObjectives specificObjective : modelObj.get()) {
                // Crear un nuevo DTO para cada objetivo
                DtoObjGetStrategies dtoObjGetStrategies = new DtoObjGetStrategies();

                // Asignar datos al DTO
                dtoObjGetStrategies.setObj(
                        daoSpecificObjectives.findByIdEnable(specificObjective.getId())
                                .map(specificObjectivesMapper::toDto)
                                .orElse(new DtoSpecificObjectives())
                );

                // Obtener estrategias habilitadas y asignarlas al DTO
                dtoObjGetStrategies.setStrategies(
                        daoStrategies.findBySpecificObj(specificObjective.getId())
                                .orElse(new ArrayList<>())
                                .stream()
                                .map(strategiesMapper::toDto) // Asume un mapper para convertir a DTO
                                .collect(Collectors.toList())
                );

                // Obtener y asignar los ODS (deberías completar cómo obtenerlos)
                dtoObjGetStrategies.setOds(
                        daoOds.findBySpecificObj(specificObjective.getId())
                                .orElse(new ArrayList<>())
                                .stream()
                                .map(odsMapper::toDto) // Asume un mapper para convertir a DTO
                                .collect(Collectors.toList())
                );

                // Agregar el DTO a la lista final
                list.add(dtoObjGetStrategies);
            }
        }

        // Devolver la lista de DTOs
        return list;
    }



    @Override
    public Long save(DtoObj_Strategies_ODS dtoObjStrategiesOds) {

        Long objId=dtoObjStrategiesOds.getIdObjetivoEspecifico();
        Long strategiesId=dtoObjStrategiesOds.getIdEstrategia();
        Long odsId=dtoObjStrategiesOds.getIdODS();
        ModelSpecificObjectives modelSpecificObjectives= daoSpecificObjectives.findByIdEnable(objId).orElse(new ModelSpecificObjectives());
        ModelStrategies modelStrategies=daoStrategies.findByIdEnable(strategiesId).orElse(new ModelStrategies());
        ModelOds modelOds=daoOds.findByIdEnable(odsId).orElse(new ModelOds());
        ModelObj_Strategies_ODS modelObjStrategiesOds=objStrategiesOdsMapper.toEntity(dtoObjStrategiesOds);
        ModelObj_Strategies_ODS_Id id=new ModelObj_Strategies_ODS_Id();
        id.setModelSpecificObjectives(modelSpecificObjectives);
        id.setModelOds(modelOds);
        id.setModelStrategies(modelStrategies);
        modelObjStrategiesOds.setId(id);
        daoObjStrategiesOds.save(modelObjStrategiesOds);

        return modelObjStrategiesOds.getModelStrategies().getId();
    }
}
