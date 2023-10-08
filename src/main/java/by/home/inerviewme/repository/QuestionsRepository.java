package by.home.inerviewme.repository;

import by.home.inerviewme.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<Question, Long> {

    List<Question> findAllByCategoryId(Long categoryId);

}
