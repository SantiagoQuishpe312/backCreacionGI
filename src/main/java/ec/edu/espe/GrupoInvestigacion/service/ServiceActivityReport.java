package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoActivityReport;
import ec.edu.espe.GrupoInvestigacion.dto.DtoActivityReport;
import ec.edu.espe.GrupoInvestigacion.mapper.ActivityReportMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelActivityReport;
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
public class ServiceActivityReport implements IServiceActivityReport{
    @Autowired
    private DaoActivityReport daoActivityReport;
    @Autowired
    private ActivityReportMapper activityReportMapper;
    @Override
    public DtoActivityReport find(Long id){
        return activityReportMapper.toDTO(daoActivityReport.findByIdEnable(id).orElse(new ModelActivityReport()));
    };
    @Override
    public List<DtoActivityReport> findAll(){
        return daoActivityReport.findAllEnable().orElse(new ArrayList<>()).stream().map(activityReportMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<DtoActivityReport> findByState(Character state){
        return daoActivityReport.findByState(state).orElse(new ArrayList<>()).stream().map(activityReportMapper::toDTO).collect(Collectors.toList());
    }
    @Override
    public Long save(DtoActivityReport dtoActivityReport){
        ModelActivityReport modelActivityReport=activityReportMapper.toEntity(dtoActivityReport);
        ModelActivityReport createdEntity=daoActivityReport.save(modelActivityReport);
        return createdEntity.getId();
    }
    @Override
    public void update(DtoActivityReport dtoActivityReport){
        ModelActivityReport existingEntity=daoActivityReport.findByIdEnable(dtoActivityReport.getIdInformeActividades()).orElse(null);
        if (existingEntity != null) {
            ModelActivityReport updatedEntity=activityReportMapper.toEntity(dtoActivityReport);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoActivityReport.save(existingEntity);
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
