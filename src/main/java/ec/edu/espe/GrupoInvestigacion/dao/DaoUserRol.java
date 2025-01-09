package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelRol;
import ec.edu.espe.GrupoInvestigacion.model.ModelUser;
import ec.edu.espe.GrupoInvestigacion.model.ModelUserRol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;
public interface DaoUserRol extends CrudRepository <ModelUserRol,Long>{
    @Query(value = "SELECT u FROM ModelUserRol u")
    public Optional<List<ModelUserRol>> findAllEnable();

    @Query(value = "SELECT u FROM ModelUserRol u WHERE u.modelUser.idUser = :id")
    public Optional<List<ModelUserRol>>  findByIdEnable(Long id);

    @Query(value = "SELECT u.modelRol FROM ModelUserRol u WHERE u.modelUser.user =?1")
    public Optional<List<ModelRol>> findByUsername(String username);

    @Query(value = "SELECT u FROM ModelUserRol u WHERE u.modelUser.idUser =:idUser and u.modelRol.id=:idRol")
    public Optional<ModelUserRol> findByuserRol(Long idUser,Long idRol);
    //
}
