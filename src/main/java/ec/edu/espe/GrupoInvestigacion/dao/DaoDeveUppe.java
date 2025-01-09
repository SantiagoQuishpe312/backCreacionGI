package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelDeveUppe;
import ec.edu.espe.GrupoInvestigacion.model.ModelLegalFramework;
import ec.edu.espe.GrupoInvestigacion.model.ModelUpperLevelPlan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DaoDeveUppe extends CrudRepository<ModelDeveUppe, Long> {
    @Query(value = "SELECT du FROM ModelDeveUppe du")
    public Optional<List<ModelDeveUppe>> findAllEnable();
    @Query(value = "SELECT du FROM ModelDeveUppe du WHERE du.modelDevelopmentPlan.id =:id")
    public Optional<List<ModelDeveUppe>> findByIdEnable(Long id);

    @Query(value = "SELECT dl.modelUpperLevelPlan FROM ModelDeveUppe dl where dl.modelDevelopmentPlan.id=:id")
    public Optional<List<ModelUpperLevelPlan>> findUpperLevelPlan(Long id);
}
