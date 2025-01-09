package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelActivityReport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DaoActivityReport extends CrudRepository<ModelActivityReport,Long> {
 @Query("SELECT ar FROM ModelActivityReport ar")
 public Optional<List<ModelActivityReport>> findAllEnable();

 @Query("SELECT ar From ModelActivityReport ar WHERE ar.id=:id")
    public Optional<ModelActivityReport> findByIdEnable(@Param("id") Long id);


    @Query("SELECT ar From ModelActivityReport ar WHERE ar.state=:state")
    public Optional<List<ModelActivityReport>>  findByState(@Param("state") Character state);
}

