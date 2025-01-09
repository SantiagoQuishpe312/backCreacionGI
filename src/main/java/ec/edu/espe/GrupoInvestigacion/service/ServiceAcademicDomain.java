package ec.edu.espe.GrupoInvestigacion.service;
import com.fasterxml.jackson.databind.util.BeanUtil;
import ec.edu.espe.GrupoInvestigacion.model.ModelAcademicDomain;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;

import ec.edu.espe.GrupoInvestigacion.dao.DaoAcademicDomain;
import ec.edu.espe.GrupoInvestigacion.dto.DtoAcademicDomain;
import ec.edu.espe.GrupoInvestigacion.mapper.AcademicDomainMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ServiceAcademicDomain implements IServiceAcademicDomain {

    @Autowired
    private DaoAcademicDomain daoAcademicDomain;

    @Autowired
    private AcademicDomainMapper academicDomainMapper;

    @Override
    public DtoAcademicDomain find(Long id) {
        return academicDomainMapper.toDTO(daoAcademicDomain.findById(id).orElse(new ModelAcademicDomain()));
    }

    @Override
    public List<DtoAcademicDomain> findAll() {
        return daoAcademicDomain.findAllAcademicDomains()
                .orElse(new ArrayList<>())
                .stream()
                .map(academicDomainMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public Long save(DtoAcademicDomain dtoAcademicDomain){
        ModelAcademicDomain modelAcademicDomain=academicDomainMapper.toEntity(dtoAcademicDomain);
        ModelAcademicDomain cratedEntity=daoAcademicDomain.save(modelAcademicDomain);
        return cratedEntity.getId();
    }
    @Override
    public void update(DtoAcademicDomain dtoAcademicDomain){
        ModelAcademicDomain existingEntity=daoAcademicDomain.findById(dtoAcademicDomain.getIdDomimioAcademico()).orElse(null);
        if(existingEntity!=null){
            ModelAcademicDomain updatedEntity=academicDomainMapper.toEntity(dtoAcademicDomain);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoAcademicDomain.save(existingEntity);
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

