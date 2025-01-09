package ec.edu.espe.GrupoInvestigacion.dao;


import ec.edu.espe.GrupoInvestigacion.model.ModelArea;
import ec.edu.espe.GrupoInvestigacion.model.ModelInvGroup_Area;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DaoInvGroup_Area extends CrudRepository<ModelInvGroup_Area, Long> {
    @Query(value = "SELECT a FROM ModelInvGroup_Area a")
    public Optional<List<ModelInvGroup_Area>> findAllEnable();

    @Query(value = "SELECT a FROM ModelInvGroup_Area a WHERE a.modelInvGroup.id =:id")
    public Optional<List<ModelInvGroup_Area>> findByIdEnable(Long id);

    @Query(value="SELECT a.modelArea FROM  ModelInvGroup_Area a WHERE a.modelInvGroup.id=:id")
    public Optional<List<ModelArea>> findArea(Long id);
    @Query(value = "SELECT a FROM ModelInvGroup_Area a WHERE a.modelInvGroup.id =:id and a.modelArea.id=:idArea")
    public Optional<ModelInvGroup_Area> findByIds(Long id,Long idArea);
}
