package by.home.inerviewme.dto;

import by.home.inerviewme.entity.Question;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class CategoryDTO {

    private String name;
    private List<Question> questions;
    private Boolean isReady;

}
