package ec.edu.espe.GrupoInvestigacion.model;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

import java.util.Objects;

@Data
@Embeddable

public class ModelUserRolId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "UZITGUSER_ID", nullable = false)
    private ModelUser modelUser;
    @ManyToOne
    @JoinColumn(name = "UZITGROL_ID", nullable = false)
    private ModelRol modelRol;
}
