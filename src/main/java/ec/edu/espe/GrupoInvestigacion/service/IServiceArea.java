package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoArea;
import ec.edu.espe.GrupoInvestigacion.model.ModelArea;

import java.util.List;

public interface IServiceArea {
    public List<DtoArea> findAll();
    public DtoArea find(Long id);
    Long save(DtoArea dtoArea);
    void update(DtoArea dtoArea);
}
