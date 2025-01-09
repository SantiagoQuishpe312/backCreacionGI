package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoBookChapter;
import ec.edu.espe.GrupoInvestigacion.dto.DtoBudgetExecute;

import java.util.List;

public interface IServiceBudgetExecute {
    public List<DtoBudgetExecute> findAll();
    public DtoBudgetExecute find(Long id);
    Long save(DtoBudgetExecute dtoBudgetExecute);
    void update(DtoBudgetExecute dtoBudgetExecute);
}
