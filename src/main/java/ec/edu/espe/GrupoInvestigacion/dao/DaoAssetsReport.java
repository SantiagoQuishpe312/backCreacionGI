package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelAssetsReport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DaoAssetsReport extends CrudRepository<ModelAssetsReport, Long> {
    @Query("SELECT ar FROM ModelAssetsReport ar")
    public Optional<List<ModelAssetsReport>> findAllEnable();

    @Query("SELECT ar FROM ModelAssetsReport ar WHERE ar.id=:id")
    public Optional<ModelAssetsReport> findByIdEnable(@Param("id")Long id);
}
