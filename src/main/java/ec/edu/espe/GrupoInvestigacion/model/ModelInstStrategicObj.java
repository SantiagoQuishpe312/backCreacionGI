package ec.edu.espe.GrupoInvestigacion.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import javax.print.attribute.standard.MediaSize;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "UZITGINST_STRATEGIC_OBJ", schema = "UTIC")
public class ModelInstStrategicObj {
    @Id
    @GeneratedValue(generator = "UZITGINST_STRATEGIC_OBJ_Sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize =  1, name = "UZITGINST_STRATEGIC_OBJ_Sequence", sequenceName = "UZISGINST_STRATEGIC_OBJ")
    @Column(name = "UZITGINST_STRATEGIC_OBJ_ID")
    private Long id;

    @Column(name = "UZITGINST_STRATEGIC_OBJ_OBJ")
    private String obj;

    @Column(name = "UZITGINST_STRATEGIC_OBJ_STATE")
    private Boolean state;

    @Column(name = "UZITGINST_STRATEGIC_OBJ_USER_C")
    private String userCreate;

    @JsonFormat(pattern = "yyyyy-MM-dd",shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UZITGINST_STRATEGIC_OBJ_DATE_C")
    private Date dateCreate;

    @Column(name = "UZITGINST_STRATEGIC_OBJ_USER_M")
    private String userModificate;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UZITGINST_STRATEGIC_OBJ_DATE_M")
    private Date dateModificate;

    @OneToMany(mappedBy = "modelInstStrategicObj")
    private List<ModelStrategies> modelStrategies;

    @OneToMany(mappedBy = "modelInstStrategicObj")
    private List<ModelDevelopmentPlan> modelDevelopmentPlans;

}
