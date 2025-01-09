package ec.edu.espe.GrupoInvestigacion.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "UZITGDEGREE_TESIS")
public class ModelDegreeTesis {
    @Id
    @GeneratedValue(generator = "UZITGDEGREE_TESIS_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGDEGREE_TESIS_Sequence", sequenceName = "UZISGDEGREE_TESIS")
    @Column(name = "UZITGDEGREE_TESIS_ID")
    private Long id;

    @Column(name = "UZITGDEGREE_TESIS_NAME")
    private String name;

    @Column(name = "UZITGDEGREE_TESIS_THESISTS")
    private String thesists;

    @Column(name = "UZITGDEGREE_TESIS_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGDEGREE_TESIS_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGDEGREE_TESIS_USER_MODIFIC")
    private String userModificate;

    @Column(name = "UZITGDEGREE_TESIS_DATE_MODIFIC")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @ManyToOne
    @JoinColumn(name = "UZITGACTIVITY_REPORT_ID",nullable = false)
    private ModelActivityReport modelActivityReport;
}
