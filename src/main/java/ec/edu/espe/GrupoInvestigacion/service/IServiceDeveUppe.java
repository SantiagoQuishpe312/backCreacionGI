package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoDevGetLegalFramework;
import ec.edu.espe.GrupoInvestigacion.dto.DtoDevGetUpperLevelPlan;
import ec.edu.espe.GrupoInvestigacion.dto.DtoDeveUppe;

import java.util.List;

public interface IServiceDeveUppe {
    public List<DtoDeveUppe> findAll();
    public List<DtoDeveUppe> find(Long id);
    Long save(DtoDeveUppe dtoDeveUppe);
    public DtoDevGetUpperLevelPlan findByDev(Long id);

}
