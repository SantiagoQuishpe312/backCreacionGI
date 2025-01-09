package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoSpecificObjectives;

import java.util.List;

public interface IServiceSpecificObjectives {
    List<DtoSpecificObjectives> findAll();

    DtoSpecificObjectives find(Long id);
    List<DtoSpecificObjectives> findByDev(Long id);
    Long save(DtoSpecificObjectives dtoSpecificObjectives);
    void update(DtoSpecificObjectives dtoSpecificObjectives);
}
