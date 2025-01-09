package ec.edu.espe.GrupoInvestigacion.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class ModelObj_Strategies_ODS_Id implements Serializable {
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
