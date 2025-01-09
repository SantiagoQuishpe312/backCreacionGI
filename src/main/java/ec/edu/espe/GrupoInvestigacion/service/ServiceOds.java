package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoOds;
import ec.edu.espe.GrupoInvestigacion.dto.DtoOds;
import ec.edu.espe.GrupoInvestigacion.mapper.OdsMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelOds;
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
public class ServiceOds implements IServiceOds{
    @Autowired
    private DaoOds daoOds;
    @Autowired
    private OdsMapper odsMapper;
    @Override
    public List<DtoOds> findAll() {
        return daoOds.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(odsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DtoOds find(Long id) {
        return odsMapper.toDto(daoOds.findByIdEnable(id).orElse(new ModelOds()));
    }

    @Override
    public Long save(DtoOds dtoOds) {
        ModelOds modelOds=odsMapper.toEntity(dtoOds);
        ModelOds createdEntity=daoOds.save(modelOds);

        return createdEntity.getId();
    }

    @Override
    public void update(DtoOds dtoOds) {
    ModelOds existingEntity=daoOds.findByIdEnable(dtoOds.getId()).orElse(null);
    if(existingEntity!=null){
        ModelOds updatedEntity=odsMapper.toEntity(dtoOds);
        BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
        daoOds.save(existingEntity);
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
