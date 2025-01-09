package ec.edu.espe.GrupoInvestigacion.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "UZITGUSER", schema = "UTIC")
public class ModelUser {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "UZITGUSER_ID")
    @GeneratedValue(generator = "UZITGUSER_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGUSER_Sequence", sequenceName = "UZISGUSER")
    private Long idUser;

    @Column(name = "UZITGUSER_USER")
    private String user;

    @Column(name = "UZITGUSER_NAME", nullable = false)
    private String name;

    @Column(name = "UZITGUSER_INSTITUTIONAL_ID")
    private String institutionalId;

    @Column(name = "UZITGUSER_IDENTIFICATION", nullable = false)
    private String identification;

    @Column(name = "UZITGUSER_PHONE")
    private String phone;

    @Column(name = "UZITGUSER_EMAIL", nullable = false)
    private String email;

    @Column(name = "UZITGUSER_DEPARTMENT")
    private String department;

    @Column(name = "UZITGUSER_INSTITUTION")
    private String institution;

    @Column(name = "UZITGUSER_USER_POSITION")
    private String position;

    @Column(name = "UZITGUSER_NATIONALITY")
    private String nationality;

    @Column(name = "UZITGUSER_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "UZITGUSER_DATE_MODIFICATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificatedDate;

    @Column(name = "UZITGUSER_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGUSER_USER_MODIFICATE")
    private String userModificate;

    @OneToMany(mappedBy = "modelUser", cascade =  CascadeType.ALL)
    private List<ModelControlPanel> controlPanel;
    @OneToMany(mappedBy = "modelUser", cascade = CascadeType.ALL)
    private List<ModelInvGroup> modelInvGroup;
    @OneToMany(mappedBy = "modelUser", cascade = CascadeType.ALL)
    private List<ModelUserRol> modelUserRol;
    @OneToMany(mappedBy = "modelUser", cascade = CascadeType.ALL)
    private List<ModelInvMember> modelInvMember;
    @OneToMany(mappedBy = "modelUser", cascade = CascadeType.ALL)
    private List<ModelLink> modelLink;
}
