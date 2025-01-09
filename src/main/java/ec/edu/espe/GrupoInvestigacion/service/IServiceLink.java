package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoLink;

import java.util.List;

public interface IServiceLink {
    public List<DtoLink> findAll();

    public DtoLink find(Long id);
    public List<DtoLink> findByState(Character estado);
    Long save(DtoLink dtoLink);
    void update(DtoLink dtoLink);
}
