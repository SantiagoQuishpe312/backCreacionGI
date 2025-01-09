package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoSpecificObjectives;
import ec.edu.espe.GrupoInvestigacion.dto.DtoSpecificObjectives;
import ec.edu.espe.GrupoInvestigacion.mapper.SpecificObjectivesMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelSpecificObjectives;
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
public class ServiceSpecificObjectives implements IServiceSpecificObjectives {

    @Autowired
    private DaoSpecificObjectives daoSpecificObjectives;

    @Autowired
    private SpecificObjectivesMapper specificObjectivesMapper;

    @Override
    public DtoSpecificObjectives find(Long id) {
        return specificObjectivesMapper.toDto(daoSpecificObjectives.findByIdEnable(id).orElse(new ModelSpecificObjectives()));
    }

    @Override
    public List<DtoSpecificObjectives> findAll() {
        return daoSpecificObjectives.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(specificObjectivesMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DtoSpecificObjectives> findByDev(Long id) {
        return daoSpecificObjectives.findByPlan(id)
                .orElse(new ArrayList<>())
                .stream()
                .map(specificObjectivesMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public Long save(DtoSpecificObjectives dto) {
        ModelSpecificObjectives model = specificObjectivesMapper.toEntity(dto);
        ModelSpecificObjectives createdEntity = daoSpecificObjectives.save(model);
        return createdEntity.getId();
    }

    @Override
    public void update(DtoSpecificObjectives dtoSpecificObjectives){
        ModelSpecificObjectives existingEntity= daoSpecificObjectives.findByIdEnable(dtoSpecificObjectives.getIdObjetivo()).orElse(null);
        if(existingEntity!=null){
            ModelSpecificObjectives updatedEntity= specificObjectivesMapper.toEntity(dtoSpecificObjectives);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoSpecificObjectives.save(existingEntity);
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
