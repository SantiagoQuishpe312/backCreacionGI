package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "UZITGOBJ_STRA_ODS", schema = "UTIC")

public class ModelObj_Strategies_ODS {
    @EmbeddedId
    private ModelObj_Strategies_ODS_Id id;

    @Column(name = "UZITGOBJ_STRA_ODS_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGOBJ_STRA_ODS_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGOBJ_STRA_ODS_USER_MODIFIC")
    private String userModificate;

    @Column(name = "UZITGOBJ_STRA_ODS_DATE_MODIFIC")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @ManyToOne
    @JoinColumn(name = "UZITGSTRATEGIES_ID", insertable = false, updatable = false)
    private ModelStrategies modelStrategies;

    @ManyToOne
    @JoinColumn(name = "UZITGSPECIFIC_OBJ_ID",insertable = false,updatable = false)
    private ModelSpecificObjectives modelSpecificObjectives;

    @ManyToOne
    @JoinColumn(name = "UZITGODS_ID",insertable = false,updatable = false)
    private ModelOds modelOds;
}
