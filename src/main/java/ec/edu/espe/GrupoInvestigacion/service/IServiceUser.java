package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoUser;
import java.util.List;

public interface IServiceUser {

    public List<DtoUser> findAll();

    public DtoUser find(Long id);
    public DtoUser findByUser(String user);
    Long save (DtoUser dtoUser);
}

