package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoLine;
import ec.edu.espe.GrupoInvestigacion.dto.DtoLineGetArea;

import java.util.List;

public interface IServiceLine {
    public List<DtoLine> findAll();

    public DtoLine find(Long id);
    Long save(DtoLine dtoLine);

    public DtoLineGetArea findAreaByLine(Long id);
    public List<DtoLineGetArea> findAllAreaByLine(Long id);

    void update(DtoLine dtoLine);
    public List<DtoLine> findLineByArea(Long id);


}
