package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelAnnualControl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DaoAnnualControl extends CrudRepository<ModelAnnualControl, Long> {

    @Query("SELECT ac FROM ModelAnnualControl ac WHERE ac.modelAnnualOperativePlan.id = :id")
    Optional<List<ModelAnnualControl>> findByIdPlan(@Param("id") Long id);

    @Query("SELECT ac FROM ModelAnnualControl ac WHERE ac.modelControlPanel.id = :id")
    Optional<List<ModelAnnualControl>> findByIdControl(@Param("id") Long id);

    @Query("SELECT ac FROM ModelAnnualControl ac WHERE ac.modelControlPanel.id = :idPanel AND ac.modelAnnualOperativePlan.id = :idPlan")
    Optional<List<ModelAnnualControl>> findByIdPanel(@Param("idPanel") Long idPanel, @Param("idPlan") Long idPlan);

    @Query("SELECT ac FROM ModelAnnualControl ac WHERE ac.modelControlPanel.id = :idPanel AND ac.modelAnnualOperativePlan.id = :idPlan")
    Optional<ModelAnnualControl> findByIdControlPlan(@Param("idPanel") Long idPanel, @Param("idPlan") Long idPlan);
}
