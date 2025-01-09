package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelCreationReq;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DaoCreationReq extends CrudRepository<ModelCreationReq, Long> {
    @Query(value = "SELECT mcr FROM ModelCreationReq mcr")
    public Optional<List<ModelCreationReq>> findAllEnable();

    @Query(value = "SELECT mcr FROM ModelCreationReq mcr WHERE mcr.id =:id")
    public Optional<ModelCreationReq> findByIdEnable(Long id);
    @Query(value = "SELECT mcr FROM ModelCreationReq mcr WHERE mcr.modelInvGroup.id =:id")
    public Optional<ModelCreationReq> findByGroup(Long id);

   // @Query(value = "SELECT mcr FROM ModelCreationReq mcr where mcr.modelInvGroup.id=:id")

}
