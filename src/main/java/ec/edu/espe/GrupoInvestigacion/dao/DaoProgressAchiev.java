package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelProgressAchiev;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DaoProgressAchiev extends CrudRepository<ModelProgressAchiev, Long> {
    @Query(value = "SELECT mpa FROM ModelProgressAchiev mpa ")
    public Optional<List<ModelProgressAchiev>> findAllEnable();

    @Query(value = "SELECT mpa FROM ModelProgressAchiev mpa WHERE mpa.id =:id")
    public Optional<ModelProgressAchiev> findByIdEnable(Long id);
}
