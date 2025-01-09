package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoAssets_Details;

import java.util.List;

public interface IServiceAssets_Details {
    public List<DtoAssets_Details> findAll();
    public DtoAssets_Details find(Long id);
    Long save(DtoAssets_Details dtoAssetsDetails);
    void update(DtoAssets_Details dtoAssetsDetails);

}
