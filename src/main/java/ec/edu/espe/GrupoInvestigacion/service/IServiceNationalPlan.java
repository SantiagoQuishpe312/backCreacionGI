package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoNationalPlan;

import java.util.List;

public interface IServiceNationalPlan {
    List<DtoNationalPlan> findAll();

    DtoNationalPlan find(Long id);

    Long save(DtoNationalPlan dto);
    void update(DtoNationalPlan dtoNationalPlan);
}
