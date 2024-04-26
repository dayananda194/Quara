package com.example.quara.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends BaseModel {

    @Enumerated(value= EnumType.STRING)
    private CommentType commentType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    private Answer answer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false)
    private String content;

}
