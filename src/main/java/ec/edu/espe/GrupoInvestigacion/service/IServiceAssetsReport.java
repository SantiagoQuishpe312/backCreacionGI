package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoAssetsReport;

import java.util.List;

public interface IServiceAssetsReport {
    public List<DtoAssetsReport> findAll();
    public DtoAssetsReport find(Long id);
    Long save(DtoAssetsReport dtoAssetsReport);
    void update(DtoAssetsReport dtoAssetsReport);
}
