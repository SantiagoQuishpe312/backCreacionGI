package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "UZITGCOMPLIANCE ",schema = "UTIC")
public class ModelCompliance {
    @EmbeddedId
    private ModelComplianceId id;

    @Column(name = "UZITGCOMPLIANCE_VERIFIABLE")
    private String verifiable;

    @Column(name = "UZITGCOMPLIANCE_PERCENTAGE")
    private BigDecimal percentage;

    @Column(name = "UZITGCOMPLIANCE_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGCOMPLIANCE_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGCOMPLIANCE_USER_MODIFICAT")
    private String userModificate;

    @Column(name = "UZITGCOMPLIANCE_DATE_MODIFICAT")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @ManyToOne
    @JoinColumn(name="UZITGACTIVITY_REPORT_ID", insertable = false,updatable = false)
    private ModelActivityReport modelActivityReport;

    @ManyToOne
    @JoinColumn(name="UZITGSPECIFIC_OBJ_ID ", insertable = false,updatable = false)
    private ModelSpecificObjectives modelSpecificObjectives;

}
