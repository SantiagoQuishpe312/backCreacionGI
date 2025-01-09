package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoProgressAchiev;
import ec.edu.espe.GrupoInvestigacion.dto.DtoProgressAchiev;
import ec.edu.espe.GrupoInvestigacion.mapper.ProgressAchievMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelProgressAchiev;
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
public class ServiceProgressAch implements IServiceProgressAch{
    @Autowired
    private DaoProgressAchiev daoProgressAchiev;

    @Autowired
    private ProgressAchievMapper progressAchievMapper;

    @Override
    public DtoProgressAchiev find(Long id) {
        return progressAchievMapper.toDto(daoProgressAchiev.findByIdEnable(id).orElse(new ModelProgressAchiev()));
    }

    @Override
    public List<DtoProgressAchiev> findAll() {
        return daoProgressAchiev.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(progressAchievMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public Long save(DtoProgressAchiev dtoProgressAchiev){
        ModelProgressAchiev modelProgressAchiev=progressAchievMapper.toEntity(dtoProgressAchiev);
        ModelProgressAchiev createdEntity=daoProgressAchiev.save(modelProgressAchiev);
        return createdEntity.getId();
    }

    @Override
    public void update(DtoProgressAchiev dtoProgressAchiev){
        ModelProgressAchiev existingEntity=daoProgressAchiev.findByIdEnable(dtoProgressAchiev.getIdLogro()).orElse(null);
        if(existingEntity!=null){
            ModelProgressAchiev updatedEntity=progressAchievMapper.toEntity(dtoProgressAchiev);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoProgressAchiev.save(existingEntity);
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
