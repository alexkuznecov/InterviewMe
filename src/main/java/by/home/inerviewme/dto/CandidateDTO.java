package by.home.inerviewme.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@Builder
public class CandidateDTO {
    private String name;
    private String experience;
    private String additionalInfo;
    private String reviewInfo;
    private String recommendedPosition;
}
