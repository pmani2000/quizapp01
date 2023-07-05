package com.application.quizapp.service;

import com.application.quizapp.dao.QuestionDao;
import com.application.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> allQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
         questionDao.save(question);
         try{
         return new ResponseEntity<>("success",HttpStatus.CREATED);
    }catch (Exception e){
             e.printStackTrace();
         }
         return new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.getByCategory(category), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public String deleteQuestionById(Integer id) {
        questionDao.deleteById(id);
        return "Deleted Successfully";
    }

    public String updateQuestion(Question question) {
          questionDao.save(question);
          return "updated successfully";


    }
}
