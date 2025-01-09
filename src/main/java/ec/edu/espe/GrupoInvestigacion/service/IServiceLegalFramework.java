package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoLegalFramework;

import java.util.List;

public interface IServiceLegalFramework {
    List<DtoLegalFramework> findAll();

    DtoLegalFramework find(Long id);

    Long save(DtoLegalFramework dtoLegalFramework);
    void update(DtoLegalFramework dtoLegalFramework);
}
