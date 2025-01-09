package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoAnnexes;
import ec.edu.espe.GrupoInvestigacion.model.ModelAnnexes;

import java.util.List;

public interface IServiceAnnexes {

    public List<DtoAnnexes> findAll();
    public DtoAnnexes find(Long id);
    Long create(DtoAnnexes dtoAnnexes);
    void update(DtoAnnexes dtoAnnexes);
    List<DtoAnnexes> findBar(Long id, String tipo);
}
