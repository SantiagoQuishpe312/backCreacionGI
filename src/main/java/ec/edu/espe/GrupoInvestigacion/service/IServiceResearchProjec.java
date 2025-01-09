package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoResearchProject;

import java.util.List;

public interface IServiceResearchProjec {
    List<DtoResearchProject> findAll();
    DtoResearchProject find(Long id);
    Long save(DtoResearchProject dtoResearchProject);
    void update(DtoResearchProject dtoResearchProject);
}
