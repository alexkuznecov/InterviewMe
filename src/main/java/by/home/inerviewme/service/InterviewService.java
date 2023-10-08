package by.home.inerviewme.service;

import by.home.inerviewme.entity.Question;
import by.home.inerviewme.dto.CategoryDTO;
import by.home.inerviewme.repository.CategoryRepository;
import by.home.inerviewme.repository.QuestionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InterviewService {

    private final CategoryRepository categoryRepository;
    private final QuestionsRepository questionsRepository;

    public List<CategoryDTO> getCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(category ->
                        CategoryDTO.builder()
                                .name(category.getName())
                                .build())
                .collect(Collectors.toList());
    }

    public List<CategoryDTO> getCategoriesWithQuestions() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> CategoryDTO.builder()
                        .name(category.getName())
                        .questions(questionsRepository.findAllByCategoryId(category.getId()))
                        .build())
                .toList();
//        return List.of(
//                CategoryDTO.builder().name("Java + Core").questions(List.of(Question.builder().id(2L).text("Как передаются параметры в методы в Java?").build())).build(),
//                CategoryDTO.builder().name("Сборка мусора").questions(List.of(Question.builder().id(3L).text("Какие сборщики мусора вы знаете?").build())).build(),
//                CategoryDTO.builder().name("Collection").build(),
//                CategoryDTO.builder().name("Exceptions").build(),
//                CategoryDTO.builder().name("Lambda").build(),
//                CategoryDTO.builder().name("Concurrency").build(),
//                CategoryDTO.builder().name("SQL").build(),
//                CategoryDTO.builder().name("Transactions").build(),
//                CategoryDTO.builder().name("Spring + Boot").build(),
//                CategoryDTO.builder().name("Тесты").build(),
//                CategoryDTO.builder().name("Reactive").build(),
//                CategoryDTO.builder().name("Docker").build(),
//                CategoryDTO.builder().name("Kuber").build(),
//                CategoryDTO.builder().name("Kafka").build(),
//                CategoryDTO.builder().name("Фронт").build(),
//                CategoryDTO.builder().name("Паттерн").build(),
//                CategoryDTO.builder().name("Процессы на проекте").build(),
//                CategoryDTO.builder().name("Гитфлоу").build(),
//                CategoryDTO.builder().name("Код ревью").build()
//        );
    }

}
