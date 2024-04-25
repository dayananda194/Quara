package com.example.quara.services;

import com.example.quara.models.Question;
import com.example.quara.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class QuestionService {

        @Autowired
        private QuestionRepository questionRepository;

        public List<Question> findAll()
        {
            return questionRepository.findAll();

        }

        public Question findById(Long id)
        {
               Optional<Question> optionalQuestion =  questionRepository.findById(id) ;
               return optionalQuestion.orElse(null);
        }

}
