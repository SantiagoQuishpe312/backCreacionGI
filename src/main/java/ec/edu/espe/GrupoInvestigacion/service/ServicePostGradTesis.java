package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoPostGradTesis;
import ec.edu.espe.GrupoInvestigacion.dto.DtoPostGradTesis;
import ec.edu.espe.GrupoInvestigacion.mapper.PostGradTesisMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelPostGradTesis;
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
public class ServicePostGradTesis implements IServicePostGradTesis {

    @Autowired
    private DaoPostGradTesis daoPostGradTesis;

    @Autowired
    private PostGradTesisMapper postGradTesisMapper;

    @Override
    public List<DtoPostGradTesis> findAll() {
        return daoPostGradTesis.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(postGradTesisMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DtoPostGradTesis find(Long id) {
        return postGradTesisMapper.toDto(daoPostGradTesis.findByIdEnable(id).orElse(new ModelPostGradTesis()));
    }

    @Override
    public Long save(DtoPostGradTesis dto) {
        ModelPostGradTesis model = postGradTesisMapper.toEntity(dto);
        ModelPostGradTesis createdEntity = daoPostGradTesis.save(model);
        return createdEntity.getId();
    }

    @Override
    public void update(DtoPostGradTesis dtoPostGradTesis){
        ModelPostGradTesis existingEntity=daoPostGradTesis.findByIdEnable(dtoPostGradTesis.getIdTesis()).orElse(null);
        if(existingEntity!=null){
            ModelPostGradTesis updatedEntity=postGradTesisMapper.toEntity(dtoPostGradTesis);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoPostGradTesis.save(existingEntity);
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
