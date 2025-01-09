package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.List;

@Data
public class DtoReqGetArea {
    private DtoCreationReq Creacion;
    private List<DtoArea> Area;

}
