package ec.edu.espe.GrupoInvestigacion.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class ModelInvGroup_AcademicDomains_Id implements Serializable {
    @ManyToOne
    @JoinColumn(name = "UZITGINV_GROUP_ID", insertable = false, updatable = false)
    private ModelInvGroup modelInvGroup;
    @ManyToOne
    @JoinColumn(name = "UZITGACADEMIC_DOM_ID", insertable = false, updatable = false)
    private ModelAcademicDomain modelAcademicDomain;

}
