package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoObjStrategies;

import java.util.List;

public interface IServiceObjStrategies {
    public List<DtoObjStrategies> findAll();

    public DtoObjStrategies find(Long id);
    Long save(DtoObjStrategies dtoObjStrategies);
    void update(DtoObjStrategies dtoObjStrategies);
}
