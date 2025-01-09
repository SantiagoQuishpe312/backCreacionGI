package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelDeveLega;
import ec.edu.espe.GrupoInvestigacion.model.ModelLegalFramework;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DaoDeveLega extends CrudRepository<ModelDeveLega, Long> {
    @Query(value = "SELECT dl FROM ModelDeveLega dl")
    public Optional<List<ModelDeveLega>> findAllEnable();
    @Query(value = "SELECT dl FROM ModelDeveLega dl WHERE dl.modelDevelopmentPlan.id =:id")
    public Optional<List<ModelDeveLega>> findByIdEnable(Long id);

    @Query(value = "SELECT dl.modelLegalFramework FROM ModelDeveLega dl where dl.modelDevelopmentPlan.id=:id")
    public Optional<List<ModelLegalFramework>> findLegalFramework(Long id);

}
