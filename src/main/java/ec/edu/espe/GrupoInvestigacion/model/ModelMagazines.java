package ec.edu.espe.GrupoInvestigacion.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "UZITGMAGAZINES",schema = "UTIC")
public class ModelMagazines {
    @Id
    @GeneratedValue(generator = "UZITGMAGAZINES_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGMAGAZINES_Sequence", sequenceName = "UZISGMAGAZINES")
    @Column(name = "UZITGMAGAZINES_ID")
    private Long id;

    @Column(name = "UZITGMAGAZINES_TITLE")
    private String title;

    @Column(name = "UZITGMAGAZINES_AUTHORS")
    private String authors;

    @Column(name = "UZITGMAGAZINES_MAGAZINE")
    private String magazine;

    @Column(name = "UZITGMAGAZINES_INDEX")
    private String index;

    @Column(name = "UZITGMAGAZINES_DOI_ISSN")
    private String doi;

    @Column(name = "UZITGMAGAZINES_UQUARTIL_IF_SJR ")
    private String quartilIfSjr;

    @Column(name = "UZITGMAGAZINES_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGMAGAZINES_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGMAGAZINES_USER_MODIFICATE")
    private String userModificate;

    @Column(name = "UZITGMAGAZINES_DATE_MODIFICATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @ManyToOne
    @JoinColumn(name = "UZITGACTIVITY_REPORT_ID ", nullable = false)
    private ModelActivityReport modelActivityReport;
}
