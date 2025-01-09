package ec.edu.espe.GrupoInvestigacion.service;


import ec.edu.espe.GrupoInvestigacion.dao.DaoDevelopmentPlan;
import ec.edu.espe.GrupoInvestigacion.dao.DaoObjStrategies;
import ec.edu.espe.GrupoInvestigacion.dto.DtoObjStrategies;
import ec.edu.espe.GrupoInvestigacion.mapper.ControlPanelMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.ObjStrategiesMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelDevelopmentPlan;
import ec.edu.espe.GrupoInvestigacion.model.ModelObjStrategies;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ServiceObjStrategies implements IServiceObjStrategies{
    @Autowired
    private DaoObjStrategies daoObjStrategies;

    @Autowired
    private ObjStrategiesMapper objStrategiesMapper;


    @Override
    public DtoObjStrategies find(Long id) {
        return objStrategiesMapper.toDto(daoObjStrategies.findByIdEnable(id).orElse(new ModelObjStrategies()));
    }

    @Override
    public List<DtoObjStrategies> findAll() {
        return daoObjStrategies.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(objStrategiesMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public Long save(DtoObjStrategies dtoObjStrategies){
        ModelObjStrategies modelObjStrategies=objStrategiesMapper.toEntity(dtoObjStrategies);

        ModelObjStrategies createdEntity=daoObjStrategies.save(modelObjStrategies);
        return createdEntity.getId();
    }

    @Override
    public void update(DtoObjStrategies dtoObjStrategies){
        ModelObjStrategies existingEntity=daoObjStrategies.findByIdEnable(dtoObjStrategies.getIdObjetivo()).orElse(null);
        if(existingEntity!=null){
            ModelObjStrategies updatedEntity=objStrategiesMapper.toEntity(dtoObjStrategies);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoObjStrategies.save(existingEntity);
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
