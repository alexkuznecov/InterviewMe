package by.home.inerviewme.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "questions_info",
        indexes = @Index(name = "uniqueQuestionInfo", columnList = "question_id,candidate_id", unique = true))
@ToString
public class QuestionInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "question_id", insertable=false, updatable=false)
    private Long questionId;
    @ManyToOne
    @JoinColumn(name="question_id", nullable=false)
    private Question question;
    @Column(name = "mark")
    @Enumerated(EnumType.ORDINAL)
    private Mark mark;
    @Column(name = "additional_info")
    private String additionalInfo;
    @Column(name = "candidate_id", insertable=false, updatable=false)
    private Long candidateId;
    @ManyToOne
    @JoinColumn(name="candidate_id", nullable=false)
    private Candidate candidate;

}
