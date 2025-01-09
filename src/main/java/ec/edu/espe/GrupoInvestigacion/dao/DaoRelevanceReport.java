package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelProgressAchiev;
import ec.edu.espe.GrupoInvestigacion.model.ModelRelevanceReport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DaoRelevanceReport extends CrudRepository<ModelRelevanceReport, Long> {
    @Query(value = "SELECT mrr FROM ModelRelevanceReport mrr ")
    public Optional<List<ModelRelevanceReport>> findAllEnable();

    @Query(value = "SELECT mrr FROM ModelRelevanceReport mrr WHERE mrr.id =:id")
    public Optional<ModelRelevanceReport> findByIdEnable(Long id);

    @Query(value = "SELECT mrr FROM ModelRelevanceReport mrr WHERE mrr.modelInvGroup.id =:id")
    public Optional<ModelRelevanceReport> findByGroup(Long id);

}
