package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "UZITGACADEMIC_DOM", schema = "UTIC")
public class ModelAcademicDomain {
    @Id
    @GeneratedValue(generator = "UZITGACADEMIC_DOM_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGACADEMIC_DOM_Sequence", sequenceName = "UZISGACADEMIC_DOM")
    @Column(name = "UZITGACADEMIC_DOM_ID")
    private Long id;

    @Column(name = "UZITGACADEMIC_DOM_NAME", nullable = false)
    private String name;

    @Column(name = "UZITGACADEMIC_DOM_STATE", nullable = false)
    private Boolean state;

    @Column(name = "UZITGACADEMIC_DOM_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGACADEMIC_DOM_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGACADEMIC_DOM_USER_MODIFIC")
    private String userModificate;

    @Column(name = "UZITGACADEMIC_DOM_DATE_MODIFIC")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @OneToMany(mappedBy = "modelAcademicDomain")
    private List<ModelInvGroup_AcademicDomains> modelInvGroupAcademicDomains;

}