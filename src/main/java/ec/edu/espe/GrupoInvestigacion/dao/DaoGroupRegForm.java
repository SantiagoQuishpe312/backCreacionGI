package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelGroupRegForm;
import ec.edu.espe.GrupoInvestigacion.model.ModelUserRol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DaoGroupRegForm extends CrudRepository<ModelGroupRegForm, Long> {
    @Query(value = "SELECT mgrf FROM ModelGroupRegForm mgrf")
    public Optional<List<ModelGroupRegForm>> findAllEnable();

    @Query(value = "SELECT mgrf FROM ModelGroupRegForm mgrf WHERE mgrf.modelInvGroup.id =:id")
    public Optional<ModelGroupRegForm> findByIdEnable(Long id);
}
