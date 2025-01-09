package ec.edu.espe.GrupoInvestigacion.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "UZITGBOOK_CHAPTER", schema = "UTIC")
public class ModelBookChapter {
    @Id
    @GeneratedValue(generator = "UZITGBOOK_CHAPTER_Sequence", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = "UTIC", allocationSize = 1, name = "UZITGBOOK_CHAPTER_Sequence", sequenceName = "UZISGBOOK_CHAPTER")
    @Column(name = "UZITGBOOK_CHAPTER_ID")
    private Long id;

    @Column(name = "UZITGBOOK_CHAPTER_TITLE")
    private String title;

    @Column(name = "UZITGBOOK_CHAPTER_AUTHOR")
    private String author;

    @Column(name = "UZITGBOOK_CHAPTER_EDITORIAL ")
    private String editorial;

    @Column(name = "UZITGBOOK_CHAPTER_ISBN")
    private String isbn;

    @Column(name = "UZITGBOOK_CHAPTER_USER_CREATE")
    private String userCreate;

    @Column(name = "UZITGBOOK_CHAPTER_DATE_CREATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;

    @Column(name = "UZITGBOOK_CHAPTER_USER_MODIFIC")
    private String userModificate;

    @Column(name = "UZITGBOOK_CHAPTER_DATE_MODIFIC")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = JsonFormat.DEFAULT_TIMEZONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModificate;

    @ManyToOne
    @JoinColumn(name = "UZITGACTIVITY_REPORT_ID",nullable = false)
    private ModelActivityReport modelActivityReport;
}
