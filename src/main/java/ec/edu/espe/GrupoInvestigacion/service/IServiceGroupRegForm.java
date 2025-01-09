package ec.edu.espe.GrupoInvestigacion.service;

import ec.edu.espe.GrupoInvestigacion.dto.DtoGroupRegForm;

import java.sql.DataTruncation;
import java.util.List;

public interface IServiceGroupRegForm {
    public List<DtoGroupRegForm> findAll();

    public DtoGroupRegForm find(Long id);

    Long create(DtoGroupRegForm dtoGroupRegForm);
    void update(DtoGroupRegForm dtoGroupRegForm);
}
