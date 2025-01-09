package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoInstStrategicObj;
import ec.edu.espe.GrupoInvestigacion.dao.DaoStrategies;
import ec.edu.espe.GrupoInvestigacion.dto.DtoStrategies;
import ec.edu.espe.GrupoInvestigacion.mapper.SpecificObjectivesMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.StrategiesMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelStrategies;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServiceStrategies implements IServiceStrategies {

    @Autowired
    private DaoStrategies daoStrategies;
    @Autowired
    private DaoInstStrategicObj daoInstStrategicObj;

    @Autowired
    private StrategiesMapper strategiesMapper;

    @Autowired
    private SpecificObjectivesMapper specificObjectivesMapper;
    @Override
    public List<DtoStrategies> findAll() {
        return daoStrategies.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(strategiesMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<DtoStrategies> findByObj(Long id) {
        return daoStrategies.findByObjective(id)
                .orElse(new ArrayList<>())
                .stream()
                .map(strategiesMapper::toDto)
                .collect(Collectors.toList());
    }
   /* @Override
    public List<DtoObjGetStrategies> findComplete(Long idPlan) {
        // Obtienes la lista de objetivos con sus estrategias utilizando el DAO
        Optional<List<ModelObjectives>> modelObjectives = daoInstStrategicObj.findByIdObj(idPlan);

        // Si la lista no está vacía, mapeas cada objetivo a su respectivo DTO
        if (modelObjectives.isPresent() && !modelObjectives.get().isEmpty()) {
            return modelObjectives.get().stream().map(mo -> {
                DtoObjGetStrategies dtoObjGetStrategies = new DtoObjGetStrategies();

                // Mapeamos los campos del objetivo a DtoObjectives
                DtoObjectives dtoObjectives = new DtoObjectives();
                dtoObjectives.setIdObjetivo(mo.getId());
                dtoObjectives.setIdPlanDesarrollo(mo.getModelDevelopmentPlan().getId());
                dtoObjectives.setObjetivo(mo.getObjective());
                dtoObjectives.setUsuarioCreacion(mo.getUserCreate());
                dtoObjectives.setFechaCreacion(mo.getDateCreate());
                dtoObjectives.setUsuarioModificacion(mo.getUserModificate());
                dtoObjectives.setFechaModificacion(mo.getDateModificate());

                // Asignamos el objetivo al campo Obj del DTO principal
                dtoObjGetStrategies.setObj(dtoObjectives);

                // Mapeamos la lista de estrategias de ModelObjective a DtoStrategies
                List<DtoStrategies> strategies = mo.getStrategies().stream()
                        .map(strategiesMapper::toDto)  // Utilizamos el mapeador de estrategias
                        .collect(Collectors.toList());

                // Asignamos la lista de estrategias al campo Str del DTO principal
                dtoObjGetStrategies.setStr(strategies);

                // Retornamos el DTO ya mapeado
                return dtoObjGetStrategies;
            }).collect(Collectors.toList());  // Convertimos el stream en una lista de DtoObjGetStrategies
        }

        // Si no se encuentran objetivos, lanzamos una excepción o devolvemos una lista vacía
        throw new RuntimeException("No se encontraron objetivos con el ID proporcionado");
    }



    */

    @Override
    public DtoStrategies find(Long id) {
        return strategiesMapper.toDto(daoStrategies.findByIdEnable(id).orElse(new ModelStrategies()));
    }

    @Override
    public Long save(DtoStrategies dto) {
        ModelStrategies modelStrategies = strategiesMapper.toEntity(dto);
        ModelStrategies createdEntity = daoStrategies.save(modelStrategies);
        return createdEntity.getId();
    }

    @Override
    public void update(DtoStrategies dtoStrategies){
        ModelStrategies existingEntity=daoStrategies.findByIdEnable(dtoStrategies.getIdEstrategia()).orElse(null);
        if(existingEntity!=null){
            ModelStrategies updatedEntity=strategiesMapper.toEntity(dtoStrategies);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoStrategies.save(existingEntity);
        }
    }

    private String[] getNullPropertyNames(Object source) {
        try {
            final BeanInfo beanInfo = Introspector.getBeanInfo(source.getClass());
            final PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            final Set<String> emptyNames = new HashSet<>();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                final Object propertyValue = propertyDescriptor.getReadMethod().invoke(source);
                if (propertyValue == null) {
                    emptyNames.add(propertyDescriptor.getName());
                }
            }
            String[] result = new String[emptyNames.size()];
            return emptyNames.toArray(result);
        } catch (Exception e) {
            return new String[0];
        }
    }
}
