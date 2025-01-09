package ec.edu.espe.GrupoInvestigacion.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "UZITGEVENTS",schema = "UTIC")
public class ModelEvents {
    @Id
    @GeneratedValue(generator = "UZITGEVENTS_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGEVENTS_Sequence", sequenceName = "UZISGEVENTS")
    @Column(name = "UZITGEVENTS_ID")
    private Long id;

    @Column(name = "UZITGEVENTS_NAME")
    private String name;

    @Column(name = "UZITGEVENTS_CITY")
    private String city;

    @Column(name = " UZITGEVENTS_COUNTRY")
    private String country;

    @Column(name = "UZITGEVENTS_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "UZITGEVENTS_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGEVENTS_USER_MODIFICATE")
    private String userModificate;

    @Column(name = "UZITGEVENTS_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGEVENTS_DATE_MODIFICATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;
    @ManyToOne
    @JoinColumn(name = "UZITGACTIVITY_REPORT_ID",nullable = false)
    private ModelActivityReport modelActivityReport;
}
