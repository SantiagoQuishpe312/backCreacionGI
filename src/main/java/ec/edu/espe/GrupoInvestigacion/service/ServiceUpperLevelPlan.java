package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoUpperLevelPlan;
import ec.edu.espe.GrupoInvestigacion.dto.DtoUpperLevelPlan;
import ec.edu.espe.GrupoInvestigacion.mapper.UpperLevelPlanMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelUpperLevelPlan;
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
public class ServiceUpperLevelPlan implements IServiceUpperLevelPlan {

    @Autowired
    private DaoUpperLevelPlan daoUpperLevelPlan;

    @Autowired
    private UpperLevelPlanMapper upperLevelPlanMapper;

    @Override
    public List<DtoUpperLevelPlan> findAll() {
        return daoUpperLevelPlan.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(upperLevelPlanMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DtoUpperLevelPlan find(Long id) {
        return upperLevelPlanMapper.toDto(daoUpperLevelPlan.findById(id).orElse(null));
    }

    @Override
    public Long save(DtoUpperLevelPlan dtoUpperLevelPlan) {
        ModelUpperLevelPlan modelUpperLevelPlan = upperLevelPlanMapper.toEntity(dtoUpperLevelPlan);
        ModelUpperLevelPlan createdEntity = daoUpperLevelPlan.save(modelUpperLevelPlan);
        return createdEntity.getId();
    }

    @Override
    public void update(DtoUpperLevelPlan dtoUpperLevelPlan) {
        ModelUpperLevelPlan existingEntity = daoUpperLevelPlan.findById(dtoUpperLevelPlan.getIdPlanNivelSuperior()).orElse(null);
        if (existingEntity != null) {
            ModelUpperLevelPlan updatedEntity = upperLevelPlanMapper.toEntity(dtoUpperLevelPlan);
            BeanUtils.copyProperties(updatedEntity, existingEntity, getNullPropertyNames(updatedEntity));
            daoUpperLevelPlan.save(existingEntity);
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
