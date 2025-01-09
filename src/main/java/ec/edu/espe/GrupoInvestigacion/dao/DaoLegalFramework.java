package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelLegalFramework;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DaoLegalFramework extends CrudRepository<ModelLegalFramework, Long> {
    @Query(value = "SELECT lf FROM ModelLegalFramework lf")
    public Optional<List<ModelLegalFramework>> findAllEnable();
    @Query(value = "SELECT lf FROM ModelLegalFramework lf WHERE lf.id = :id")
    Optional<ModelLegalFramework> findByIdEnable(@Param("id") Long id);
}
