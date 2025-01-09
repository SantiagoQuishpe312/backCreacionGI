package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoCongress;

import java.util.List;

public interface IServiceCongress {
    public List<DtoCongress> findAll();
    public DtoCongress find(Long id);
    Long save(DtoCongress dtoCongress);
    void update(DtoCongress dtoCongress);
}
