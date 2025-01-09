package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelCompliance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DaoCompliance extends CrudRepository<ModelCompliance, Long> {
    @Query(value = "SELECT c FROM ModelCompliance c where c.modelActivityReport.id=:id")
    public Optional<List<ModelCompliance>> findByModelActReport(Long id);

    @Query(value = "SELECT c FROM ModelCompliance c where c.modelSpecificObjectives.id=:id")
    public Optional<List<ModelCompliance>> findByModelSpecificObj(Long id);
}
