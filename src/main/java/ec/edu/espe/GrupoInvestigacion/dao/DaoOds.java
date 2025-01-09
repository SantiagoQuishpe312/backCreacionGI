package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelOds;
import ec.edu.espe.GrupoInvestigacion.model.ModelStrategies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DaoOds extends CrudRepository<ModelOds,Long> {
    @Query(value ="SELECT ods FROM ModelOds ods"  )
    public Optional<List<ModelOds>> findAllEnable();

    @Query(value ="SELECT ods FROM ModelOds ods WHERE ods.id=:id"  )
    public Optional<ModelOds> findByIdEnable(Long id);

    @Query(value = "SELECT ods FROM ModelOds ods JOIN ModelObj_Strategies_ODS oso on ods.id = oso.modelOds.id WHERE oso.modelSpecificObjectives.id= :id")
    Optional<List<ModelOds>>findBySpecificObj(@Param("id") Long id);}
