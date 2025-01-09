package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelObjStrategies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DaoObjStrategies extends CrudRepository<ModelObjStrategies, Long> {
    @Query(value = "SELECT mos FROM ModelObjStrategies mos")
    public Optional<List<ModelObjStrategies>> findAllEnable();

    @Query(value = "SELECT mos FROM ModelObjStrategies mos WHERE mos.id =:id")
    public Optional<ModelObjStrategies> findByIdEnable(Long id);
}
