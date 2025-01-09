package ec.edu.espe.GrupoInvestigacion.service;
import ec.edu.espe.GrupoInvestigacion.dto.DtoProgressAchiev;

import java.util.List;

public interface IServiceProgressAch {
    public List<DtoProgressAchiev> findAll();

    public DtoProgressAchiev find(Long id);
    Long save(DtoProgressAchiev dtoProgressAchiev);
    void update(DtoProgressAchiev dtoProgressAchiev);
}
