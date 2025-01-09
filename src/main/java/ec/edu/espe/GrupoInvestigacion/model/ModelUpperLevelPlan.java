package ec.edu.espe.GrupoInvestigacion.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "UZITGUPPER_LEVEL_PLAN",schema = "UTIC")
public class ModelUpperLevelPlan {
    @Id
    @GeneratedValue(generator = "UZITGUPPER_LEVEL_PLAN_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGUPPER_LEVEL_PLAN_Sequence", sequenceName = "UZISGUPPER_LEVEL_PLAN")
    @Column(name = "UZITGUPPER_LEVEL_PLAN_ID")
    private Long id;
    @Column(name = "UZITGUPPER_LEVEL_PLAN_NAME")
    private String name;

    @Column(name = "UZITGUPPER_LEVEL_PLAN_STATE")
    private Boolean state;

    @Column(name = "UZITGUPPER_LEVEL_PLAN_USER_CRE")
    private String userCreate;

    @Column(name = "UZITGUPPER_LEVEL_PLAN_DATE_CRE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGUPPER_LEVEL_PLAN_USER_MOD")
    private String userModificate;

    @Column(name = "UZITGUPPER_LEVEL_PLAN_DATE_MOD")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @OneToMany(mappedBy = "modelUpperLevelPlan")
    private List<ModelDeveUppe> modelDeveUppe;
}
