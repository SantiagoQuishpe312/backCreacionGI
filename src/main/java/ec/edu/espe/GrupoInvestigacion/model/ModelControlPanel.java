package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "UZITGCONTROLPANEL", schema = "UTIC")
public class ModelControlPanel {

    @Id
    @GeneratedValue(generator = "UZITGCONTROLPANEL_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGCONTROLPANEL_Sequence", sequenceName = "UZISGCONTROLPANEL")
    @Column(name = "UZITGCONTROLPANEL_ID")
    private Long id;
    @Column(name = "UZITGCONTROLPANEL_ACTIVITY", nullable = false)
    private String activity;

    @Column(name = "UZITGCONTROLPANEL_INDICATOR_NA", nullable = false)
    private String indicatorName;

    @Column(name = "UZITGCONTROLPANEL_INDICATOR_TY")
    private String indicatorType;

    @Column(name = "UZITGCONTROLPANEL_INDICATOR_FO")
    private String indicatorForm;

    @Column(name = "UZITGCONTROLPANEL_INDICATOR_CO")
    private String indicatorCondicional;

    @Column(name = "UZITGCONTROLPANEL_INDICATOR_AC")
    private String indicatorAccumulative;

    @Column(name = "UZITGCONTROLPANEL_GOALS1")
    private BigDecimal goals1;

    @Column(name = "UZITGCONTROLPANEL_GOALS2")
    private BigDecimal goals2;

    @Column(name = "UZITGCONTROLPANEL_GOALS3")
    private BigDecimal goals3;

    @Column(name = "UZITGCONTROLPANEL_GOALS4")
    private BigDecimal goals4;

    @Column(name = "UZITGCONTROLPANEL_FINANCING")
    private BigDecimal financing;

    @Column(name = "UZITGCONTROLPANEL_OBSERVATION", nullable = false)
    private String observation;

    @Column(name = "UZITGCONTROLPANEL_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGCONTROLPANEL_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGCONTROLPANEL_USER_MODIFIC")
    private String userModificate;

    @Column(name = "UZITGCONTROLPANEL_DATE_MODIFIC")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @OneToMany(mappedBy = "modelControlPanel")
    private List<ModelAnnualControl> modelAnnualControl;

    @ManyToOne
    @JoinColumn(name = "UZITGDEVELOPMENT_PLAN_ID", nullable = false)
    private ModelDevelopmentPlan modelDevelopmentPlan;
    @ManyToOne
    @JoinColumn(name = "UZITGSPECIFIC_OBJ_ID ", nullable = false)
    private ModelSpecificObjectives modelSpecificObjectives;

    @ManyToOne
    @JoinColumn(name = "UZITGUSER_ID",nullable = false)
    private ModelUser modelUser;

}
