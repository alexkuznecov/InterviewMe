package by.home.inerviewme.controller;

import by.home.inerviewme.dto.QuestionInfoDTO;
import by.home.inerviewme.service.QuestionInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class QuestionInfoController {

    private final QuestionInfoService questionInfoService;

    @PostMapping("/question-info")
    public String updateQuestionInfo(@RequestBody QuestionInfoDTO model) {
        questionInfoService.saveOrUpdateQuestionInfo(model);
        return "OK";
    }

}
