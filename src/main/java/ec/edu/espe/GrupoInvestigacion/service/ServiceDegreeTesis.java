package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoDegreeTesis;
import ec.edu.espe.GrupoInvestigacion.dto.DtoDegreeTesis;
import ec.edu.espe.GrupoInvestigacion.mapper.DegreeTesisMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelDegreeTesis;
import ec.edu.espe.GrupoInvestigacion.model.ModelDeveUppeId;
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
public class ServiceDegreeTesis implements IServiceDegreeTesis{
    @Autowired
    private DaoDegreeTesis daoDegreeTesis;
    @Autowired
    private DegreeTesisMapper degreeTesisMapper;
    @Override
    public DtoDegreeTesis find(Long id){
        return degreeTesisMapper.toDto(daoDegreeTesis.findByIdEnable(id).orElse(new ModelDegreeTesis()));

    }
    @Override
    public List<DtoDegreeTesis> findAll(){
        return daoDegreeTesis.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(degreeTesisMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public Long save(DtoDegreeTesis dtoDegreeTesis) {
        ModelDegreeTesis modelDegreeTesis = degreeTesisMapper.toEntity(dtoDegreeTesis);
        ModelDegreeTesis createdEntity = daoDegreeTesis.save(modelDegreeTesis);
    return createdEntity.getId();
    }
@Override
public void update(DtoDegreeTesis dtoDegreeTesis){
        ModelDegreeTesis existingEntity=daoDegreeTesis.findByIdEnable(dtoDegreeTesis.getIdTesis()).orElse(null);
        if(existingEntity!=null){
            ModelDegreeTesis updatedEntity=degreeTesisMapper.toEntity(dtoDegreeTesis);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoDegreeTesis.save(existingEntity);
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
