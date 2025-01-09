package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoDeveLega;
import ec.edu.espe.GrupoInvestigacion.dao.DaoDevelopmentPlan;
import ec.edu.espe.GrupoInvestigacion.dao.DaoLegalFramework;
import ec.edu.espe.GrupoInvestigacion.dto.DtoDevGetLegalFramework;
import ec.edu.espe.GrupoInvestigacion.dto.DtoDeveLega;
import ec.edu.espe.GrupoInvestigacion.mapper.DeveLegaMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.LegalFrameworkMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelDeveLega;
import ec.edu.espe.GrupoInvestigacion.model.ModelDeveLegaId;
import ec.edu.espe.GrupoInvestigacion.model.ModelDevelopmentPlan;
import ec.edu.espe.GrupoInvestigacion.model.ModelLegalFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceDeveLega implements IServiceDeveLega{
 @Autowired
 private DaoDeveLega daoDeveLega;
 @Autowired
    private DeveLegaMapper deveLegaMapper;
 @Autowired
    private DaoDevelopmentPlan daoDevelopmentPlan;
 @Autowired
    private DaoLegalFramework daoLegalFramework;
 @Autowired
 private LegalFrameworkMapper legalFrameworkMapper;
 @Autowired
    public ServiceDeveLega(DaoDeveLega daoDeveLega,DeveLegaMapper deveLegaMapper){
     this.daoDeveLega=daoDeveLega;
     this.deveLegaMapper=deveLegaMapper;
 }
 @Override
    public List<DtoDeveLega> find(Long id){
     return daoDeveLega.findByIdEnable(id)
             .orElse(new ArrayList<>())
             .stream()
             .map(deveLegaMapper::toDto)
             .collect(Collectors.toList());
 }
 @Override
    public List<DtoDeveLega> findAll(){
     return daoDeveLega.findAllEnable()
             .orElse(new ArrayList<>())
             .stream()
             .map(deveLegaMapper::toDto)
             .collect(Collectors.toList());
 }
 @Override
    public Long save(DtoDeveLega dtoDeveLega){
     Long developmentPlanId=dtoDeveLega.getIdPlan();
     Long legalFrameworkId=dtoDeveLega.getIdMarco();
     ModelDevelopmentPlan modelDevelopmentPlan=daoDevelopmentPlan.findByIdEnable(developmentPlanId).orElse(new ModelDevelopmentPlan());
     ModelLegalFramework modelLegalFramework=daoLegalFramework.findByIdEnable(legalFrameworkId).orElse(new ModelLegalFramework());
     ModelDeveLega modelDeveLega=deveLegaMapper.toEntity(dtoDeveLega);
     ModelDeveLegaId id=new ModelDeveLegaId();
     id.setModelDevelopmentPlan(modelDevelopmentPlan);
     id.setModelLegalFramework(modelLegalFramework);
     modelDeveLega.setId(id);
     daoDeveLega.save(modelDeveLega);
     return modelDeveLega.getModelLegalFramework().getId();
 }

 @Override public DtoDevGetLegalFramework findByDev(Long id){
     Optional<List<ModelLegalFramework>> modelLegalFrameworks=daoDeveLega.findLegalFramework(id);
     DtoDevGetLegalFramework dtoDevGetLegalFramework=new DtoDevGetLegalFramework();
     if(!modelLegalFrameworks.isEmpty()){
         dtoDevGetLegalFramework.setMarcoLegal(modelLegalFrameworks.get().stream().map(legalFrameworkMapper::toDto).collect(Collectors.toList()));
        return dtoDevGetLegalFramework;
     }
     throw new RuntimeException("No se encontraron marcos legales para el plan de desarrollo");

 }
}
