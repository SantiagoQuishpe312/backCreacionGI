package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelInvGroup;
import ec.edu.espe.GrupoInvestigacion.model.ModelUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DaoInvGroup extends CrudRepository<ModelInvGroup, Long> {
    @Query(value = "SELECT mig FROM ModelInvGroup mig")
    public Optional<List<ModelInvGroup>> findAllEnable();

    @Query(value = "SELECT mig FROM ModelInvGroup mig WHERE mig.id =:id")
    public Optional<ModelInvGroup> findByIdEnable(Long id);
    @Query(value = "SELECT mig FROM ModelInvGroup mig WHERE mig.modelUser.idUser =:id")
    public Optional<ModelInvGroup> findByIdUser(Long id);



}
