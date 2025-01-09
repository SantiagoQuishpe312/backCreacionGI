package ec.edu.espe.GrupoInvestigacion.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DtoUserGetRol {
    private DtoUser Usuario;
    private List<DtoRol> Roles;
}
