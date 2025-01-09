package ec.edu.espe.GrupoInvestigacion.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class ModelComplianceId implements Serializable {
    @ManyToOne
    @JoinColumn(name="UZITGACTIVITY_REPORT_ID", insertable = false,updatable = false)
    private ModelActivityReport modelActivityReport;

    @ManyToOne
    @JoinColumn(name="UZITGSPECIFIC_OBJ_ID ", insertable = false,updatable = false)
    private ModelSpecificObjectives modelSpecificObjectives;
}
