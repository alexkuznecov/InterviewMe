package by.home.inerviewme.service;

import by.home.inerviewme.dto.QuestionInfoDTO;
import by.home.inerviewme.entity.Mark;
import by.home.inerviewme.entity.QuestionInfo;
import by.home.inerviewme.repository.CandidateRepository;
import by.home.inerviewme.repository.QuestionInfoRepository;
import by.home.inerviewme.repository.QuestionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionInfoService {

    private final QuestionInfoRepository questionInfoRepository;
    private final QuestionsRepository questionsRepository;
    private final CandidateRepository candidateRepository;

    public void saveOrUpdateQuestionInfo(final QuestionInfoDTO questionInfoDTO) {
        questionInfoRepository
                .findByQuestionIdAndCandidateId(
                        questionInfoDTO.getQuestionId(), questionInfoDTO.getCandidateId())
                .ifPresentOrElse((questionInfo -> {
                    questionInfo.setMark(Mark.getByValue(questionInfoDTO.getMark()));
                    questionInfo.setAdditionalInfo(questionInfoDTO.getAdditionalInfo());
                    questionInfoRepository.save(questionInfo);
                }), () -> questionInfoRepository.save(
                        QuestionInfo
                                .builder()
                                .question(questionsRepository.getReferenceById(questionInfoDTO.getQuestionId()))
                                .candidate(candidateRepository.getReferenceById(questionInfoDTO.getCandidateId()))
                                .mark(Mark.getByValue(questionInfoDTO.getMark()))
                                .additionalInfo(questionInfoDTO.getAdditionalInfo())
                                .build()));
    }

    public List<QuestionInfoDTO> getCandidateResponsesInfo(final Long candidateId) {
        return questionInfoRepository.findByCandidateId(candidateId)
                .stream()
                .map(questionInfo ->
                        QuestionInfoDTO.builder()
                                .questionId(questionInfo.getQuestionId())
                                .questionText(questionsRepository.getReferenceById(questionInfo.getQuestionId()).getText())
                                .mark(questionInfo.getMark().name())
                                .additionalInfo(questionInfo.getAdditionalInfo())
                                .build())
                .collect(Collectors.toList());
    }

}
