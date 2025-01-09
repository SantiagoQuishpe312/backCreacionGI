package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelNationalPlan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DaoNationalPlan extends CrudRepository<ModelNationalPlan, Long> {
    @Query(value = "SELECT n FROM ModelNationalPlan n")
    public Optional<List<ModelNationalPlan>> findAllEnable();

    @Query(value = "SELECT n FROM ModelNationalPlan n WHERE n.id = :id")
    Optional<ModelNationalPlan> findByIdEnable(@Param("id") Long id);
}
