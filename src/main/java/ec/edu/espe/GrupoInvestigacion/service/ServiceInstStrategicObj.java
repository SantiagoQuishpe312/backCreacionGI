package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoInstStrategicObj;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInstStrategicObj;
import ec.edu.espe.GrupoInvestigacion.mapper.InstStrategicObjMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelInstStrategicObj;
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
public class ServiceInstStrategicObj implements IServiceInstStrategicObj {
    @Autowired
    private DaoInstStrategicObj daoInstStrategicObj;
    @Autowired
    private InstStrategicObjMapper instStrategicObjMapper;
    @Override
    public List<DtoInstStrategicObj> findAll(){
        return daoInstStrategicObj.findAllObj().orElse(new ArrayList<>()).stream().map(instStrategicObjMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public DtoInstStrategicObj find(Long id) {
        return instStrategicObjMapper.toDTO(daoInstStrategicObj.findByIdObj(id).orElse(new ModelInstStrategicObj()));
    }

    @Override
    public Long save(DtoInstStrategicObj dtoInstStrategicObj) {
        ModelInstStrategicObj modelInstStrategicObj = instStrategicObjMapper.toEntity(dtoInstStrategicObj);
        ModelInstStrategicObj createdEntity = daoInstStrategicObj.save(modelInstStrategicObj);
        return createdEntity.getId();
    }

    @Override
    public void update(DtoInstStrategicObj dtoInstStrategicObj) {
        ModelInstStrategicObj existingEntity = daoInstStrategicObj.findByIdObj(dtoInstStrategicObj.getIdObjetivoEstrategico()).orElse(null);
        if (existingEntity != null) {
            ModelInstStrategicObj updateEntity = instStrategicObjMapper.toEntity(dtoInstStrategicObj);
            BeanUtils.copyProperties(updateEntity, existingEntity,getNullPropertyNames(updateEntity));
            daoInstStrategicObj.save(existingEntity);
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
