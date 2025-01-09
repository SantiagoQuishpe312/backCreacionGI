package ec.edu.espe.GrupoInvestigacion.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
@Data
@Embeddable
public class ModelDeveNatiId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "UZITGDEVELOPMENT_PLAN_ID", insertable = false,updatable = false)
    private ModelDevelopmentPlan modelDevelopmentPlan;

    @ManyToOne
    @JoinColumn(name = "UZITGNATIONAL_PLAN_ID", insertable = false,updatable = false)
    private ModelNationalPlan modelNationalPlan;
}
