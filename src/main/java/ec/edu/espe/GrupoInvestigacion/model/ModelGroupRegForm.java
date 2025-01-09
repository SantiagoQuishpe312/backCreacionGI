package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "UZITGGROUP_REG_FORM", schema = "UTIC")
public class ModelGroupRegForm {

        @Id
        @Column(name = "UZITGGROUP_REG_FORM_ID")
        @GeneratedValue(generator = "UZITGGROUP_REG_FORM_Sequence", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGGROUP_REG_FORM_Sequence", sequenceName = "UZISGGROUP_REG_FORM")
        private Long idRegFormId;

        @Column(name = "UZITGGROUP_REG_FORM_RES_NUM", nullable = false)
        private Long resNum;

        @Column(name = "UZITGGROUP_REG_FORM_CHECKCREAT")
        private Boolean checkCreationForm;

        @Column(name = "UZITGGROUP_REG_FORM_CHECK_DEVE")
        private Boolean checkDevPlan;

        @Column(name = "UZITGGROUP_REG_FORM_CHECKSUMMA")
        private Boolean checkSummary;

        @Column(name = "UZITGGROUP_REG_FORM_CHECKCATCE")
        private Boolean checkCatCertificate;

        @Column(name = "UZITGGROUP_REG_FORM_CHECKCURRI")
        private Boolean checkVitae;

        @Column(name = "UZITGGROUP_REG_FORM_CHECKMINIU")
        private Boolean checkMiniumTeachers;

        @Column(name = "UZITGGROUP_REG_FORM_CHECKSCIEN")
        private Boolean checkScMerits;

        @Column(name = "UZITGGROUP_REG_FORM_STATE")
        private Character state;

        @Column(name = "UZITGGROUP_REG_FORM_USER_CREAT")
        private String userCreate;

        @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "UZITGGROUP_REG_FORM_DATE_CREAT")
        private Date dateCreate;

        @Column(name = "UZITGGROUP_REG_FORM_USER_MODIF")
        private String userModificate;

        @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "UZITGGROUP_REG_FORM_DATE_MODIF")
        private Date dateModificate;
        @OneToMany(mappedBy = "modelGroupRegForm", cascade = CascadeType.ALL)
        private List<ModelProgressAchiev> modelProgressAchiev;
        @ManyToOne
        @JoinColumn(name = "UZITGINV_GROUP_ID")
        private ModelInvGroup modelInvGroup;


}
