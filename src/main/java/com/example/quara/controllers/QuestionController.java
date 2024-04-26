package com.example.quara.controllers;

import com.example.quara.models.Question;
import com.example.quara.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import org.springframework.http.HttpStatus;

@RestController

@RequestMapping("/questions")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    QuestionController(QuestionService questionService) {
        this.questionService = questionService;

    }

    @GetMapping
    public ResponseEntity<List<Question>> getQuestions() {
        List<Question> questions = questionService.findAll();
       // System.out.println(questions.get(0).getContent());
        return  new ResponseEntity<>(questions,HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuestionById(@PathVariable Long id) {   // It returns the ResponseEntity object of any type
            Question question = questionService.findById(id);
            if(question == null) {

                String error = "The Required Question  with id  "+id+"  is not found";
                return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);  // It accepts two parameters , request body and HTTPStatus Code(an enum)
            }
            return new ResponseEntity<>(question,HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody Question question){
            System.out.println(question);
            return null;

    }

}
