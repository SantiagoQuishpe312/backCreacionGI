package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelDeveNati;
import ec.edu.espe.GrupoInvestigacion.model.ModelLegalFramework;
import ec.edu.espe.GrupoInvestigacion.model.ModelNationalPlan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DaoDeveNati extends CrudRepository<ModelDeveNati, Long> {
    @Query(value = "SELECT dn FROM ModelDeveNati dn")
    public Optional<List<ModelDeveNati>> findAllEnable();
    @Query(value = "SELECT dn FROM ModelDeveNati dn WHERE dn.modelDevelopmentPlan.id =:id")
    public Optional<List<ModelDeveNati>> findByIdEnable(Long id);

    @Query(value = "SELECT dl.modelNationalPlan FROM ModelDeveNati dl where dl.modelDevelopmentPlan.id=:id")
    public Optional<List<ModelNationalPlan>> findNationalPlan(Long id);
}
