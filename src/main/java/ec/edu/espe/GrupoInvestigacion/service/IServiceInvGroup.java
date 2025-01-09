package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroupGetData;

import java.util.List;

public interface IServiceInvGroup {
    public List<DtoInvGroup> findAll();

    public DtoInvGroup find(Long id);
    Long save(DtoInvGroup dtoInvGroup);
    void update(DtoInvGroup dtoInvGroup);
    public DtoInvGroup findByUser(Long id);
    public DtoInvGroupGetData findAllData(Long id);

}
