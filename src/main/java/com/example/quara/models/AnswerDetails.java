package com.example.quara.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDetails extends BaseModel {


    private Long upvote;

    private Long downvote;

    @ManyToOne(fetch = FetchType.LAZY)
    private Answer answer;

}
