package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "UZITGPOSTGRAD_TESIS", schema = "UTIC")
public class ModelPostGradTesis {
    @Id
    @GeneratedValue(generator = "UZITGPOSTGRAD_TESIS_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGPOSTGRAD_TESIS_Sequence", sequenceName = "UZISGPOSTGRAD_TESIS")
    @Column(name = "UZITGPOSTGRAD_TESIS_ID")
    private Long id;
    @Column(name = "UZITGPOSTGRAD_TESIS_NAME")
    private String name;
    @Column(name = "UZITGPOSTGRAD_TESIS_THESISTS")
    private String thesists;
    @Column(name = "UZITGPOSTGRAD_TESIS_USER_CREAT")
    private String userCreate;

    @Column(name = "UZITGPOSTGRAD_TESIS_DATE_CREAT")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGPOSTGRAD_TESIS_USER_MODIF")
    private String userModificate;

    @Column(name = "UZITGPOSTGRAD_TESIS_DATE_MODIF")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @ManyToOne
    @JoinColumn(name = "UZITGACTIVITY_REPORT_ID", nullable = false)
    private ModelActivityReport modelActivityReport;

}
