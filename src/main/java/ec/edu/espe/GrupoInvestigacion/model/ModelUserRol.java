package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "UZITGUSER_ROL", schema = "UTIC")
public class ModelUserRol implements Serializable {
@EmbeddedId
private ModelUserRolId id;
    @ManyToOne
    @JoinColumn(name = "UZITGUSER_ID", insertable = false, updatable = false)
    private ModelUser modelUser;
    @ManyToOne
    @JoinColumn(name = "UZITGROL_ID", insertable = false, updatable = false)
    private ModelRol modelRol;

    @Column(name = "UZITGUSER_ROL_USER_CREATE", length = 50)
    private String userCreate;

    @Column(name = "UZITGUSER_ROL_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGUSER_ROL_USER_MODIFICATE", length = 50)
    private String userModificate;

    @Column(name = "UZITGUSER_ROL_DATE_MODIFICATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

}
