package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoInstStrategicObj;

import java.util.List;

public interface IServiceInstStrategicObj {
    public List<DtoInstStrategicObj> findAll();
    public DtoInstStrategicObj find(Long id);
    Long save(DtoInstStrategicObj dtoInstStrategicObj);
    void update(DtoInstStrategicObj dtoInstStrategicObj);
}
