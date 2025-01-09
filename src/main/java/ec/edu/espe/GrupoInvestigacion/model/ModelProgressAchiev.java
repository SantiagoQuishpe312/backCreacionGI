package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "UZITGPROGRESS_ACHIEV", schema = "UTIC")
public class ModelProgressAchiev {
    @Id
    @Column(name = "UZITGPROGRESS_ACHIEV_ID")
    @GeneratedValue(generator = "UZITGPROGRESS_ACHIEV_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGPROGRESS_ACHIEV_Sequence", sequenceName = "UZISGPROGRESS_ACHIEV")
    private Long id;

    @Column(name = "UZITGPROGRESS_ACHIEV_DATE", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.DATE)
    private Date achievementDate;

    @Column(name = "UZITGPROGRESS_ACHIEV_ACHIEVEME", nullable = false)
    private String achievements;

    @Column(name = "UZITGPROGRESS_ACHIEV_DESCRIPTI", nullable = false)
    private String description;

    @Column(name = "UZITGPROGRESS_ACHIEV_USER_CREA")
    private String userCreate;

    @Column(name = "UZITGPROGRESS_ACHIEV_DATE_CREA")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGPROGRESS_ACHIEV_USER_MODI")
    private String userModificate;

    @Column(name = "UZITGPROGRESS_ACHIEV_DATE_MODI")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @ManyToOne
    @JoinColumn(name = "UZITGGROUP_REG_FORM_ID", nullable = false)
    private ModelGroupRegForm modelGroupRegForm;

}
