package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoMagazines;
import ec.edu.espe.GrupoInvestigacion.dto.DtoMagazines;
import ec.edu.espe.GrupoInvestigacion.mapper.MagazinesMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelMagazines;
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
public class ServiceMagazines implements IServiceMagazines {

    @Autowired
    private DaoMagazines daoMagazines;

    @Autowired
    private MagazinesMapper magazinesMapper;

    @Override
    public DtoMagazines find(Long id) {
        return magazinesMapper.toDto(daoMagazines.findByIdEnable(id).orElse(new ModelMagazines()));
    }

    @Override
    public List<DtoMagazines> findAll() {
        return daoMagazines.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(magazinesMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long save(DtoMagazines dto) {
        ModelMagazines model = magazinesMapper.toEntity(dto);
        ModelMagazines createdEntity = daoMagazines.save(model);
        return createdEntity.getId();
    }

    @Override
    public void update(DtoMagazines dtoMagazines) {
        ModelMagazines existingEntity=daoMagazines.findByIdEnable(dtoMagazines.getIdRevista()).orElse(null);
        if(existingEntity!=null){
            ModelMagazines updatedEntity=magazinesMapper.toEntity(dtoMagazines);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoMagazines.save(existingEntity);
        }
    }

    private String[] getNullPropertyNames(Object source) {
        try{
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
