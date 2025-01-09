package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoCreationReq;

import java.util.List;

public interface IServiceCreationReq {
    public List<DtoCreationReq> findAll();

    public DtoCreationReq find(Long id);
    public DtoCreationReq findByGroup(Long id);
    Long save(DtoCreationReq dtoCreationReq);
    void update(DtoCreationReq dtoCreationReq);
}
