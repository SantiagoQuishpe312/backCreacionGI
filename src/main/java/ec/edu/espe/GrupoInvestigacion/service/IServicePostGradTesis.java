package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoPostGradTesis;

import java.util.List;

public interface IServicePostGradTesis {
    List<DtoPostGradTesis> findAll();

    DtoPostGradTesis find(Long id);

    Long save(DtoPostGradTesis dto);
    void update(DtoPostGradTesis dtoPostGradTesis);
}
