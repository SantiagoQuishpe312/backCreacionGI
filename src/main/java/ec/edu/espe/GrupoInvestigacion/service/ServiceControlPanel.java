package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoControlPanel;
import ec.edu.espe.GrupoInvestigacion.dao.DaoDevelopmentPlan;
import ec.edu.espe.GrupoInvestigacion.dao.DaoUser;
import ec.edu.espe.GrupoInvestigacion.dto.DtoControlPanel;
import ec.edu.espe.GrupoInvestigacion.mapper.ControlPanelMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelControlPanel;
import ec.edu.espe.GrupoInvestigacion.model.ModelCreationReq;
import ec.edu.espe.GrupoInvestigacion.model.ModelDevelopmentPlan;
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
public class ServiceControlPanel implements IServiceControlPanel {

    @Autowired
    private DaoControlPanel daoControlPanel;
    @Autowired
    private DaoDevelopmentPlan daoDevelopmentPlan;
    @Autowired
    private ControlPanelMapper controlPanelMapper;

    @Autowired
    public ServiceControlPanel(DaoControlPanel daoControlPanel,DaoDevelopmentPlan daoDevelopmentPlan, ControlPanelMapper controlPanelMapper){
        this.daoControlPanel=daoControlPanel;
        this.daoDevelopmentPlan=daoDevelopmentPlan;
        this.controlPanelMapper=controlPanelMapper;
    }
    @Override
    public DtoControlPanel find(Long id) {
        return controlPanelMapper.toDto(daoControlPanel.findByIdEnable(id).orElse(new ModelControlPanel()));
    }

    @Override
    public List<DtoControlPanel> findAll() {
        return daoControlPanel.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(controlPanelMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DtoControlPanel> findByDev(Long id) {
        return daoControlPanel.findByIdDev(id)
                .orElse(new ArrayList<>())
                .stream()
                .map(controlPanelMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public Long save(DtoControlPanel dtoControlPanel){
        ModelControlPanel modelControlPanel=controlPanelMapper.toEntity(dtoControlPanel);
        ModelControlPanel createdEntity=daoControlPanel.save(modelControlPanel);
        return createdEntity.getId();
    }
    @Override
    public void update(DtoControlPanel dtoControlPanel){
        ModelControlPanel existingEntity=daoControlPanel.findByIdEnable(dtoControlPanel.getIdPanelControl()).orElse(null);
        if(existingEntity!=null){
            ModelControlPanel updatedEntity=controlPanelMapper.toEntity(dtoControlPanel);
            BeanUtils.copyProperties(updatedEntity,existingEntity,getNullPropertyNames(updatedEntity));
            daoControlPanel.save(existingEntity);
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
