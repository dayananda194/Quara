package com.example.quara.repositories;

import com.example.quara.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    public List<Question> findAll();

    public Optional<Question> findById(Long id);

    public Question save(Question question);

    public List<Question> findByUserId(Long id);

}
