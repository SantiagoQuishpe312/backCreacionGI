package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.List;

@Data
public class DtoReqGetAcademicDom {
    private DtoCreationReq Creacion;
    private List<DtoAcademicDomain> Dominio;

}
