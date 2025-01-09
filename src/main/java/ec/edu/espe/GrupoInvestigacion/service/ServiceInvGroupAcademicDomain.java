package ec.edu.espe.GrupoInvestigacion.service;


import ec.edu.espe.GrupoInvestigacion.dao.*;
import ec.edu.espe.GrupoInvestigacion.dto.DtoAcademicDomain;
import ec.edu.espe.GrupoInvestigacion.dto.DtoCreationReq;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup_AcademicDomain;
import ec.edu.espe.GrupoInvestigacion.dto.DtoReqGetAcademicDom;
import ec.edu.espe.GrupoInvestigacion.mapper.AcademicDomainMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.CreationReqMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.InvGroupMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.InvGroup_AcademicDomainMapper;
import ec.edu.espe.GrupoInvestigacion.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ServiceInvGroupAcademicDomain implements IServiceInvGroup_AcademicDomain {

    @Autowired
    private DaoInvGroup_AcademicDomain daoInvGroupAcademicDomain;
@Autowired
private InvGroupMapper invGroupMapper;
@Autowired
private AcademicDomainMapper academicDomainMapper;
    @Autowired
    private InvGroup_AcademicDomainMapper invGroupAcademicDomainMapper;
    @Autowired
    private DaoAcademicDomain daoAcademicDomain;
    @Autowired
    private DaoInvGroup daoInvGroup;
    @Autowired
    public ServiceInvGroupAcademicDomain(DaoInvGroup_AcademicDomain daoInvGroupAcademicDomain, InvGroup_AcademicDomainMapper invGroupAcademicDomainMapper) {
        this.daoInvGroupAcademicDomain = daoInvGroupAcademicDomain;
        this.invGroupAcademicDomainMapper = invGroupAcademicDomainMapper;
    }
    @Override
    public List<DtoInvGroup_AcademicDomain> find(Long id) {
        return daoInvGroupAcademicDomain.findByIdEnable(id)
                .orElse(new ArrayList<>())
                .stream()
                .map(invGroupAcademicDomainMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DtoInvGroup_AcademicDomain> findAll() {
        return daoInvGroupAcademicDomain.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(invGroupAcademicDomainMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public Long save(DtoInvGroup_AcademicDomain dtoInvGroupAcademicDomain) {
        Long acadDomId=dtoInvGroupAcademicDomain.getIdDomAcad();
        Long groupId=dtoInvGroupAcademicDomain.getIdGrupo();
        ModelAcademicDomain modelAcademicDomain=daoAcademicDomain.findById(acadDomId).orElse(new ModelAcademicDomain());
        ModelInvGroup modelInvGroup=daoInvGroup.findByIdEnable(groupId).orElse(new ModelInvGroup());

        ModelInvGroup_AcademicDomains modelInvGroupAcademicDomains = invGroupAcademicDomainMapper.toEntity(dtoInvGroupAcademicDomain);
        ModelInvGroup_AcademicDomains_Id id=new ModelInvGroup_AcademicDomains_Id();
        id.setModelAcademicDomain(modelAcademicDomain);
        id.setModelInvGroup(modelInvGroup);
        modelInvGroupAcademicDomains.setId(id);

        daoInvGroupAcademicDomain.save(modelInvGroupAcademicDomains);
        return acadDomId;
    }
    @Override
    public List<DtoAcademicDomain> findByGroup(Long id){
    return daoInvGroupAcademicDomain.findAcademicDomain(id)
        .orElse(new ArrayList<>())
        .stream()
        .map(academicDomainMapper::toDTO)
        .collect(Collectors.toList());
    }

    @Override
    public void delete(Long groupId, Long acadId){
        Optional<ModelInvGroup_AcademicDomains> invGroupAcademicDomains=daoInvGroupAcademicDomain.findByIds(groupId, acadId);
        if (invGroupAcademicDomains.isPresent()){
            daoInvGroupAcademicDomain.delete(invGroupAcademicDomains.get());
        }
        else {
            throw new RuntimeException("no se encontraron datos");
        }
    }
}
