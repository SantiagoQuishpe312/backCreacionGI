package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "UZITGODS ",schema = "UTIC")
public class ModelOds {
    @Id
    @GeneratedValue(generator = "UZITGODS_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGODS_Sequence", sequenceName = "UZISGODS")
    @Column(name = "UZITGODS_ID")
    private Long id;
    @Column(name = "UZITGODS_DESCRIPTION")
    private String description;

    @Column(name = "UZITGODS_ODS", nullable = false)
    private String ods;

    @Column(name = "UZITGODS_STATE", nullable = false)
    private Boolean state;

    @Column(name = "UZITGODS_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGODS_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGODS_USER_MODIFICATE")
    private String userModificate;

    @Column(name = "UZITGODS_DATE_MODIFICATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @OneToMany(mappedBy = "modelOds")
    private List<ModelObj_Strategies_ODS> modelObjStrategiesOds;


}
