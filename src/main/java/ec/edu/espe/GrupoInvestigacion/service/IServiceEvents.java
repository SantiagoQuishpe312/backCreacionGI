package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoEvents;

import java.util.List;

public interface IServiceEvents {
    public List<DtoEvents> findAll();

    public DtoEvents find(Long id);
    Long save(DtoEvents dtoEvents);
    void update(DtoEvents dtoEvents);
}
