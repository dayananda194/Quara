package com.example.quara.repositories;

import com.example.quara.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    public List<Question> findAll();
}
