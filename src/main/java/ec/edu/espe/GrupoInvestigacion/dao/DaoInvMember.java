package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelInvGroup;
import ec.edu.espe.GrupoInvestigacion.model.ModelInvMember;
import ec.edu.espe.GrupoInvestigacion.model.ModelUser;
import ec.edu.espe.GrupoInvestigacion.model.ModelUserRol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DaoInvMember extends CrudRepository<ModelInvMember, Long> {
    @Query(value = "SELECT mig FROM ModelInvMember mig")
    public Optional<List<ModelInvMember>> findAllEnable();

    @Query(value = "SELECT mig FROM ModelInvMember mig WHERE mig.modelUser.idUser =:id")
    public Optional<ModelInvMember> findByIdEnable(Long id);

    @Query(value = "SELECT mig FROM ModelInvMember mig WHERE mig.modelInvGroup.id =:id")
    public Optional<List<ModelInvMember>> findByGroup(Long id);

    @Query(value = "SELECT mig FROM ModelInvMember mig WHERE mig.modelUser.idUser =:idUser and mig.modelInvGroup.id=:idGroup")
    public Optional<ModelInvMember> findByuserGroup(Long idUser, Long idGroup);

    @Query(value = "FROM ModelInvMember mig WHERE mig.modelUser.user =?1")
    public Optional<ModelInvMember> findByUsername(String username);

    @Query(value = "SELECT mig.modelUser FROM ModelInvMember mig WHERE mig.modelInvGroup.id =:id")
    public Optional<List<ModelUser>> findMembersInfoByGroup(Long id);


}

