package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoResearchProjec;
import ec.edu.espe.GrupoInvestigacion.dto.DtoResearchProject;
import ec.edu.espe.GrupoInvestigacion.mapper.ResearchProjecMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelResearchProjec;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServiceResearchProjec implements IServiceResearchProjec {
    @Autowired
    private DaoResearchProjec researchProjectDao;

    @Autowired
    private ResearchProjecMapper researchProjectMapper;

    @Override
    public List<DtoResearchProject> findAll() {
        return researchProjectDao.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(researchProjectMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DtoResearchProject find(Long id) {
        return researchProjectMapper.toDto(researchProjectDao.findByIdEnable(id).orElse(new ModelResearchProjec()));
    }

    @Override
    public Long save(DtoResearchProject dto) {
        ModelResearchProjec model = researchProjectMapper.toEntity(dto);
        ModelResearchProjec createdEntity = researchProjectDao.save(model);
        return createdEntity.getId();
    }

    @Override
    public void update(DtoResearchProject dto) {
        Optional<ModelResearchProjec> existingEntity = researchProjectDao.findById(dto.getIdProyecto());
        existingEntity.ifPresent(entity -> {
            ModelResearchProjec updatedEntity = researchProjectMapper.toEntity(dto);
            BeanUtils.copyProperties(updatedEntity, entity, getNullPropertyNames(updatedEntity));
            researchProjectDao.save(entity);
        });
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
