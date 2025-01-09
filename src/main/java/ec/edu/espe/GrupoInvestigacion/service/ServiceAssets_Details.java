package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoAssets_Details;
import ec.edu.espe.GrupoInvestigacion.dao.DaoAssets_Details;
import ec.edu.espe.GrupoInvestigacion.mapper.AssetsDetailsMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelAssets_Details;
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
public class ServiceAssets_Details implements IServiceAssets_Details{
    @Autowired
    private DaoAssets_Details daoAssets_Details;
    @Autowired
    private AssetsDetailsMapper assetsDetailsMapper;
    @Override
    public List<DtoAssets_Details> findAll() {
        return daoAssets_Details.findAllEnable().orElse(new ArrayList<>()).stream().map(assetsDetailsMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public DtoAssets_Details find(Long id) {
        return assetsDetailsMapper.toDTO(daoAssets_Details.findByIdEnable(id).orElse(new ModelAssets_Details()));
    }

    @Override
    public Long save(DtoAssets_Details dtoAssetsDetails) {
        ModelAssets_Details modelAssets_Details = assetsDetailsMapper.toEntity(dtoAssetsDetails);
        ModelAssets_Details createdEntity = daoAssets_Details.save(modelAssets_Details);
        return createdEntity.getId();
    }
    @Override
    public void update(DtoAssets_Details dtoAssetsDetails) {
        ModelAssets_Details existingEntity = daoAssets_Details.findByIdEnable(dtoAssetsDetails.getIdDetalles()).orElse(null);
        if (existingEntity != null) {
            ModelAssets_Details updatedEntity = assetsDetailsMapper.toEntity(dtoAssetsDetails);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoAssets_Details.save(existingEntity);
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
