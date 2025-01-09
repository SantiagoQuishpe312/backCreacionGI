package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelAcademicDomain;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DaoAcademicDomain extends CrudRepository<ModelAcademicDomain, Long> {

    @Query("SELECT mad FROM ModelAcademicDomain mad WHERE mad.id = :id")
    public Optional<ModelAcademicDomain> findById(@Param("id") Long id);

    @Query("SELECT mad FROM ModelAcademicDomain mad")
    public Optional<List<ModelAcademicDomain>> findAllAcademicDomains();

    @Query("SELECT mad FROM ModelAcademicDomain mad WHERE mad.name = :name")
    public Optional<ModelAcademicDomain> findByName(@Param("name") String name);

}
