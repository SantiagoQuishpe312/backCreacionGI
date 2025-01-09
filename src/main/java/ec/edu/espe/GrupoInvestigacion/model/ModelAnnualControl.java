package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "UZITGANNUAL_CONTROL")
public class ModelAnnualControl implements Serializable {
    @EmbeddedId
    private  ModelAnnualControlId id;
    @Column(name = "UZITGANNUAL_CONTROL_ANNUAL_GOA")
    private String annualGoal;
    @Column(name = "UZITGANNUAL_CONTROL_PRODUCT", length = 300)
    private String product;

    @Column(name = "UZITGANNUAL_CONTROL_FINANCING", length = 300)
    private String financing;

    @Column(name = "UZITGANNUAL_CONTROL_AMMOUNT", precision = 8, scale = 2)
    private BigDecimal amount;

    @Column(name = "UZITGANNUAL_CONTROL_PRESUPUEST", length = 20)
    private String budget;

    @Column(name = "UZITGANNUAL_CONTROL_PERIDICITY", length = 200)
    private String periodicity;

    @Column(name = "UZITGANNUAL_CONTROL_START_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "UZITGANNUAL_CONTROL_END_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.DATE)
    private Date endDate;

    @Column(name = "UZITGANNUAL_CONTROL_MEANS_VERI", length = 1000)
    private String meansOfVerification;

    @Column(name = "UZITGANNUAL_CONTROL_CERTIFIED_", precision = 8, scale = 2)
    private BigDecimal certifiedAmount;

    @Column(name = "UZITGANNUAL_CONTROL_COMMITTED_", precision = 8, scale = 2)
    private BigDecimal committedAmount;

    @Column(name = "UZITGANNUAL_CONTROL_ACCRUED_VA", precision = 8, scale = 2)
    private BigDecimal accruedValue;

    @Column(name = "UZITGANNUAL_CONTROL_CERTIFICAT", length = 20)
    private String certificate;

    @Column(name = "UZITGANNUAL_CONTROL_FOLLOW_UP_")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.DATE)
    private Date followUpDate;

    @Column(name = "UZITGANNUAL_CONTROL_AVAILABLE_", precision = 8, scale = 2)
    private BigDecimal availableAmount;

    @Column(name = "UZITGANNUAL_CONTROL_COMPLIANCE", precision = 6, scale = 2)
    private BigDecimal compliance;

    @Column(name = "UZITGANNUAL_CONTROL_USER_CREAT", length = 50)
    private String userCreate;

    @Column(name = "UZITGANNUAL_CONTROL_DATE_CREAT")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGANNUAL_CONTROL_USER_MODIF", length = 50)
    private String userModificate;

    @Column(name = "UZITGANNUAL_CONTROL_DATE_MODIF")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @ManyToOne
    @JoinColumn(name = "UZITGCONTROLPANEL_ID", insertable = false,updatable = false)
    private ModelControlPanel modelControlPanel;

    @ManyToOne
    @JoinColumn(name = "UZITGZANNUAL_OP_PLAN_ID",insertable = false,updatable = false)
    private  ModelAnnualOperativePlan modelAnnualOperativePlan;
}
