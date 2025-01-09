package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "UZITGROL", schema = "UTIC")
public class ModelRol {

    @Id
    @Column(name = "UZITGROL_ID")
    @GeneratedValue(generator = "UZITGROL_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGROL_Sequence", sequenceName = "UZISGROL")
    private Long id;

    @Column(name = "UZITGROL_NAME")
    private String name;

    @Column(name = "UZITGROL_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGROL_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGROL_USER_MODIFICATE")
    private String userModificate;

    @Column(name = "UZITGROL_DATE_MODIFICATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @OneToMany(mappedBy = "modelRol", cascade = CascadeType.ALL)
    private List<ModelUserRol> modelUserRol;

}
