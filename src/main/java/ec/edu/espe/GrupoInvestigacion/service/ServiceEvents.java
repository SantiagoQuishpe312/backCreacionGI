package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoEvents;
import ec.edu.espe.GrupoInvestigacion.dto.DtoEvents;
import ec.edu.espe.GrupoInvestigacion.mapper.EventsMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelEvents;
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

public class ServiceEvents implements IServiceEvents {
    @Autowired
    private DaoEvents daoEvents;
    @Autowired
    private EventsMapper eventsMapper;

    @Override
    public DtoEvents find(Long id) {
        return eventsMapper.toDto(daoEvents.findByIdEnable(id).orElse(new ModelEvents()));
    }

    @Override
    public List<DtoEvents> findAll() {
        return daoEvents.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(eventsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long save(DtoEvents dtoEvents){
        ModelEvents modelEvents=eventsMapper.toEntity(dtoEvents);
        ModelEvents createdEntity=daoEvents.save(modelEvents);
        return createdEntity.getId();
    }
    @Override
    public void update(DtoEvents dtoEvents){
        ModelEvents existingEntity=daoEvents.findByIdEnable(dtoEvents.getIdEvento()).orElse(null);
        if(existingEntity!=null){
            ModelEvents updatedEntity=eventsMapper.toEntity(dtoEvents);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoEvents.save(existingEntity);
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
