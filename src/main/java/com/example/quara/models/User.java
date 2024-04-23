package com.example.quara.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

    @Column(nullable = false)
    Date dob;


}
