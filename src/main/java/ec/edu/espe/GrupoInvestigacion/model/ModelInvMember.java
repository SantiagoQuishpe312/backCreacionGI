package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@Entity
@Table(name = "UZITGINV_MEMBER", schema = "UTIC")

public class ModelInvMember {
    @EmbeddedId
    private ModelInvMemberId id;
    @ManyToOne
    @JoinColumn(name = "UZITGUSER_ID", insertable = false, updatable = false)
    private ModelUser modelUser;
    @ManyToOne
    @JoinColumn(name = "UZITGINV_GROUP_ID", insertable = false, updatable = false)
    private ModelInvGroup modelInvGroup;

    @Column(name = "UZITGINV_MEMBER_USER_CREATE")
    private String userCreate;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UZITGINV_MEMBER_DATE_CREATE")
    private Date dateCreate;

    @Column(name = "UZITGINV_MEMBER_USER_MODIFICAT")
    private String userModificate;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UZITGINV_MEMBER_DATE_MODIFICAT")
    private Date dateModificate;
}
