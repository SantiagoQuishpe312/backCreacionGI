package ec.edu.espe.GrupoInvestigacion.dao;


import ec.edu.espe.GrupoInvestigacion.model.ModelCongress;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DaoCongress extends CrudRepository<ModelCongress, Long> {
    @Query(value = "SELECT c FROM ModelCongress c")
    public Optional<List<ModelCongress>> findAllEnable();
    @Query(value = "SELECT c FROM ModelCongress c WHERE c.id =:id")
    public Optional<ModelCongress> findByIdEnable(Long id);


}
