package ec.edu.espe.GrupoInvestigacion.service;

import com.fasterxml.jackson.annotation.OptBoolean;
import ec.edu.espe.GrupoInvestigacion.dao.DaoDeveLega;
import ec.edu.espe.GrupoInvestigacion.dao.DaoDeveNati;
import ec.edu.espe.GrupoInvestigacion.dao.DaoDevelopmentPlan;
import ec.edu.espe.GrupoInvestigacion.dao.DaoNationalPlan;
import ec.edu.espe.GrupoInvestigacion.dto.DtoDevGetNationalPlan;
import ec.edu.espe.GrupoInvestigacion.dto.DtoDeveNati;
import ec.edu.espe.GrupoInvestigacion.mapper.DeveNatiMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.NationalPlanMapper;
import ec.edu.espe.GrupoInvestigacion.model.ModelDeveNati;
import ec.edu.espe.GrupoInvestigacion.model.ModelDeveNatiId;
import ec.edu.espe.GrupoInvestigacion.model.ModelDevelopmentPlan;
import ec.edu.espe.GrupoInvestigacion.model.ModelNationalPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceDeveNati implements IServiceDeveNati{
    @Autowired
    private DaoDeveNati daoDeveNati;
    @Autowired
    private DeveNatiMapper deveNatiMapper;
    @Autowired
    private DaoDevelopmentPlan daoDevelopmentPlan;
    @Autowired
    private DaoNationalPlan daoNationalPlan;
@Autowired
private NationalPlanMapper nationalPlanMapper;
    @Autowired
    public ServiceDeveNati(DaoDeveNati daoDeveNati,DeveNatiMapper deveNatiMapper){
        this.daoDeveNati=daoDeveNati;
        this.deveNatiMapper=deveNatiMapper;
    }

    @Override
    public List<DtoDeveNati> findAll(){
        return daoDeveNati.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(deveNatiMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public  List<DtoDeveNati> find(Long id){
        return daoDeveNati.findByIdEnable(id)
                .orElse(new ArrayList<>())
                .stream()
                .map(deveNatiMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public Long save(DtoDeveNati dtoDeveNati){
        Long developmentPlanId=dtoDeveNati.getIdPlan();
        Long nationalPlanId= dtoDeveNati.getIdPlanNacional();
        ModelDevelopmentPlan modelDevelopmentPlan=daoDevelopmentPlan.findByIdEnable(developmentPlanId).orElse(new ModelDevelopmentPlan());
        ModelNationalPlan modelNationalPlan=daoNationalPlan.findByIdEnable(nationalPlanId).orElse(new ModelNationalPlan());
        ModelDeveNati modelDeveNati=deveNatiMapper.toEntity(dtoDeveNati);
        ModelDeveNatiId id=new ModelDeveNatiId();
        id.setModelDevelopmentPlan(modelDevelopmentPlan);
        id.setModelNationalPlan(modelNationalPlan);
        modelDeveNati.setId(id);
        daoDeveNati.save(modelDeveNati);
        return modelDeveNati.getModelNationalPlan().getId();

    }
    @Override
    public DtoDevGetNationalPlan findByDev(Long id){
        Optional<List<ModelNationalPlan>> modelNationalPlans=daoDeveNati.findNationalPlan(id);
        DtoDevGetNationalPlan dtoDevGetNationalPlan=new DtoDevGetNationalPlan();
        if(!modelNationalPlans.isEmpty()){
            dtoDevGetNationalPlan.setPlanNacional(modelNationalPlans.get().stream().map(nationalPlanMapper::toDto).collect(Collectors.toList()));
            return dtoDevGetNationalPlan;
        }
        throw new RuntimeException("No se encontraron planes Nacionale para el plan de desarrollo");

    }
}
