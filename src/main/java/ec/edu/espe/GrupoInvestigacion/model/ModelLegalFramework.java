package ec.edu.espe.GrupoInvestigacion.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "UZITGLEGAL_FRAMEWORK",schema = "UTIC")
public class ModelLegalFramework {
    @Id
    @GeneratedValue(generator = "UZITGLEGAL_FRAMEWORK_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGLEGAL_FRAMEWORK_Sequence", sequenceName = "UZISGLEGAL_FRAMEWORK")
    @Column(name = "UZITGLEGAL_FRAMEWORK_ID")
    private Long id;

    @Column(name = "UZITGLEGAL_FRAMEWORK_NAME")
    private String name;

    @Column(name = "UZITGLEGAL_FRAMEWORK_STATE")
    private Boolean state;

    @Column(name = "UZITGLEGAL_FRAMEWORK_USER_CREA")
    private String createdByUser;

    @Column(name = "UZITGLEGAL_FRAMEWORK_DATE_CREA")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGLEGAL_FRAMEWORK_USER_MODI")
    private String modifiedByUser;

    @Column(name = "UZITGLEGAL_FRAMEWORK_DATE_MODI")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @OneToMany(mappedBy = "modelLegalFramework")
    private List<ModelDeveLega> modelDeveLega;


}
