package ec.edu.espe.GrupoInvestigacion.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "UZITGANNUAL_OP_PLAN", schema = "UTIC")
public class ModelAnnualOperativePlan {
    @Id
    @GeneratedValue(generator = "UZITGANNUAL_OP_PLAN_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGANNUAL_OP_PLAN_Sequence", sequenceName = "UZISGANNUAL_OP_PLAN")
    @Column(name = "UZITGANNUAL_OP_PLAN_ID")
    private Long id;

    @Column(name = "UZITGANNUAL_OP_PLAN_GENERAL_O", nullable = false)
    private String generalObj;

    @Column(name = "UZITGANNUAL_OP_PLAN_USER_CREA")
    private String userCreate;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UZITGANNUAL_OP_PLAN_DATE_CREA")
    private Date dateCreate;

    @Column(name = "UZITGANNUAL_OP_PLAN_USER_MODIF")
    private String userModificate;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UZITGANNUAL_OP_PLAN_DATE_MODIF")
    private Date dateModificate;

    @ManyToOne
    @JoinColumn(name = "UZITGINV_GROUP_ID", nullable = false)
    private ModelInvGroup modelInvGroup;

    @OneToMany(mappedBy = "modelAnnualOperativePlan")
    private List<ModelAnnualControl> modelAnnualControl;
    

}
