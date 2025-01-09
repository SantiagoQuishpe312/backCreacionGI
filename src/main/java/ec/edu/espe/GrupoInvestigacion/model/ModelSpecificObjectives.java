package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = " UZITGSPECIFIC_OBJ", schema = "UTIC")
//actualizar el nombre a specific
public class ModelSpecificObjectives {
    @Id
    @GeneratedValue(generator = "UZITGOBJECTIVES_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGOBJECTIVES_Sequence", sequenceName = "UZISGOBJECTIVES")
    @Column(name = "UZITGSPECIFIC_OBJ_ID")
    private Long id;

    @Column(name = "UZITGSPECIFIC_OBJ_OBJ", nullable = false)
    private String objective;


    @Column(name = "UZITGSPECIFIC_OBJ_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGSPECIFIC_OBJ_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGSPECIFIC_OBJ_USER_MODIFIC")
    private String userModificate;

    @Column(name = "UZITGSPECIFIC_OBJ_DATE_MODIFIC")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @OneToMany(mappedBy = "modelSpecificObjectives",cascade = CascadeType.ALL)
    private List<ModelObj_Strategies_ODS> modelObjStrategiesOds;
    @OneToMany(mappedBy = "modelSpecificObjectives",cascade = CascadeType.ALL)
    private List<ModelCompliance> modelCompliance;
    @OneToMany(mappedBy = "modelSpecificObjectives",cascade = CascadeType.ALL)
    private List<ModelControlPanel> modelControlPanel;


}
