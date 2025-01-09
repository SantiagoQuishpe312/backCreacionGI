package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoDegreeTesis;

import java.util.List;

public interface IServiceDegreeTesis {
    public List<DtoDegreeTesis> findAll();
    public DtoDegreeTesis find(Long id);
    Long save(DtoDegreeTesis dtoDegreeTesis);
    void update(DtoDegreeTesis dtoDegreeTesis);
}
