package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelMagazines;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DaoMagazines extends CrudRepository<ModelMagazines, Long> {
    @Query(value = "SELECT m FROM ModelMagazines m")
    Optional<List<ModelMagazines>> findAllEnable();

    @Query(value = "SELECT m FROM ModelMagazines m WHERE m.id = :id")
    Optional<ModelMagazines> findByIdEnable(@Param("id") Long id);
}
