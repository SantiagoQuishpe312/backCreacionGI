package ec.edu.espe.GrupoInvestigacion.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "UZITGLINK",schema = "UTIC")
public class ModelLink {
    @Id
    @GeneratedValue(generator = "UZITGLINK_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGLINK_Sequence", sequenceName = "UZISGLINK")
    @Column(name = "UZITGLINK_ID")
    private Long id;

    @Column(name = "UZITGLINK_JUSTIFICATION")
    private String justification;

    @Column(name = "UZITGLINK_STATE")
    private Character state;

    @Column(name = "UZITGLINK_STATUS")
    private Character status;

    @Column(name = "UZITGLINK_TYPE")
    private String type;

    @Column(name = "UZITGLINK_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGLINK_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGLINK_USER_MODIFICATE")
    private String userModificate;

    @Column(name = "UZITGLINK_DATE_MODIFICATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;
    @ManyToOne
    @JoinColumn(name = "UZITGINV_GROUP_ID", nullable = false)
    private ModelInvGroup modelInvGroup;
    @ManyToOne
    @JoinColumn(name = "UZITGUSER_ID")
    private ModelUser modelUser;
}
