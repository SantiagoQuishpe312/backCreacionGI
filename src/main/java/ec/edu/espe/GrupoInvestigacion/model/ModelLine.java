package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "UZITGLINE", schema = "UTIC")
public class ModelLine {
    @Id
    @GeneratedValue(generator = "UZITGLINE_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGLINE_Sequence", sequenceName = "UZISGLINE")
    @Column(name = "UZITGLINE_ID")
    private Long id;

    @Column(name = "UZITGLINE_NAME", nullable = false)
    private String name;

    @Column(name = "UZITGLINE_STATE", nullable = false)
    private Boolean state;

    @Column(name = "UZITGLINE_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGLINE_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGLINE_USER_MODIFICATE")
    private String userModificate;

    @Column(name = "UZITGLINE_DATE_MODIFICATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @OneToMany(mappedBy = "modelLine")
    private List<ModelInvGroup_Line> modelInvGroup_line;

    @ManyToOne
    @JoinColumn(name = "UZITGAREA_ID", nullable = false)
    private ModelArea modelArea;
}