package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "UZITGANNEXES")
public class ModelAnnexes {

    @Id
    @GeneratedValue(generator = "UZITGANNEXES_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGANNEXES_Sequence", sequenceName = "UZISGANNEXES")
    @Column(name = "UZITGANNEXES_ID")
    private Long id;
    @Column(name = "UZITGANNEXES_NAME", nullable = false)
    private String name;

    @Column(name = "UZITGANNEXES_ROUTE", nullable = false)
    private String route;

    @Column(name = "UZITGANNEXES_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGANNEXES_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGANNEXES_USER_MODIFICATE")
    private String userModificate;

    @Column(name = "UZITGANNEXES_DATE_MODIFICATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @ManyToOne
    @JoinColumn(name = "UZITGINV_GROUP_ID", nullable = false)
    private ModelInvGroup modelInvGroup;

}
