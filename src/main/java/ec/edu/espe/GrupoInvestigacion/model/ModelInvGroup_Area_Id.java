package ec.edu.espe.GrupoInvestigacion.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Embeddable
public class ModelInvGroup_Area_Id implements Serializable {
    @ManyToOne
    @JoinColumn(name = "UZITGINV_GROUP_ID", insertable = false, updatable = false)
    private ModelInvGroup modelInvGroup;
    @ManyToOne
    @JoinColumn(name = "UZITGAREA_ID", insertable = false, updatable = false)
    private ModelArea modelArea;

}
