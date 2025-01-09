package ec.edu.espe.GrupoInvestigacion.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class ModelAnnualControlId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "UZITGCONTROLPANEL_ID", insertable = false,updatable = false)
    private ModelControlPanel modelControlPanel;

    @ManyToOne
    @JoinColumn(name = "UZITGZANNUAL_OP_PLAN_ID",insertable = false,updatable = false)
    private  ModelAnnualOperativePlan modelAnnualOperativePlan;
}
