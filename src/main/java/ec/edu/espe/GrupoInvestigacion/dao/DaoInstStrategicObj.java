package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelInstStrategicObj;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DaoInstStrategicObj extends CrudRepository<ModelInstStrategicObj,Long> {
    @Query("SELECT iso FROM ModelInstStrategicObj iso")
    public Optional<List<ModelInstStrategicObj>> findAllObj();

    @Query("SELECT iso FROM ModelInstStrategicObj iso WHERE iso.id=:id")
    public Optional<ModelInstStrategicObj> findByIdObj(@Param("id") Long id);



}
