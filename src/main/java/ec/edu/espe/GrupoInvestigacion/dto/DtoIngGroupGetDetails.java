package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.List;

@Data
public class DtoIngGroupGetDetails {
    private DtoInvGroup GrupoInvestigacion;
    private List<DtoLine> Lineas;
    private List<DtoArea> Areas;
}
