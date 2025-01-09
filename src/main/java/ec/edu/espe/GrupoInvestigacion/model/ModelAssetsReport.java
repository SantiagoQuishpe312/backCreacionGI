package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "UZITGASSETS_REPORT", schema = "UTIC")
public class ModelAssetsReport {
    @Id
    @GeneratedValue(generator = "UZITGASSETS_REPORT_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGASSETS_REPORT_Sequence", sequenceName = "UZISGASSETS_REPORT")
    @Column(name = "UZITGASSETS_REPORT_ID")
    private Long id;

    @Column(name = "UZITGASSETS_REPORT_OBJ", nullable = false)
    private String obj;

    @Column(name = "UZITGASSETS_REPORT_CONTEXT", nullable = false)
    private String context;

    @Column(name = "UZITGASSETS_REPORT_USE")
    private String useState;

    @Column(name = " UZITGASSETS_REPORT_GENERAL_CON", nullable = false)
    private String generalCondition;

    @Column(name = "UZITGASSETS_REPORT_RELEVANCE")
    private String relevance;

    @Column(name = "UZITGASSETS_REPORT_CONCLUSION")
    private String conclusion;

    @Column(name = "UZITGASSETS_REPORT_USER_CREATE")
    private String userCreate;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UZITGASSETS_REPORT_DATE_CREATE")
    private Date dateCreate;

    @Column(name = "UZITGASSETS_REPORT_USER_MODIFI")
    private String userModificate;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UZITGASSETS_REPORT_DATE_MODIFI")
    private Date dateModificate;

    @ManyToOne
    @JoinColumn(name = "UZITGINV_GROUP", nullable = false)
    private ModelInvGroup modelInvGroup;

    @OneToMany(mappedBy = "modelAssetsReport")
    private List<ModelAssets_Details> modelAssetsDetails;

}
