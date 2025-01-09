package ec.edu.espe.GrupoInvestigacion.service;


import ec.edu.espe.GrupoInvestigacion.dto.DtoArea;
import ec.edu.espe.GrupoInvestigacion.dto.DtoInvGroup_Line;
import ec.edu.espe.GrupoInvestigacion.dto.DtoLine;

import java.util.List;

public interface IServiceInvGroup_Line {
    public List<DtoInvGroup_Line> findAll();

    public List<DtoInvGroup_Line> find(Long id);
    Long save(DtoInvGroup_Line dtoLineCrea);
    public List<DtoLine> findByGroup(Long id);
    void delete (Long groupId, Long lineId);
    void deleteByArea(Long id);
}
