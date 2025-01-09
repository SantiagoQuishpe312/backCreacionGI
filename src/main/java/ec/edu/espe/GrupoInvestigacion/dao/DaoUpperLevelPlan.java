package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelUpperLevelPlan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DaoUpperLevelPlan extends CrudRepository<ModelUpperLevelPlan, Long> {
    @Query(value = "SELECT ulp FROM ModelUpperLevelPlan ulp")
    Optional<List<ModelUpperLevelPlan>> findAllEnable();

    @Query(value = "SELECT ulp FROM ModelUpperLevelPlan ulp WHERE ulp.id = :id")
    Optional<ModelUpperLevelPlan> findByIdEnable(@Param("id") Long id);
}
