package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoAnnualOperativePlan;
import ec.edu.espe.GrupoInvestigacion.dto.DtoAnnualOperativePlan;
import ec.edu.espe.GrupoInvestigacion.mapper.AnnualOperativePlanMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelAnnualOperativePlan;
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
public class ServiceAnnualOperativePlan implements IServiceAnnualOperativePlan{
    @Autowired
    private DaoAnnualOperativePlan daoAnnualOperativePlan;
    @Autowired
    private AnnualOperativePlanMapper annualOperativePlanMapper;

    @Override
    public List<DtoAnnualOperativePlan> findAll() {
        return daoAnnualOperativePlan.findAllEnable().orElse(new ArrayList<>()).stream().map(annualOperativePlanMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public DtoAnnualOperativePlan findById(Long id) {
        return annualOperativePlanMapper.toDto(daoAnnualOperativePlan.findById(id).orElse(new ModelAnnualOperativePlan()));
    }

    @Override
    public Long save(DtoAnnualOperativePlan dtoAnnualOperativePlan) {
        ModelAnnualOperativePlan modelAnnualOperativePlan = annualOperativePlanMapper.toEntity((dtoAnnualOperativePlan));
        ModelAnnualOperativePlan createdEntity = daoAnnualOperativePlan.save(modelAnnualOperativePlan);
        return createdEntity.getId();
    }

    @Override
    public void update(DtoAnnualOperativePlan dtoAnnualOperativePlan) {
        ModelAnnualOperativePlan existingEntity = daoAnnualOperativePlan.findByIdEnable(dtoAnnualOperativePlan.getIdAnnualOperativePlan()).orElse(null);
        if (existingEntity != null) {
            ModelAnnualOperativePlan updateEntity = annualOperativePlanMapper.toEntity((dtoAnnualOperativePlan));
            BeanUtils.copyProperties(updateEntity, existingEntity, getNullPropertyNames(updateEntity) );
            daoAnnualOperativePlan.save(existingEntity);
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
