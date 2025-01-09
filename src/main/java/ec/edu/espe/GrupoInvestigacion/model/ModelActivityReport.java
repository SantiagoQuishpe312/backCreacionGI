package ec.edu.espe.GrupoInvestigacion.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import oracle.sql.CHAR;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "UZITGACTIVITY_REPORT",schema = "UTIC")
public class ModelActivityReport {
    @Id
    @GeneratedValue(generator = "UZITGACTIVITY_REPORT_Sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC",allocationSize = 1,name="UZITGACTIVITY_REPORT_Sequence",sequenceName = "UZISGACTIVITY_REPORT")
    @Column(name = "UZITGACTIVITY_REPORT_ID")
    private Long id;
    @Column(name="UZITGACTIVITY_REPORT_BACKGROUN")
    private String background;

    @Column(name = "UZITGACTIVITY_REPORT_CONCLUSIO")
    private String conclusion;

    @Column(name = "UZITGACTIVITY_REPORT_RECOMENDA")
    private String recommendations;

    @Column(name = "UZITGACTIVITY_REPORT_STATE")
    private Character state;

    @Column(name = "UZITGACTIVITY_REPORT_USER_CREA")
    private String userCreate;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UZITGACTIVITY_REPORT_DATE_CREA")
    private Date dateCreate;

    @Column(name = "UZITGACTIVITY_REPORT_USER_MODI")
    private String userModificate;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UZITGACTIVITY_REPORT_DATE_MODI")
    private Date dateModificate;

    @OneToMany(mappedBy = "modelActivityReport")
    private List<ModelCongress> modelCongress;
    @OneToMany(mappedBy = "modelActivityReport")
    private List<ModelBudgetExecute> modelBudgetExecute;
    @OneToMany(mappedBy = "modelActivityReport")
    private List<ModelMagazines> modelMagazines;
    @OneToMany(mappedBy = "modelActivityReport")
    private List<ModelBookChapter> modelBookChapter;

    @OneToMany(mappedBy = "modelActivityReport")
    private List<ModelDegreeTesis> modelDegreeTesis;
    @OneToMany(mappedBy = "modelActivityReport")
    private List<ModelPostGradTesis> modelPostGradTesis;
    @OneToMany(mappedBy = "modelActivityReport")
    private List<ModelEvents> modelEvents;
    @OneToMany(mappedBy = "modelActivityReport")
    private  List<ModelResearchProjec> modelResearchProjec;

    @OneToMany(mappedBy = "modelActivityReport")
    private List<ModelObjStrategies> modelObjStrategies;
    @OneToMany(mappedBy = "modelActivityReport")
    private List<ModelCompliance> modelCompliance;

    @ManyToOne
    @JoinColumn(name = "UZITGINV_GROUP_ID", nullable = false)
    private ModelInvGroup modelInvGroup;

}
