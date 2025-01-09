package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoAcademicDomain;

import java.util.List;

public interface IServiceAcademicDomain {

    List<DtoAcademicDomain> findAll();
    DtoAcademicDomain find(Long id);
    Long save(DtoAcademicDomain dtoAcademicDomain);
    void update(DtoAcademicDomain dtoAcademicDomain);
}

