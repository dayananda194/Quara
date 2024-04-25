package com.example.quara.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class User extends  BaseModel{

    @Column(nullable = false)
    String username;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    Date dob;


}
