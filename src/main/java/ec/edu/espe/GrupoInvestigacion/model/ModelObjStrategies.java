package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = " UZITGOBJ_STRATEGIES", schema = "UTIC")
public class ModelObjStrategies {

    @Id
    @GeneratedValue(generator = "UZITGOBJ_STRATEGIES_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGOBJ_STRATEGIES_Sequence", sequenceName = "UZISGOBJ_STRATEGIES")
    @Column(name = "UZITGOBJ_STRATEGIES_ID")
    private Long id;

    @Column(name = "UZITGOBJ_STRATEGIES_OBJ")
    private String obj;

    @Column(name = "UZITGOBJ_STRATEGIES_STRATEGY")
    private String strategy;

    @Column(name = "UZITGOBJ_STRATEGIES_VERIFIABLE")
    private String verifiable;

    @Column(name = "UZITGOBJ_STRATEGIES_COMPLIANCE", precision = 6, scale = 2)
    private BigDecimal compliance;


    @Column(name = "UZITGOBJ_STRATEGIES_USER_CREAT")
    private String userCreate;

    @Column(name = "UZITGOBJ_STRATEGIES_DATE_CREAT")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGOBJ_STRATEGIES_USER_MODIF")
    private String userModificate;

    @Column(name = "UZITGOBJ_STRATEGIES_DATE_MODIF")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @ManyToOne
    @JoinColumn(name = "UZITGACTIVITY_REPORT_ID", nullable = false)
    private ModelActivityReport modelActivityReport;

}