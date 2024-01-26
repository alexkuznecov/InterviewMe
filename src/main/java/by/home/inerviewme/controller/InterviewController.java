package by.home.inerviewme.controller;

import by.home.inerviewme.service.CandidateService;
import by.home.inerviewme.service.InterviewService;
import by.home.inerviewme.service.QuestionInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
public class InterviewController {

    private final InterviewService interviewService;
    private final CandidateService candidateService;
    private final QuestionInfoService questionInfoService;

    @GetMapping("/interview")
    private String getAll(Model model) {
        return "/interview/start";
    }

    @PostMapping("/interview/start")
    private String startInterview(
            @RequestParam(name = "candidateName") String name,
            @RequestParam(name = "candidateCv") String svLink,
            @RequestParam(name = "candidatePosition") String position,
            @RequestParam(name = "candidateExperience") String experienceByCv,
            @RequestParam(name = "candidateAdditionalInfo") String additionalInfo,
            Model model) {
        var id = candidateService.save(name, position, svLink, experienceByCv, additionalInfo);
        var themes = interviewService.getCategoriesWithQuestions();
        model.addAttribute("themes", themes);
        model.addAttribute("candidateId", id);
        return "/interview/main";
    }

    @PostMapping("/stop")
    public String stopInterview(
            @RequestParam(name = "candidateId") Long candidateId,
            @RequestParam(name = "reviewInfo") String reviewInfo,
            @RequestParam(name = "candidateRecPosition") String candidateRecPosition,
            Model model) {
        model.addAttribute("candidate", candidateService.updateReviewInfo(candidateId, reviewInfo, candidateRecPosition));
        model.addAttribute("responseInfo", questionInfoService.getCandidateResponsesInfo(candidateId));
        return "/interview/result";
    }

}
