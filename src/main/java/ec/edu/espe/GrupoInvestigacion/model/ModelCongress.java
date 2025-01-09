package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "UZITGCONGRESS",schema = "UTIC")
public class ModelCongress {
    @Id
    @GeneratedValue(generator = "UZITGCONGRESS_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGCONGRESS_Sequence", sequenceName = "UZISGCONGRESS")
    @Column(name = "UZITGCONGRESS_ID")
    private Long id;

    @Column(name = "UZITGCONGRESS_TITLE")
    private String title;

    @Column(name = "UZITGCONGRESS_AUTHOR")
    private String author;

    @Column(name = "UZITGCONGRESS_CONGRESS")
    private String congress;

    @Column(name = "UZITGCONGRESS_DOI")
    private String index;

    @Column(name = "UZITGCONGRESS_IF_SJR ")
    private String ifSjr;

    @Column(name = "UZITGCONGRESS_QUARTIL")
    private String quartil;

    @Column(name = "UZITGCONGRESS_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGCONGRESS_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGCONGRESS_USER_MODIFICATE")
    private String userModificate;

    @Column(name = "UZITGCONGRESS_DATE_MODIFICATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @ManyToOne
    @JoinColumn(name = "UZITGACTIVITY_REPORT_ID",nullable = false)
    private ModelActivityReport modelActivityReport;

}
