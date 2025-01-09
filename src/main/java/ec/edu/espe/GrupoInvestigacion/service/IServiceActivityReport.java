package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoActivityReport;

import java.util.List;

public interface IServiceActivityReport {
    List<DtoActivityReport> findAll();
    DtoActivityReport find(Long id);
    List<DtoActivityReport> findByState(Character state);
    Long save(DtoActivityReport dtoActivityReport);
    void update(DtoActivityReport dtoActivityReport);
}
