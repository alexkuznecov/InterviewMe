package by.home.inerviewme.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class QuestionInfoDTO {
    private Long questionId;
    private Long candidateId;
    private String mark;
    private String additionalInfo;
}
