package ec.edu.espe.GrupoInvestigacion.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
@Data
@Embeddable
public class ModelDeveUppeId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "UZITGDEVELOPMENT_PLAN_ID", insertable = false,updatable = false)
    private ModelDevelopmentPlan modelDevelopmentPlan;

    @ManyToOne
    @JoinColumn(name = "UZITGUPPER_LEVEL_PLAN_ID", insertable = false,updatable = false)
    private ModelUpperLevelPlan modelUpperLevelPlan;
}
