package ec.edu.espe.GrupoInvestigacion.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "UZITGSTRATEGIES", schema = "UTIC")
public class ModelStrategies {
    @Id
    @GeneratedValue(generator = "UZITGSTRATEGIES_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGSTRATEGIES_Sequence", sequenceName = "UZISGSTRATEGIES")
    @Column(name = "UZITGSTRATEGIES_ID")
    private Long id;

    @Column(name = "UZITGSTRATEGIES_STRATEGY")
    private String strategy;
    @Column(name = "UZITGSTRATEGIES_STATE")
    private Boolean state;

    @Column(name = "UZITGSTRATEGIES_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGSTRATEGIES_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGSTRATEGIES_USER_MODIFICAT")
    private String userModificate;

    @Column(name = "UZITGSTRATEGIES_DATE_MODIFICAT")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @ManyToOne
    @JoinColumn(name = "UZITGINST_STRATEGIC_OBJ_ID", nullable = false)
    private ModelInstStrategicObj modelInstStrategicObj;

    @OneToMany(mappedBy = "modelStrategies",cascade = CascadeType.ALL)
    private List<ModelObj_Strategies_ODS> modelObjStrategiesOds;

}
