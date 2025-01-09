package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoArea;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup_Area;
import ec.edu.espe.GrupoInvestigacion.dto.DtoReqGetArea;

import java.util.List;

public interface IServiceInvGroup_Area {
    public List<DtoInvGroup_Area> findAll();

    public List<DtoInvGroup_Area> find(Long id);
    Long save(DtoInvGroup_Area dtoInvGroupArea);
    public List<DtoArea> findByGroup(Long id);
    void delete(Long groupId, Long idArea);
}
