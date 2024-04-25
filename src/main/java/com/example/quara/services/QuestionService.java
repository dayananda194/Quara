package com.example.quara.services;

import com.example.quara.models.Question;
import com.example.quara.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

        @Autowired
        private QuestionRepository questionRepository;

        public List<Question> findAll()
        {
            return questionRepository.findAll();

        }
}
