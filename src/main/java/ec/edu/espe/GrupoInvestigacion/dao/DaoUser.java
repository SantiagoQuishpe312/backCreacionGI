package ec.edu.espe.GrupoInvestigacion.dao;

import ec.edu.espe.GrupoInvestigacion.model.ModelUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
public interface DaoUser extends CrudRepository<ModelUser,Long> {
    @Query(value = "SELECT u FROM ModelUser u ")
    public Optional<List<ModelUser>> findAllEnable();

    @Query(value = "SELECT u FROM ModelUser u WHERE u.idUser = :id")
    public Optional<ModelUser> findByIdEnable(Long id);

    @Query(value = "SELECT u FROM ModelUser u WHERE u.user = :user")
    public Optional<ModelUser> findByUser(@Param("user") String user);


}
