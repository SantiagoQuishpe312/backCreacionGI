package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
@Entity
@Table(name = "UZITGRESEARCH_PROJEC", schema = "UTIC")
public class ModelResearchProjec{

    @Id
    @Column(name = "UZITGRESEARCH_PROJEC_ID")
    @GeneratedValue(generator = "UZITGRESEARCH_PROJEC_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGRESEARCH_PROJEC_Sequence", sequenceName = "UZISGRESEARCH_PROJEC")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "UZITGACTIVITY_REPORT_ID", nullable = false)
    private ModelActivityReport modelActivityReport;

    @Column(name = "UZITGRESEARCH_PROJEC_TITLE", length = 500)
    private String title;

    @Column(name = "UZITGRESEARCH_PROJEC_FINANCE_E", length = 500)
    private String financeEntity;

    @Column(name = "UZITGRESEARCH_PROJEC_COLLABORA", length = 500)
    private String collaboratingInstitution;

    @Column(name = "UZITGRESEARCH_PROJEC_HOURS")
    private Integer hours;

    @Column(name = "UZITGRESEARCH_PROJEC_MINUTES")
    private Integer minutes;

    @Column(name = "UZITGRESEARCH_PROJEC_BUDGET", precision = 12, scale = 2)
    private BigDecimal budget;

    @Column(name = "UZITGRESEARCH_PROJEC_RESPONSIB", length = 500)
    private String responsible;

    @Column(name = "UZITGRESEARCH_PROJEC_PARTICIPA")
    private String participants;

    @Column(name = "UZITGRESEARCH_PROJEC_TYPE", length = 1000)
    private String type;

    @Column(name = "UZITGRESEARCH_PROJEC_STATE", length = 20)
    private String state;

    @Column(name = "UZITGRESEARCH_PROJEC_USER_CREA", length = 50)
    private String userCreate;

    @Column(name = "UZITGRESEARCH_PROJEC_USER_MODI", length = 50)
    private String userModificate;

    @Column(name = "UZITGRESEARCH_PROJEC_DATE_CREA")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date dateCreate;

    @Column(name = "UZITGRESEARCH_PROJEC_DATE_MODI")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date dateModificate;

}
