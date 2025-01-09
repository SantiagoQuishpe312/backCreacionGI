package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dao.DaoArea;
import ec.edu.espe.GrupoInvestigacion.dao.DaoInvGroup;
import ec.edu.espe.GrupoInvestigacion.dao.DaoInvGroup_Area;

import ec.edu.espe.GrupoInvestigacion.dao.DaoCreationReq;
import ec.edu.espe.GrupoInvestigacion.dto.*;
import ec.edu.espe.GrupoInvestigacion.mapper.AreaMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.InvGroupMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.InvGroup_AreaMapper;
import ec.edu.espe.GrupoInvestigacion.mapper.CreationReqMapper;
import ec.edu.espe.GrupoInvestigacion.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceInvGroupArea implements IServiceInvGroup_Area {
    @Autowired
    private DaoInvGroup_Area daoInvGroupArea;
    @Autowired
    private InvGroupMapper invGroupMapper;

    @Autowired
    private InvGroup_AreaMapper invGroupAreaMapper;
    @Autowired
    private DaoInvGroup daoInvGroup;
    @Autowired
    private DaoArea daoArea;
    @Autowired
    private AreaMapper areaMapper;

    @Autowired
    public ServiceInvGroupArea(DaoInvGroup_Area daoInvGroupArea, InvGroup_AreaMapper invGroupAreaMapper) {
        this.daoInvGroupArea = daoInvGroupArea;
        this.invGroupAreaMapper = invGroupAreaMapper;
    }

    @Override
    public List<DtoInvGroup_Area> find(Long id) {
        return daoInvGroupArea.findByIdEnable(id)
                .orElse(new ArrayList<>())
                .stream()
                .map(invGroupAreaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DtoInvGroup_Area> findAll() {
        return daoInvGroupArea.findAllEnable()
                .orElse(new ArrayList<>())
                .stream()
                .map(invGroupAreaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long save(DtoInvGroup_Area dtoInvGroupArea){
        Long groupId= dtoInvGroupArea.getIdGrupo();
        Long areaId= dtoInvGroupArea.getIdArea();
        ModelInvGroup modelInvGroup=daoInvGroup.findByIdEnable(groupId).orElse(new ModelInvGroup());
        ModelArea modelArea=daoArea.findById(areaId).orElse(new ModelArea());
        ModelInvGroup_Area modelInvGroupArea= invGroupAreaMapper.toEntity(dtoInvGroupArea);
        ModelInvGroup_Area_Id id=new ModelInvGroup_Area_Id();
        id.setModelInvGroup(modelInvGroup);
        id.setModelArea(modelArea);
        modelInvGroupArea.setId(id);
        daoInvGroupArea.save(modelInvGroupArea);
        return areaId;
    }
    @Override
    public List<DtoArea> findByGroup(Long id){
    return daoInvGroupArea.findArea(id)
            .orElse(new ArrayList<>())
            .stream()
            .map(areaMapper::toDto)
            .collect(Collectors.toList());
    }
    @Override
    public void delete(Long groupId, Long areaId){
        Optional<ModelInvGroup_Area> invGroupArea=daoInvGroupArea.findByIds(groupId, areaId);
        if (invGroupArea.isPresent()){
            daoInvGroupArea.delete(invGroupArea.get());
        }
        else {
            throw new RuntimeException("no se encontraron datos");
        }
    }
}
