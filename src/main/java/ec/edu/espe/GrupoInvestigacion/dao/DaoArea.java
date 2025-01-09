package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelArea;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DaoArea extends CrudRepository<ModelArea, Long> {

    @Query("SELECT a FROM ModelArea a WHERE a.id = :id")
    Optional<ModelArea> findById(@Param("id") Long id);

    @Query("SELECT a FROM ModelArea a")
    Optional<List<ModelArea>> findAllAreas();

    @Query("SELECT a FROM ModelArea a WHERE a.name = :name")
    Optional<ModelArea> findByName(@Param("name") String name);
}
