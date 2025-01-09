package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoStrategies;

import java.util.List;

public interface IServiceStrategies {
    List<DtoStrategies> findAll();

    DtoStrategies find(Long id);
    List<DtoStrategies> findByObj(Long id);

  //  List<DtoObjGetStrategies> findComplete(Long idPlan);
    Long save(DtoStrategies dto);
    void update(DtoStrategies dtoStrategies);
}
