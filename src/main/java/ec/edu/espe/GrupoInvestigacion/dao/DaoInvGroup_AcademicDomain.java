package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelAcademicDomain;
import ec.edu.espe.GrupoInvestigacion.model.ModelInvGroup_AcademicDomains;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface DaoInvGroup_AcademicDomain extends CrudRepository<ModelInvGroup_AcademicDomains, Long>  {
    @Query(value = "SELECT a FROM ModelInvGroup_AcademicDomains a")
    public Optional<List<ModelInvGroup_AcademicDomains>> findAllEnable();

    @Query(value = "SELECT a FROM ModelInvGroup_AcademicDomains a WHERE a.modelInvGroup.id =:id")
    public Optional<List<ModelInvGroup_AcademicDomains>> findByIdEnable(Long id);

    @Query(value="SELECT a.modelAcademicDomain FROM  ModelInvGroup_AcademicDomains a WHERE a.modelInvGroup.id=:id")
    public Optional<List<ModelAcademicDomain>> findAcademicDomain(Long id);

    @Query(value = "SELECT a FROM ModelInvGroup_AcademicDomains a WHERE a.modelInvGroup.id =:id and a.modelAcademicDomain.id=:idAcad")
    public Optional<ModelInvGroup_AcademicDomains> findByIds(Long id, Long idAcad);
}
