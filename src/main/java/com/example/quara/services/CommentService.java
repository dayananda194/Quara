package com.example.quara.services;

import com.example.quara.models.*;
import com.example.quara.repositories.CommentRepository;
import com.example.quara.repositories.QuestionRepository;
import com.example.quara.repositories.UserRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final UserService userService;
    CommentRepository commentRepository;
        QuestionRepository questionRepository;
        UserRepository userRepository;

        @Autowired
        CommentService(CommentRepository commentRepository, QuestionRepository questionRepository, UserRepository userRepository, UserService userService) {
            this.commentRepository = commentRepository;
            this.questionRepository = questionRepository;
            this.userRepository = userRepository;
            this.userService = userService;
        }
        // A comment should be created only if there is a question, answer or else for a comment itself(nested comment)
        public Comment addComment(Comment comment) {
            CommentType commentType = comment.getCommentType();

            // System.out.println(commentType);

            User user =  comment.getUser();
            // System.out.println(user+" in question Controller" +user.getId());
            Optional<User> reqUser = userService.findById(user.getId());
            if(reqUser.isEmpty())
            {
                String error = "The   User with id "+user.getId()+" is not found in the database";
                return  null;
            }

            if(comment.getCommentType().equals(CommentType.QUESTION))
            {
                    Optional<Question> optionalQuestion  = questionRepository.findById(comment.getQuestion().getId());
                    if(optionalQuestion.isPresent())
                    {
                        return commentRepository.save(comment);
                    }
            }
            else if(comment.getCommentType().equals(CommentType.COMMENT)){
                Optional<Comment> optionalComment  = commentRepository.findById(comment.getId());
                if(optionalComment.isPresent())
                {
                    return commentRepository.save(comment);
                }
            }
            return null;
        }

        public Optional<Comment> getCommentById(Long id) {
                return commentRepository.findById(id);
        }
        public List<Comment> getAllComments() {
            return commentRepository.findAll();
        }

}
