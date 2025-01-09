package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoArea;
import ec.edu.espe.GrupoInvestigacion.dto.DtoArea;
import ec.edu.espe.GrupoInvestigacion.mapper.AreaMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelArea;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServiceArea implements IServiceArea {

    @Autowired
    private DaoArea daoArea;

    @Autowired
    private AreaMapper areaMapper;

    @Override
    public DtoArea find(Long id) {
        return areaMapper.toDto(daoArea.findById(id).orElse(new ModelArea()));
    }

    public List<DtoArea> findAll() {
        return daoArea.findAllAreas().orElseGet(ArrayList::new)
                .stream()
                .map(areaMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<DtoArea> findAllDto() {
        return daoArea.findAllAreas()
                .orElse(new ArrayList<>())
                .stream()
                .map(areaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long save(DtoArea dtoArea) {
        ModelArea modelArea=areaMapper.toEntity(dtoArea);
        ModelArea createdEntity=daoArea.save(modelArea);

        return createdEntity.getId();
    }

    @Override
    public void update(DtoArea dtoArea){
        ModelArea existingEntity=daoArea.findById(dtoArea.getIdArea()).orElse(null);
        if (existingEntity!=null){
            ModelArea updatedEntity=areaMapper.toEntity(dtoArea);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoArea.save(existingEntity);
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
