package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelDeveLega;
import ec.edu.espe.GrupoInvestigacion.model.ModelDevelopmentPlan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DaoDevelopmentPlan extends CrudRepository<ModelDevelopmentPlan, Long> {
    @Query(value = "SELECT mdp FROM ModelDevelopmentPlan mdp ")
    public Optional<List<ModelDevelopmentPlan>> findAllEnable();

    @Query(value = "SELECT mdp FROM ModelDevelopmentPlan mdp WHERE mdp.id =:id")
    public Optional<ModelDevelopmentPlan> findByIdEnable(Long id);

    @Query(value = "SELECT mdp FROM ModelDevelopmentPlan mdp WHERE mdp.modelInvGroup.id=:id")
    public Optional<List<ModelDevelopmentPlan>> findByGroup(Long id);

    @Query(value = "SELECT mdp FROM ModelDevelopmentPlan mdp WHERE mdp.modelInvGroup.id=:id AND mdp.type=:tipo")
    public Optional<List<ModelDevelopmentPlan>> findByGroupAndType(Long id,Character tipo);
    @Query(value = "SELECT mdp FROM ModelDevelopmentPlan mdp WHERE mdp.modelInvGroup.id=:id and mdp.type='c'")
    public Optional<ModelDevelopmentPlan> findByGroupCreation(Long id);

    /*@Query("SELECT dl FROM ModelDeveLega dl " +
            "JOIN dl.modelDevelopmentPlan mdp " +
            "JOIN ModelDeveUppe du ON du.modelDevelopmentPlan.id = mdp.id " +
            "JOIN ModelDeveNati dn ON dn.modelDevelopmentPlan.id = mdp.id " +
            "WHERE mdp.id = :id")
    Optional<List<ModelDeveLega>> findComplete(@Param("id") Long id);*/


}
