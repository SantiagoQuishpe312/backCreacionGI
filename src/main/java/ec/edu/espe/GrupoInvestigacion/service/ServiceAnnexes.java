package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoAnnexes;
import ec.edu.espe.GrupoInvestigacion.dto.DtoAnnexes;
import ec.edu.espe.GrupoInvestigacion.model.ModelAnnexes;
import ec.edu.espe.GrupoInvestigacion.mapper.AnnexesMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServiceAnnexes implements IServiceAnnexes {

    @Autowired
    private DaoAnnexes daoAnnexes;

    @Autowired
    private AnnexesMapper annexesMapper;

    @Override
    public DtoAnnexes find(Long id) {
        return annexesMapper.toDto(daoAnnexes.findById(id).orElse(new ModelAnnexes()));
    }


    @Override
    public List<DtoAnnexes> findAll() {
        return daoAnnexes.findAllEnable().orElseGet(ArrayList::new)
                .stream()
                .map(annexesMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public  List<DtoAnnexes> findBar(Long id, String tipo){
        return daoAnnexes.findByKeywordAndId(tipo,id).orElseGet(ArrayList::new)
                .stream()
                .map(annexesMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long create(DtoAnnexes dtoAnnexes) {
        ModelAnnexes modelAnnexes = annexesMapper.toEntity(dtoAnnexes);
        ModelAnnexes createdEntity = daoAnnexes.save(modelAnnexes);
        return createdEntity.getId();
    }
    @Override
    public void update(DtoAnnexes dtoAnnexes){
        ModelAnnexes existingEntity=daoAnnexes.findByIdEnable(dtoAnnexes.getIdAnexo()).orElse(null);
        if(existingEntity!=null){
            ModelAnnexes updatedEntity=annexesMapper.toEntity(dtoAnnexes);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoAnnexes.save(existingEntity);
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
