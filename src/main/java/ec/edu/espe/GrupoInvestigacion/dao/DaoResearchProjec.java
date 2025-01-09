package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelResearchProjec;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;
public interface DaoResearchProjec extends CrudRepository<ModelResearchProjec, Long> {
    @Query(value = "SELECT r FROM ModelResearchProjec r")
    Optional<List<ModelResearchProjec>> findAllEnable();
    @Query(value = "SELECT r FROM ModelResearchProjec r WHERE r.id = :id")
    Optional<ModelResearchProjec> findByIdEnable(Long id);
}
