package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelControlPanel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DaoControlPanel extends CrudRepository<ModelControlPanel, Long> {
    @Query(value = "SELECT mcp FROM ModelControlPanel mcp ")
    public Optional<List<ModelControlPanel>> findAllEnable();

    @Query(value = "SELECT mcp FROM ModelControlPanel mcp WHERE mcp.id =:id")
    public Optional<ModelControlPanel> findByIdEnable(Long id);

    @Query(value = "SELECT mcp FROM ModelControlPanel mcp WHERE mcp.modelDevelopmentPlan.id =:id")
    public Optional<List<ModelControlPanel>> findByIdDev(Long id);
}
