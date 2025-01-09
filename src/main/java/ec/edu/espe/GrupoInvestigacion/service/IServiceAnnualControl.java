package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoAnnualControl;
import ec.edu.espe.GrupoInvestigacion.dto.DtoDeveLega;

import java.util.List;

public interface IServiceAnnualControl {
    public List<DtoAnnualControl> findByPanel(Long id);
    public List<DtoAnnualControl> findByPlan(Long id);
    public DtoAnnualControl findByIds(Long idPanel,Long idPlan);

    Long save(DtoAnnualControl dtoAnnualControl);

}
