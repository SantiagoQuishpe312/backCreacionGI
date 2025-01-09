package ec.edu.espe.GrupoInvestigacion.service;


import ec.edu.espe.GrupoInvestigacion.dto.DtoCompliance;

import java.util.List;

public interface IServiceCompliance {
    public List<DtoCompliance> findByObj(Long id);
    public List<DtoCompliance> findByActReport(Long id);
    Long save(DtoCompliance dtoCompliance);

}
