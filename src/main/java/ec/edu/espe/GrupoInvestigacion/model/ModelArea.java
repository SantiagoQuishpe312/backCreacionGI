package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "UZITGAREA", schema = "UTIC")
public class ModelArea {

    @Id
    @GeneratedValue(generator = "UZITGAREA_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGAREA_Sequence", sequenceName = "UZISGAREA")
    @Column(name = "UZITGAREA_ID")
    private Long id;

    @Column(name = "UZITGAREA_NAME", nullable = false)
    private String name;

    @Column(name = "UZITGAREA_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGAREA_STATE")
    private Boolean state;

    @Column(name = "UZITGAREA_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGAREA_USER_MODIFICATE")
    private String userModificate;

    @Column(name = "UZITGAREA_DATE_MODIFICATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @OneToMany(mappedBy = "modelArea")
    private List<ModelInvGroup_Area> modelInvGroupArea;
    @OneToMany(mappedBy = "modelArea")
    private List<ModelLine> modelLine;

}