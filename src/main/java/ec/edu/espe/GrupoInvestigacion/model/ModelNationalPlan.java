package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "UZITGNATIONAL_PLAN",schema = "UTIC")
public class ModelNationalPlan {
    @Id
    @GeneratedValue(generator = "UZITGNATIONAL_PLAN_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGNATIONAL_PLAN_Sequence", sequenceName = "UZISGNATIONAL_PLAN")
    @Column(name = "UZITGNATIONAL_PLAN_ID")
        private Long id;
    @Column(name = "UZITGNATIONAL_PLAN_N_POLITIC")
    private String nPolitics;

    @Column(name = "UZITGNATIONAL_PLAN_DESCRIPTION")
    private String description;

    @Column(name = "UZITGNATIONAL_PLAN_STATE")
    private Boolean state;

    @Column(name = "UZITGNATIONAL_PLAN_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGNATIONAL_PLAN_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGNATIONAL_PLAN_USER_MODIFI")
    private String userModificate;

    @Column(name = "UZITGNATIONAL_PLAN_DATE_MODIFI")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @OneToMany(mappedBy = "modelNationalPlan")
    private List<ModelDeveNati> modelDeveNati;


}
