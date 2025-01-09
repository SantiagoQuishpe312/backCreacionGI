package ec.edu.espe.GrupoInvestigacion.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "UZITGBUDGET_EXECUTE",schema = "UTIC")
public class ModelBudgetExecute {
    @Id
    @GeneratedValue(generator = "UZITGBUDGET_EXECUTE_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGBUDGET_EXECUTE_Sequence", sequenceName = "UZISGBUDGET_EXECUTE")
    @Column(name = "UZITGBUDGET_EXECUTE_ID")
    private Long id;

    @Column(name = "UZITGBUDGET_EXECUTE_ACTIVITY")
    private String activity;

    @Column(name = "UZITGBUDGET_EXECUTE_BUDGET_ITE")
    private String budgetItem;

    @Column(name = "UZITGBUDGET_EXECUTE_ASSIGNED_V",precision = 10,scale = 2)
    private BigDecimal assignedValue;

    @Column(name = "UZITGBUDGET_EXECUTE_COMMITED_V",precision = 10,scale = 2)
    private BigDecimal committedValue;

    @Column(name = "UZITGBUDGET_EXECUTE_ACCRUED_VA",precision = 10,scale = 2)
    private BigDecimal accruedValue;

    @Column(name = "UZITGBUDGET_EXECUTE_ACQUIRED_S")
    private String acquiredStatus;

    @Column(name = "UZITGBUDGET_EXECUTE_USER_CREAT")
    private String userCreate;

    @Column(name = "UZITGBUDGET_EXECUTE_DATE_CREAT")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGBUDGET_EXECUTE_USER_MODIF")
    private String userModificate;

    @Column(name = "UZITGBUDGET_EXECUTE_DATE_MODIF")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @ManyToOne
    @JoinColumn(name = "UZITGACTIVITY_REPORT_ID ", nullable = false)
    private ModelActivityReport modelActivityReport;
}
