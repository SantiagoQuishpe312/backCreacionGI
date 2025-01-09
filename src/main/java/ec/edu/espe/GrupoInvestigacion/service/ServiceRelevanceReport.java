package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoRelevanceReport;
import ec.edu.espe.GrupoInvestigacion.dto.DtoRelevanceReport;
import ec.edu.espe.GrupoInvestigacion.mapper.RelevanceReportMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelRelevanceReport;
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
public class ServiceRelevanceReport implements IServiceRelevanceReport {
@Autowired
private DaoRelevanceReport daoRelevanceReport;

@Autowired
private RelevanceReportMapper relevanceReportMapper;
    @Override
    public List<DtoRelevanceReport> findAll() {
        return daoRelevanceReport.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(relevanceReportMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DtoRelevanceReport find(Long id) {
        return relevanceReportMapper.toDto(daoRelevanceReport.findByIdEnable(id).orElse(new ModelRelevanceReport()));
    }
    @Override
    public DtoRelevanceReport findGroup(Long id) {
        return relevanceReportMapper.toDto(daoRelevanceReport.findByGroup(id).orElse(new ModelRelevanceReport()));
    }


    @Override
    public Long save(DtoRelevanceReport dtoRelevanceReport) {
        ModelRelevanceReport modelRelevanceReport=relevanceReportMapper.toEntity(dtoRelevanceReport);
        ModelRelevanceReport createdEntity=daoRelevanceReport.save(modelRelevanceReport);
        return createdEntity.getId();

    }

    @Override
    public void update(DtoRelevanceReport dtoRelevanceReport) {
        ModelRelevanceReport existingEntity=daoRelevanceReport.findByIdEnable(dtoRelevanceReport.getIdInformePertinencia()).orElse(null);
        if(existingEntity!=null){
            ModelRelevanceReport updatedEntity=relevanceReportMapper.toEntity(dtoRelevanceReport);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoRelevanceReport.save(existingEntity);
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
