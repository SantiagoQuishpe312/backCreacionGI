package ec.edu.espe.GrupoInvestigacion.service;



import ec.edu.espe.GrupoInvestigacion.dao.DaoCreationReq;
import ec.edu.espe.GrupoInvestigacion.dao.DaoInvGroup;
import ec.edu.espe.GrupoInvestigacion.dao.DaoUser;
import ec.edu.espe.GrupoInvestigacion.dto.DtoCreationReq;
import ec.edu.espe.GrupoInvestigacion.mapper.CreationReqMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelCreationReq;
import ec.edu.espe.GrupoInvestigacion.model.ModelInvGroup;
import ec.edu.espe.GrupoInvestigacion.model.ModelUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
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
public class ServiceCreationReq implements IServiceCreationReq{
    @Autowired
    private DaoCreationReq daoCreationReq;
@Autowired
private DaoUser daoUser;
@Autowired
private  DaoInvGroup daoInvGroup;
    @Autowired
    private CreationReqMapper creationReqMapper;
    @Override
    public DtoCreationReq find(Long id) {
        return creationReqMapper.toDto(daoCreationReq.findByIdEnable(id).orElse(new ModelCreationReq()));
    }
    @Override
    public DtoCreationReq findByGroup(Long id) {
        return creationReqMapper.toDto(daoCreationReq.findByGroup(id).orElse(new ModelCreationReq()));
    }

    @Override
    public List<DtoCreationReq> findAll() {
        return daoCreationReq.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(creationReqMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public Long save(DtoCreationReq dtoCreationReq){
        ModelCreationReq modelCreationReq=creationReqMapper.toEntity(dtoCreationReq);
        ModelCreationReq createdEntity=daoCreationReq.save(modelCreationReq);
        System.out.println("received: " + dtoCreationReq);
        return createdEntity.getId();
    }
    @Override
    public void update(DtoCreationReq dtoCreationReq){
        ModelCreationReq existingEntity=daoCreationReq.findByIdEnable(dtoCreationReq.getIdPeticionCreacion()).orElse(null);
        if(existingEntity!=null){
            ModelCreationReq updatedEntity=creationReqMapper.toEntity(dtoCreationReq);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoCreationReq.save(existingEntity);
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
