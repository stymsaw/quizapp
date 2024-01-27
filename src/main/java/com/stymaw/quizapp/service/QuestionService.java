package com.stymaw.quizapp.service;

import com.stymaw.quizapp.model.Question;
import com.stymaw.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {


    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }


    public List<Question> getQuestionsByDifficulty(String difficultylevel) {
        return questionDao.findByDifficultylevel(difficultylevel);
    }

    public ResponseEntity<Question> addQuestion(Question question) {
        return new ResponseEntity<>(questionDao.save(question), HttpStatus.CREATED);
    }

}
