package by.home.inerviewme.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "cv_link")
    private String cvLink;
    @Column(name = "experience")
    private String experience;
    @Column(name = "expected_position")
    private Position expectedPosition;
    @Column(name = "recommended_position")
    private Position recommendedPosition;
    @CreationTimestamp
    @Column(name="interviewDate")
    private LocalDateTime interviewDate;
    @Column(name = "additional_info")
    private String additionalInfo;
    @Column(name = "review_info")
    private String reviewInfo;
}
