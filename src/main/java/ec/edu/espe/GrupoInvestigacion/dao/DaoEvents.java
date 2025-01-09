package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelEvents;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DaoEvents extends CrudRepository<ModelEvents, Long> {
    @Query(value = "SELECT e FROM ModelEvents e")
    public Optional<List<ModelEvents>> findAllEnable();
    @Query(value = "SELECT e FROM ModelEvents e WHERE e.id = :id")
    Optional<ModelEvents> findByIdEnable(@Param("id") Long id);
}
