package by.home.inerviewme.service;

import by.home.inerviewme.dto.CandidateDTO;
import by.home.inerviewme.entity.Candidate;
import by.home.inerviewme.entity.Position;
import by.home.inerviewme.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public Long save(final String name,
                     final String expectedPosition,
                     final String cvLink,
                     final String experience,
                     final String additionalInfo) {
        return candidateRepository
                .save(Candidate.builder()
                        .name(name)
                        .cvLink(cvLink)
                        .expectedPosition(Position.getByValue(expectedPosition))
                        .experience(experience)
                        .additionalInfo(additionalInfo)
                        .build())
                .getId();
    }

    public Candidate getCandidate(final Long id) {
        return candidateRepository.getReferenceById(id);
    }

    public CandidateDTO updateReviewInfo(final Long candidateId, final String reviewInfo, final String candidateRecPosition) {
        var candidate = candidateRepository.getReferenceById(candidateId);
        candidate.setReviewInfo(reviewInfo);
        candidate.setRecommendedPosition(Position.getByValue(candidateRecPosition));
        candidate = candidateRepository.save(candidate);
        return CandidateDTO.builder()
                .name(candidate.getName())
                .experience(candidate.getExperience())
                .additionalInfo(candidate.getAdditionalInfo())
                .reviewInfo(candidate.getReviewInfo())
                .recommendedPosition(candidate.getRecommendedPosition().name())
                .build();
    }
}
