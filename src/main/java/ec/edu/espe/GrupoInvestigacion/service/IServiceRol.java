package ec.edu.espe.GrupoInvestigacion.service;
import ec.edu.espe.GrupoInvestigacion.dto.DtoRol;


import java.util.List;
public interface IServiceRol {
    public List<DtoRol> findAll();

    public DtoRol find(Long id);

}
