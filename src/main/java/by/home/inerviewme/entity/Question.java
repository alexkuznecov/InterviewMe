package by.home.inerviewme.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "text")
    private String text;
    @Column(name = "answer")
    private String answer;
    @Column(name = "category_id", insertable=false, updatable=false)
    private Long categoryId;
    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;
    @Column(name = "level")
    private String level;
    @Column(name = "priority", columnDefinition = "integer default 0")
    private Integer priority;

}
