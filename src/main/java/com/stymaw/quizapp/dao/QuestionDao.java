package com.stymaw.quizapp.dao;


import com.stymaw.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {


    List<Question> findByCategory(String category);

    List<Question> findByDifficultylevel(String difficultylevel);


    @Query(nativeQuery = true, value = "SELECT * FROM question q where q.category=:category ORDER BY RANDOM() LIMIT :numQ")
    List<Question> findRandomQuestionByCategory(String category, int numQ);


}
