package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoBookChapter;

import java.util.List;

public interface IServiceBookChapter {
    public List<DtoBookChapter> findAll();
    public DtoBookChapter find(Long id);
    Long save(DtoBookChapter dtoBookChapter);
    void update(DtoBookChapter dtoBookChapter);

}
