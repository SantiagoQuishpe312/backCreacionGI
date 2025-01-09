package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelAssets_Details;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DaoAssets_Details  extends CrudRepository<ModelAssets_Details,Long> {
    @Query("SELECT ad FROM ModelAssets_Details ad ")
    public Optional<List<ModelAssets_Details>> findAllEnable();

    @Query("SELECT ad FROM ModelAssets_Details ad WHERE ad.id=:id")
    public Optional<ModelAssets_Details> findByIdEnable(@Param("id") Long id);
}
