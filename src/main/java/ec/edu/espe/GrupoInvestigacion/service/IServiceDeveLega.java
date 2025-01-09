package ec.edu.espe.GrupoInvestigacion.service;


import ec.edu.espe.GrupoInvestigacion.dto.DtoDevGetLegalFramework;
import ec.edu.espe.GrupoInvestigacion.dto.DtoDevGetNationalPlan;
import ec.edu.espe.GrupoInvestigacion.dto.DtoDeveLega;

import java.util.List;

public interface IServiceDeveLega {
    public List <DtoDeveLega> findAll();
    public List<DtoDeveLega> find(Long id);
    Long save(DtoDeveLega dtoDeveLega);
    public DtoDevGetLegalFramework findByDev(Long id);
}
