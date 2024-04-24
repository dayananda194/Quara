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
    private Question question=new Question();

    @ManyToOne(fetch = FetchType.LAZY)
    private Answer answer=new Answer();

    @ManyToOne(fetch = FetchType.LAZY)
    private Comment comment=new Comment();

    @ManyToOne(fetch = FetchType.LAZY)
    private User user=new User();

    @Column(nullable = false)
    private String content;

}
