package com.example.quara.controllers;

import com.example.quara.models.Comment;
import com.example.quara.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

        CommentService  commentService;

        @Autowired
        CommentController(CommentService commentService) {
            this.commentService = commentService;
        }

        @PostMapping
        ResponseEntity<?> addComment(@RequestBody Comment comment) {

                Comment newComment = commentService.addComment(comment);
                if(newComment != null) {
                    return new ResponseEntity<>(  newComment, HttpStatus.CREATED);
                }
                return new ResponseEntity<>(" Unable to ADD COMMENT ", HttpStatus.BAD_REQUEST);

        }
        @GetMapping
        ResponseEntity<?> getAllComments() {
                List<Comment> comments = commentService.getAllComments();
                if(comments != null) {
                        return new ResponseEntity<>( comments, HttpStatus.OK);
                }
                return new ResponseEntity<>("There are no Comments", HttpStatus.NOT_FOUND);

        }
}
