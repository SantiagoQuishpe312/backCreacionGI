package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelArea;
import ec.edu.espe.GrupoInvestigacion.model.ModelLine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DaoLine extends CrudRepository<ModelLine, Long> {
    @Query(value = "SELECT ml FROM ModelLine ml")
    public Optional<List<ModelLine>> findAllEnable();

    @Query(value = "SELECT ml FROM ModelLine ml WHERE ml.id = :id")
    Optional<ModelLine> findById(@Param("id") Long id);

    @Query(value = "SELECT ml.modelArea FROM ModelLine ml WHERE ml.id = :id")
    Optional<ModelArea> findLineAreaById(@Param("id") Long id);
    @Query(value = "SELECT ml.modelArea FROM ModelLine ml")
    public Optional<List<ModelLine>> findAllLinesAreas();

    @Query(value = "SELECT ml FROM ModelLine ml WHERE ml.modelArea.id = :id")
    public Optional<List<ModelLine>> findLineByArea(@Param("id") Long id);
}
