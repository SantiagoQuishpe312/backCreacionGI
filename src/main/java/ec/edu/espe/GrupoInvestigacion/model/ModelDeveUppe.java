package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "UZITGDEVE_UPPE", schema = "UTIC")
public class ModelDeveUppe implements Serializable {
    @EmbeddedId
    private  ModelDeveUppeId id;
    @Column(name = "UZITGDEVE_UPPE_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGDEVE_UPPE_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGDEVE_UPPE_USER_MODIFICATE")
    private String userModificate;

    @Column(name = "UZITGDEVE_UPPE_DATE_MODIFICATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @ManyToOne
    @JoinColumn(name = "UZITGDEVELOPMENT_PLAN_ID", insertable = false,updatable = false)
    private ModelDevelopmentPlan modelDevelopmentPlan;

    @ManyToOne
    @JoinColumn(name = "UZITGUPPER_LEVEL_PLAN_ID", insertable = false,updatable = false)
    private ModelUpperLevelPlan modelUpperLevelPlan;
}
