package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoUpperLevelPlan;

import java.util.List;

public interface IServiceUpperLevelPlan {
    List<DtoUpperLevelPlan> findAll();

    DtoUpperLevelPlan find(Long id);

    Long save(DtoUpperLevelPlan dtoUpperLevelPlan);

    void update(DtoUpperLevelPlan dtoUpperLevelPlan);
}
