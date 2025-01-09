package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoCongress;
import ec.edu.espe.GrupoInvestigacion.dto.DtoCongress;
import ec.edu.espe.GrupoInvestigacion.mapper.CongressMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelCongress;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
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
public class ServiceCongress implements IServiceCongress {
    @Autowired
    private DaoCongress daoCongress;
    @Autowired
    private CongressMapper congressMapper;
    @Override
    public DtoCongress find(Long id)
    {
        return congressMapper.toDto(daoCongress.findByIdEnable(id).orElse(new ModelCongress()));

    }
    @Override
    public List<DtoCongress> findAll(){
        return daoCongress.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(congressMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public Long save(DtoCongress dtoCongress){
        ModelCongress modelCongress=congressMapper.toEntity(dtoCongress);
        ModelCongress createdEntity=daoCongress.save(modelCongress);
        return createdEntity.getId();
    }

    @Override
    public void update(DtoCongress dtoCongress){
        ModelCongress existingEntity=daoCongress.findByIdEnable(dtoCongress.getIdCongreso()).orElse(null);
        if(existingEntity!=null){
            ModelCongress updatedEntity=congressMapper.toEntity(dtoCongress);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoCongress.save(existingEntity);
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
