package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoProgressAchiev;
import ec.edu.espe.GrupoInvestigacion.dto.DtoRelevanceReport;

import java.util.List;

public interface IServiceRelevanceReport {
    public List<DtoRelevanceReport> findAll();

    public DtoRelevanceReport find(Long id);
    Long save(DtoRelevanceReport dtoRelevanceReport);
    void update(DtoRelevanceReport dtoRelevanceReport);
    public DtoRelevanceReport findGroup(Long id);


}
