package com.example.quara.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity

@Inheritance(strategy = InheritanceType.JOINED)
public   class MyProduct
{
    @Id
    Long id;
    String product;

}
