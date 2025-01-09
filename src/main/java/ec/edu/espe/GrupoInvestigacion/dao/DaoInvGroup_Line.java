package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelInvGroup_Line;
import ec.edu.espe.GrupoInvestigacion.model.ModelLine;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DaoInvGroup_Line extends CrudRepository<ModelInvGroup_Line, Long> {
    @Query(value = "SELECT ml FROM ModelInvGroup_Line ml ")
    public Optional<List<ModelInvGroup_Line>> findAllEnable();

    @Query(value = "SELECT ml FROM ModelInvGroup_Line ml WHERE ml.modelInvGroup.id =:id")
    public Optional<List<ModelInvGroup_Line>> findByIdEnable(Long id);
    @Query(value="SELECT a.modelLine FROM  ModelInvGroup_Line a WHERE a.modelInvGroup.id=:id")
    public Optional<List<ModelLine>> findLine(Long id);

    @Query(value = "SELECT ml FROM ModelInvGroup_Line ml WHERE ml.modelInvGroup.id =:id and ml.modelLine.id=:idLinea")
    public Optional<ModelInvGroup_Line> findByIds(Long id, Long idLinea);
    @Query(value = "SELECT ml FROM ModelInvGroup_Line ml WHERE ml.modelLine.modelArea.id =:id")
    public Optional<List<ModelInvGroup_Line>> findByArea(Long id);
    @Modifying
    @Query("DELETE FROM ModelInvGroup_Line ml WHERE ml.modelLine.modelArea.id = :id")
    int deleteByArea(@Param("id") Long id);


}
