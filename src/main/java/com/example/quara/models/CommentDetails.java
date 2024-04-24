package com.example.quara.models;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CommentDetails extends BaseModel{

    private Long upvote;

    private Long downvote;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comment comment = new Comment();

}
