package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelAnnualControl;
import ec.edu.espe.GrupoInvestigacion.model.ModelAnnualOperativePlan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DaoAnnualOperativePlan extends CrudRepository<ModelAnnualOperativePlan,Long>{
    @Query("SELECT ac FROM ModelAnnualOperativePlan ac WHERE ac.id=:id")
    public Optional<ModelAnnualOperativePlan> findByIdEnable(Long id);

    @Query("SELECT ac FROM ModelAnnualOperativePlan ac")
    public Optional<List<ModelAnnualOperativePlan>> findAllEnable();
}
