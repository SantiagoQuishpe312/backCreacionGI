package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "UZITGINV_GROUP", schema = "UTIC")
public class ModelInvGroup {

    @Id
    @GeneratedValue(generator = "UZITGINV_GROUP_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGINV_GROUP_Sequence", sequenceName = "UZISGINV_GROUP")
    @Column(name = "UZITGINV_GROUP_ID")
    private Long id;

    @Column(name = "UZITGINV_GROUP_NAME", nullable = false)
    private String name;

    @Column(name = "UZITGINV_GROUP_STATE", nullable = false)
    private String state;

    @Column(name = "UZITGINV_GROUP_ACRONYM")
    private String acronym;

    @Column(name = "UZITGINV_GROUP_PROCESS")
    private String process;


    @Column(name = "UZITGINV_GROUP_USER_CREATE")
    private String userCreate;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UZITGINV_GROUP_DATE_CREATE")
    private Date dateCreate;

    @Column(name = "UZITGINV_GROUP_USER_MODIFICATE")
    private String userModificate;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UZITGINV_GROUP_DATE_MODIFICATE")
    private Date dateModificate;

    @Column(name = "UZITGINV_GROUP_MISSION")
    private String mission;

    @Column(name = "UZITGINV_GROUP_VISION")
    private String vision;

    @Column(name = "UZITGINV_GROUP_DEPARTMENT")
    private String department;

    @OneToMany(mappedBy = "modelInvGroup", cascade = CascadeType.ALL)
    private List<ModelCreationReq> modelCreationReq;
    @OneToMany(mappedBy = "modelInvGroup", cascade = CascadeType.ALL)
    private List<ModelInvMember> modelInvMember;
    @OneToMany(mappedBy = "modelInvGroup")
    private List<ModelDevelopmentPlan> modelDevelopmentPlan;
    @OneToMany(mappedBy = "modelInvGroup",cascade = CascadeType.ALL)
    private List<ModelLink> modelLink;
    @OneToMany(mappedBy = "modelInvGroup")
    private List<ModelAnnexes> modelAnnexes;

    @OneToMany(mappedBy = "modelInvGroup")
    private List<ModelRelevanceReport> modelRelevanceReport;

    @OneToMany(mappedBy = "modelInvGroup")
    private List<ModelInvGroup_Area> modelInvGroupArea;

    @OneToMany(mappedBy = "modelInvGroup")
    private List<ModelInvGroup_Line> modelInvGroupLine;

    @OneToMany(mappedBy = "modelInvGroup")
    private List<ModelInvGroup_AcademicDomains> modelInvGroupAcademicDomains;

    @OneToMany(mappedBy = "modelInvGroup")
    private List<ModelActivityReport> modelActivityReport;

    @OneToMany(mappedBy = "modelInvGroup")
    private List<ModelAssetsReport> modelAssetsReport;

    @OneToMany(mappedBy = "modelInvGroup")
    private List<ModelAnnualOperativePlan> modelAnnualOperativePlan;
    @ManyToOne
    @JoinColumn(name = "UZITGUSER_ID", nullable = false)
    private ModelUser modelUser;


}
