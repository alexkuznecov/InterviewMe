package by.home.inerviewme.repository;

import by.home.inerviewme.entity.QuestionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionInfoRepository extends JpaRepository<QuestionInfo, Long> {

    Optional<QuestionInfo> findByQuestionIdAndCandidateId(final Long questionId, final Long candidateId);

}
