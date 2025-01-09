package ec.edu.espe.GrupoInvestigacion.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "UZITGDEVELOPMENT_PLAN", schema = "UTIC")
public class ModelDevelopmentPlan {

    @Id
    @GeneratedValue(generator = "UZITGDEVELOPMENT_PLAN_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGDEVELOPMENT_PLAN_Sequence", sequenceName = "UZISGDEVELOPMENT_PLAN")
    @Column(name = "UZITGDEVELOPMENT_PLAN_ID")
    private Long id;

    @Column(name = "UZITGDEVELOPMENT_PLAN_CONTEXT")
    private String context;
    @Column(name = "UZITGDEVELOPMENT_PLAN_SCOPE")
    private String scope;
    @Column(name = "UZITGDEVELOPMENT_PLAN_GENERAL_")
    private String generalObj;

    @Column(name = "UZITGDEVELOPMENT_PLAN_TYPE")
    private Character type;

    @Column(name = "UZITGDEVELOPMENT_PLAN_STATE")
    private Character state;
    @Column(name = "UZITGDEVELOPMENT_PLAN_USER_CRE")
    private String userCreate;


    @Column(name = "UZITGDEVELOPMENT_PLAN_DATE_CRE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGDEVELOPMENT_PLAN_USER_MOD")
    private String userModificate;

    @Column(name = "UZITGDEVELOPMENT_PLAN_DATE_MOD")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @ManyToOne
    @JoinColumn(name = "UZITGINV_GROUP_ID")
    private ModelInvGroup modelInvGroup;
    @ManyToOne
    @JoinColumn(name = "UZITGINST_STRATEGIC_OBJ_ID")
    private  ModelInstStrategicObj modelInstStrategicObj;

    @OneToMany(mappedBy = "modelDevelopmentPlan")
    private List<ModelControlPanel> modelControlPanel;
    @OneToMany(mappedBy = "modelDevelopmentPlan")
    private List<ModelDeveNati> modelDeveNati;
    @OneToMany(mappedBy = "modelDevelopmentPlan")
    private List<ModelDeveUppe> modelDeveUppe;
    @OneToMany(mappedBy = "modelDevelopmentPlan")
    private List<ModelDeveLega>modelDeveLega;

}