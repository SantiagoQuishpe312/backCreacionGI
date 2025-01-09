package ec.edu.espe.GrupoInvestigacion.model;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class ModelDeveLegaId implements Serializable{
    @ManyToOne
    @JoinColumn(name = "UZITGDEVELOPMENT_PLAN_ID", insertable = false,updatable = false)
    private ModelDevelopmentPlan modelDevelopmentPlan;

    @ManyToOne
    @JoinColumn(name = "UZITGLEGAL_FRAMEWORK_ID", insertable = false,updatable = false)
    private ModelLegalFramework modelLegalFramework;

}
