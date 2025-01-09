package ec.edu.espe.GrupoInvestigacion.service;


import ec.edu.espe.GrupoInvestigacion.dao.DaoDevelopmentPlan;
import ec.edu.espe.GrupoInvestigacion.dto.DtoDevelopmentPlan;
import ec.edu.espe.GrupoInvestigacion.dto.DtoGroupRegForm;
import ec.edu.espe.GrupoInvestigacion.mapper.DevelopmentPlanMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelDevelopmentPlan;
import ec.edu.espe.GrupoInvestigacion.model.ModelGroupRegForm;
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
public class ServiceDevelopmentPlan implements IServiceDevelopmentPlan{
    @Autowired
    private DaoDevelopmentPlan daoDevelopmentPlan;

    @Autowired
    private DevelopmentPlanMapper developmentPlanMapper;

    @Override
    public DtoDevelopmentPlan find(Long id) {
        return developmentPlanMapper.toDto(daoDevelopmentPlan.findByIdEnable(id).orElse(new ModelDevelopmentPlan()));
    }
    public List<DtoDevelopmentPlan> findGroupC(Long id) {
        return daoDevelopmentPlan.findByGroup(id)
                .orElse(new ArrayList<>())
                .stream()
                .map(developmentPlanMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<DtoDevelopmentPlan> findGroupType(Long id,Character tipo) {
        return daoDevelopmentPlan.findByGroupAndType(id,tipo)
                .orElse(new ArrayList<>())
                .stream()
                .map(developmentPlanMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<DtoDevelopmentPlan> findAll() {
        return daoDevelopmentPlan.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(developmentPlanMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long create(DtoDevelopmentPlan dtoDevelopmentPlan) {
        ModelDevelopmentPlan modelDevelopmentPlan = developmentPlanMapper.toEntity(dtoDevelopmentPlan);
        ModelDevelopmentPlan createdEntity = daoDevelopmentPlan.save(modelDevelopmentPlan);
        return createdEntity.getId();
    }

    @Override
    public  void update(DtoDevelopmentPlan dtoDevelopmentPlan){
        ModelDevelopmentPlan existingEntity=daoDevelopmentPlan.findByIdEnable(dtoDevelopmentPlan.getIdPlanDesarrollo()).orElse(null);
        if(existingEntity!=null){
            ModelDevelopmentPlan updatedEntity=developmentPlanMapper.toEntity(dtoDevelopmentPlan);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoDevelopmentPlan.save(existingEntity);
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
