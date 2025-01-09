package ec.edu.espe.GrupoInvestigacion.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;
@Data
@Embeddable
public class ModelInvMemberId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "UZITGUSER_ID", nullable = false)
    private ModelUser modelUser;
    @ManyToOne
    @JoinColumn(name = "UZITGINV_GROUP_ID", insertable = false, updatable = false)
    private ModelInvGroup modelInvGroup;

}
