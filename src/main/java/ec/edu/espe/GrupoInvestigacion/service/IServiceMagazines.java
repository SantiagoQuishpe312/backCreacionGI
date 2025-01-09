package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoMagazines;


import java.util.List;

public interface IServiceMagazines {
    List<DtoMagazines> findAll();

    DtoMagazines find(Long id);

    Long save(DtoMagazines dto);
    void update(DtoMagazines dtoMagazines);
}
