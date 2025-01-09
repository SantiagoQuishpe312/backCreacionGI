package ec.edu.espe.GrupoInvestigacion.dao;



import ec.edu.espe.GrupoInvestigacion.model.ModelBookChapter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DaoBookChapter extends CrudRepository<ModelBookChapter, Long> {
    @Query(value = "SELECT bc FROM ModelBookChapter bc ")
    public Optional<List<ModelBookChapter>> findAllEnable();
    @Query(value = "SELECT bc FROM ModelBookChapter bc WHERE bc.id =:id")
    public Optional<ModelBookChapter> findByIdEnable(Long id);
}
