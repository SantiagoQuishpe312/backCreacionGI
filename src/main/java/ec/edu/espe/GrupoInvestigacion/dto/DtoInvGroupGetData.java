package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.List;
@Data
public class DtoInvGroupGetData {
 private DtoInvGroup InvGroup;
 private List<DtoUser> Users;
    private List <DtoLine> Line;
    private List<DtoArea> Area;
    private List<DtoAcademicDomain> AcademicDomain;
    private DtoUser Coordinador;


}
