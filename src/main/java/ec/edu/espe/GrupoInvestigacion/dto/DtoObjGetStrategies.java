package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.List;
@Data
public class DtoObjGetStrategies {
    private DtoSpecificObjectives Obj;
    private List<DtoOds> Ods;
    private List<DtoStrategies> Strategies;

}
