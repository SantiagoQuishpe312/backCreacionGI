package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoOds;

import java.util.List;

public interface IServiceOds {
    public List<DtoOds> findAll();

    public DtoOds find(Long id);
    Long save(DtoOds dtoOds);
    void update(DtoOds dtoOds);
}
