package com.example.quara.controllers;

import com.example.quara.models.Question;
import com.example.quara.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
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
    public ResponseEntity<Question> getQuestions() {
        List<Question> questions = questionService.findAll();
       // System.out.println(questions.get(0).getContent());
        return  new ResponseEntity<>(questions.get(0),HttpStatus.OK);

    }


}
