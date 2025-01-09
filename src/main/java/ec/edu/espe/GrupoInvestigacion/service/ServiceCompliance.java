package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoActivityReport;
import ec.edu.espe.GrupoInvestigacion.dao.DaoCompliance;
import ec.edu.espe.GrupoInvestigacion.dao.DaoSpecificObjectives;
import ec.edu.espe.GrupoInvestigacion.dto.DtoCompliance;
import ec.edu.espe.GrupoInvestigacion.mapper.ComplianceMapper;
import ec.edu.espe.GrupoInvestigacion.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceCompliance implements IServiceCompliance {
@Autowired
private DaoCompliance daoCompliance;
@Autowired
private ComplianceMapper complianceMapper;
@Autowired
private DaoSpecificObjectives daoSpecificObjectives;
@Autowired
private DaoActivityReport daoActivityReport;

@Autowired

    public ServiceCompliance(DaoCompliance daoCompliance,ComplianceMapper complianceMapper) {
        this.daoCompliance = daoCompliance;
        this.complianceMapper=complianceMapper;
    }

    @Override
    public List<DtoCompliance> findByObj(Long id) {
        return daoCompliance.findByModelSpecificObj(id)
                .orElse(new ArrayList<>())
                .stream()
                .map(complianceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DtoCompliance> findByActReport(Long id) {
        return daoCompliance.findByModelActReport(id)
                .orElse(new ArrayList<>())
                .stream()
                .map(complianceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long save(DtoCompliance dtoCompliance) {
        Long objId=dtoCompliance.getIdObjEspecifico();
        Long actReportId=dtoCompliance.getIdReporteActividades();
        ModelSpecificObjectives modelSpecificObjectives= daoSpecificObjectives.findByIdEnable(objId).orElse(new ModelSpecificObjectives());
        ModelActivityReport modelActivityReport=daoActivityReport.findByIdEnable(actReportId).orElse(new ModelActivityReport());
        ModelCompliance modelCompliance=complianceMapper.toEntity(dtoCompliance);
        ModelComplianceId id=new ModelComplianceId();
        id.setModelActivityReport(modelActivityReport);
        id.setModelSpecificObjectives(modelSpecificObjectives);
        modelCompliance.setId(id);
        daoCompliance.save(modelCompliance);
        return modelCompliance.getModelActivityReport().getId();


    }
}
