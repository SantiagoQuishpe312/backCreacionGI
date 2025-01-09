package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelDegreeTesis;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DaoDegreeTesis extends CrudRepository<ModelDegreeTesis, Long>{
    @Query(value = "SELECT dt FROM ModelDegreeTesis dt")
    public Optional<List<ModelDegreeTesis>> findAllEnable();
    @Query(value = "SELECT dt FROM ModelDegreeTesis dt WHERE dt.id =:id")
    public Optional<ModelDegreeTesis> findByIdEnable(Long id);



}
