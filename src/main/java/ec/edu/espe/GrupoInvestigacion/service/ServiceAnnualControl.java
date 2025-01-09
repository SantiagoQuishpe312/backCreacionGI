package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoAnnualControl;
import ec.edu.espe.GrupoInvestigacion.dao.DaoAnnualOperativePlan;
import ec.edu.espe.GrupoInvestigacion.dao.DaoControlPanel;
import ec.edu.espe.GrupoInvestigacion.dto.DtoAnnualControl;
import ec.edu.espe.GrupoInvestigacion.mapper.AnnualControlMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.ControlPanelMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelAnnualControl;
import ec.edu.espe.GrupoInvestigacion.model.ModelAnnualControlId;
import ec.edu.espe.GrupoInvestigacion.model.ModelAnnualOperativePlan;
import ec.edu.espe.GrupoInvestigacion.model.ModelControlPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceAnnualControl implements IServiceAnnualControl{
    @Autowired
    private DaoAnnualControl daoAnnualControl;
    @Autowired
    private AnnualControlMapper annualControlMapper;
    @Autowired
    private DaoControlPanel daoControlPanel;
    @Autowired
    private DaoAnnualOperativePlan daoAnnualOperativePlan;

    @Autowired
    private ControlPanelMapper controlPanelMapper;

    @Autowired
    public ServiceAnnualControl(DaoAnnualControl daoAnnualControl,AnnualControlMapper annualControlMapper){
        this.annualControlMapper=annualControlMapper;
        this.daoAnnualControl=daoAnnualControl;
    }


    @Override
    public List<DtoAnnualControl> findByPanel(Long id) {
        return daoAnnualControl.findByIdControl(id)
                .orElse(new ArrayList<>())
                .stream()
                .map(annualControlMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DtoAnnualControl> findByPlan(Long id) {
        return daoAnnualControl.findByIdPlan(id)
                .orElse(new ArrayList<>())
                .stream()
                .map(annualControlMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DtoAnnualControl findByIds(Long idPanel, Long idPlan) {
        return annualControlMapper.toDto(daoAnnualControl.findByIdControlPlan(idPanel, idPlan).orElse(new ModelAnnualControl()));
    }

    @Override
    public Long save(DtoAnnualControl dtoAnnualControl) {
        Long annualPlanId=dtoAnnualControl.getIdPlanAnual();
        Long controlPanelId=dtoAnnualControl.getIdPanelControl();
        ModelAnnualOperativePlan modelAnnualOperativePlan=daoAnnualOperativePlan.findByIdEnable(annualPlanId).orElse(new ModelAnnualOperativePlan());
        ModelControlPanel modelControlPanel=daoControlPanel.findByIdEnable(controlPanelId).orElse(new ModelControlPanel());
        ModelAnnualControl modelAnnualControl=annualControlMapper.toEntity(dtoAnnualControl);
        ModelAnnualControlId id=new ModelAnnualControlId();
        id.setModelControlPanel(modelControlPanel);
        id.setModelAnnualOperativePlan(modelAnnualOperativePlan);
        modelAnnualControl.setId(id);
        daoAnnualControl.save(modelAnnualControl);
        return modelAnnualControl.getModelAnnualOperativePlan().getId();
    }
}
