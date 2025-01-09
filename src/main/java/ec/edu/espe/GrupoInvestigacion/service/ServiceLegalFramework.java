package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoLegalFramework;
import ec.edu.espe.GrupoInvestigacion.dto.DtoLegalFramework;
import ec.edu.espe.GrupoInvestigacion.mapper.LegalFrameworkMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelLegalFramework;
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
public class ServiceLegalFramework implements IServiceLegalFramework {

    @Autowired
    private DaoLegalFramework daoLegalFramework;

    @Autowired
    private LegalFrameworkMapper legalFrameworkMapper;

    @Override
    public DtoLegalFramework find(Long id) {
        return legalFrameworkMapper.toDto(daoLegalFramework.findByIdEnable(id).orElse(new ModelLegalFramework()));
    }

    @Override
    public List<DtoLegalFramework> findAll() {
        return daoLegalFramework.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(legalFrameworkMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long save(DtoLegalFramework dto) {
        ModelLegalFramework model = legalFrameworkMapper.toEntity(dto);
        ModelLegalFramework createdEntity = daoLegalFramework.save(model);
        return createdEntity.getId();
    }

    @Override
    public void update(DtoLegalFramework dtoLegalFramework){
        ModelLegalFramework existingEntity=daoLegalFramework.findByIdEnable(dtoLegalFramework.getIdMarcoLegal()).orElse(null);
        if(existingEntity!=null){
            ModelLegalFramework updatedEntity=legalFrameworkMapper.toEntity(dtoLegalFramework);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoLegalFramework.save(existingEntity);
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
