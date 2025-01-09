package ec.edu.espe.GrupoInvestigacion.dao;
import ec.edu.espe.GrupoInvestigacion.model.ModelRol;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;
public interface DaoRol extends CrudRepository<ModelRol,Long>{
    @Query(value = "SELECT u FROM ModelRol u")
    public Optional<List<ModelRol>> findAllRol();

    @Query(value = "SELECT u FROM ModelRol u WHERE u.id = :id")
    public Optional<ModelRol> findByIdRol(Long id);
}
