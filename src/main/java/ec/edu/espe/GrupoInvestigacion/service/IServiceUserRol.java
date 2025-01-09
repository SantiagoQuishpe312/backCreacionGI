package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoUserGetRol;
import ec.edu.espe.GrupoInvestigacion.dto.DtoUserRol;
import java.util.List;
public interface IServiceUserRol {
    public List<DtoUserRol> findAll();

    public List<DtoUserRol> find(Long id);

    public DtoUserGetRol findByUsername(String username);
    void deleteRol(Long userId, Long rolId);
    Long save(DtoUserRol dtoUserRol);
}
