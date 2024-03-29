package by.home.inerviewme.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@Builder
public class QuestionInfoDTO {
    private Long questionId;
    private String questionText;
    private Long candidateId;
    private String mark;
    private String additionalInfo;
}
