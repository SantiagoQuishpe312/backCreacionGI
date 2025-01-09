package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelBudgetExecute;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DaoBudgetExecute extends CrudRepository<ModelBudgetExecute,Long> {
    @Query("SELECT be FROM ModelBudgetExecute be")
    public Optional<List<ModelBudgetExecute>> findAllEnable();
    @Query("SELECT be From ModelBudgetExecute be WHERE be.id=:id")
    public Optional<ModelBudgetExecute> findByIdEnable(Long id);
}
