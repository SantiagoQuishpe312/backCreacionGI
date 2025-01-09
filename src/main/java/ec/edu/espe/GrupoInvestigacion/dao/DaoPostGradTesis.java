package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelPostGradTesis;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DaoPostGradTesis extends CrudRepository<ModelPostGradTesis, Long> {
    @Query(value = "SELECT t FROM ModelPostGradTesis t")
    Optional<List<ModelPostGradTesis>> findAllEnable();

    @Query(value = "SELECT t FROM ModelPostGradTesis t WHERE t.id = :id")
    Optional<ModelPostGradTesis> findByIdEnable(Long id);
}
