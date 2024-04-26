package com.example.quara.repositories;

import com.example.quara.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository  extends JpaRepository<Comment, Long> {

        public Comment save(Comment comment);

        public Optional<Comment> findById(Long id);

        public List<Comment> findAll();

}
