package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelAnnexes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DaoAnnexes extends CrudRepository<ModelAnnexes, Long> {

    @Query(value = "SELECT ma FROM ModelAnnexes ma ")
    public Optional<List<ModelAnnexes>> findAllEnable();

    @Query(value = "SELECT ma FROM ModelAnnexes ma WHERE ma.id =:id")
    public Optional<ModelAnnexes> findByIdEnable(Long id);

    @Query(value = "SELECT ma FROM ModelAnnexes ma WHERE ma.name LIKE :tipo AND ma.modelInvGroup.id = :id")
    public Optional<List<ModelAnnexes>> findByKeywordAndId(@Param("tipo") String tipo, @Param("id") Long id);

}
