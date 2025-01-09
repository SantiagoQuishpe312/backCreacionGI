package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "UZITGCREATION_REQ", schema = "UTIC")
public class ModelCreationReq {
    @Id
    @GeneratedValue(generator = "UZITGCREATION_REQ_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGCREATION_REQ_Sequence", sequenceName = "UZISGCREATION_REQ")
    @Column(name = "UZITGCREATION_REQ_ID")
    private Long id;

    @Column(name="UZITGCREATION_REQ_STRATEGIC_AL")
    private String strategicAlignment;

    @Column(name = "UZITGCREATION_REQ_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGCREATION_REQ_STATE")
    private Character state;
    @Column(name = "UZITGCREATION_REQ_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGCREATION_REQ_USER_MODIFIC")
    private String userModificate;

    @Column(name = "UZITGCREATION_REQ_DATE_MODIFIC")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @ManyToOne
    @JoinColumn(name = "UZITGINV_GROUP_ID", nullable = false)
    private ModelInvGroup modelInvGroup;

}
