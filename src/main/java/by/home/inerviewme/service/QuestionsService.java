package by.home.inerviewme.service;

import by.home.inerviewme.entity.Question;
import by.home.inerviewme.repository.QuestionsRepository;
import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionsService {

    private final List<String> levels = List.of("Junior", "Middle", "Senior");

    private final QuestionsRepository questionsRepository;

    public Page<Question> getAll(Pageable pageable) {
        return questionsRepository.findAll(pageable);
    }

    @SneakyThrows
    public long uploadFile(MultipartFile file) {
        long count = 0;
        try (CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            String[] lineInArray;
            String currentCategory = "";
            String currentLevel = "";
            while ((lineInArray = reader.readNext()) != null) {
                var text = lineInArray[0].trim();
                if (StringUtils.isNoneEmpty(text)) {
                    if (levels.contains(text)) {
                        currentLevel = text;
                    } else if (text.matches("^[0-9].*? *") ||
                            text.matches("^\"[0-9].*? *")) {
                        int firstSpaceIndex = text.indexOf(" ");
                        questionsRepository.save(Question.builder()
                                        .text(text.substring(firstSpaceIndex + 1))
                                        .level(currentLevel)
                                        //.category(currentCategory)
                                        .build());
                        count++;
                    } else {
                        currentCategory = text;
                    }
                }
            }
        }
        return count;
    }
}
