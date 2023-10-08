package by.home.inerviewme.controller;

import by.home.inerviewme.entity.Question;
import by.home.inerviewme.service.QuestionsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@Slf4j
public class QuestionController {

    private final QuestionsService questionsService;

    @GetMapping("/questions")
    private String getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "id") String sortBy,
            Model model) {

        var pageable = PageRequest.of(page, 10, Sort.by(sortBy));
        var questions = questionsService.getAll(pageable);

        model.addAttribute("questions", questions);
        model.addAttribute("currentPage", page);
        model.addAttribute("sortBy", sortBy);
        return "questions/index";
    }

    @PostMapping("/questions/upload")
    public String uploadImage(
            Model model,
            @RequestParam("file") MultipartFile file) {
        try {
            var count = questionsService.uploadFile(file);
            model.addAttribute("msg", "Загружено " + count + " вопросов");
        } catch (Exception e) {
            model.addAttribute("msg", "Возникла ошибка при загрузке вопросов");
        }
        //model.addAttribute("questions", questionsService.getAll());
        return "questions/index";
    }
}
