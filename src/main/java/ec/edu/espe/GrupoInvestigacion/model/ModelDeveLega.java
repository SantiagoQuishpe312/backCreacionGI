package ec.edu.espe.GrupoInvestigacion.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@Entity
@Table(name = "UZITGDEVE_LEGA", schema = "UTIC")
public class ModelDeveLega implements Serializable {
    @EmbeddedId
    private ModelDeveLegaId id;
    @Column(name = "UZITGDEVE_LEGA_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGDEVE_LEGA_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGDEVE_LEGA_USER_MODIFICATE")
    private String userModificate;

    @Column(name = "UZITGDEVE_LEGA_DATE_MODIFICATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @ManyToOne
    @JoinColumn(name = "UZITGDEVELOPMENT_PLAN_ID", insertable = false,updatable = false)
    private ModelDevelopmentPlan modelDevelopmentPlan;

    @ManyToOne
    @JoinColumn(name = "UZITGLEGAL_FRAMEWORK_ID", insertable = false,updatable = false)
    private ModelLegalFramework modelLegalFramework;
}
