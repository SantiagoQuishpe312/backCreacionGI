package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoLink;
import ec.edu.espe.GrupoInvestigacion.dto.DtoLink;
import ec.edu.espe.GrupoInvestigacion.mapper.LinkMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelLegalFramework;
import ec.edu.espe.GrupoInvestigacion.model.ModelLink;
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
public class ServiceLink implements IServiceLink {
    @Autowired
    private DaoLink daoLink;
    @Autowired
    private LinkMapper linkMapper;
    @Override
    public DtoLink find (Long id){
        return linkMapper.toDto(daoLink.findByIdEnable(id).orElse(new ModelLink()));
    }
    @Override
    public List<DtoLink> findAll(){
        return daoLink.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(linkMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<DtoLink> findByState(Character estado){
        return daoLink.findByState(estado)
                .orElse(new ArrayList<>())
                .stream()
                .map(linkMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public Long save(DtoLink dtoLink){
        ModelLink modelLink=linkMapper.toEntity(dtoLink);
        ModelLink createdEntity=daoLink.save(modelLink);
        return createdEntity.getId();
    }

    @Override
    public void update(DtoLink dtoLink){
        ModelLink existingEntity=daoLink.findByIdEnable(dtoLink.getIdVinculacion()).orElse(null);
        if(existingEntity!=null){
            ModelLink updatedEntity=linkMapper.toEntity(dtoLink);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoLink.save(existingEntity);
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
