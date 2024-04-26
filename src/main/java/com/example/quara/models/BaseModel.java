package com.example.quara.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@MappedSuperclass
public abstract  class BaseModel {

        @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
        protected Long id;

        @Column(nullable = false)
        @CreatedDate // handles only while object creation
        @Temporal(TemporalType.TIMESTAMP) // stores the timestamp while insertion
        protected  Date createdAt;


        @LastModifiedDate  // handles only when the object is modified
        @Temporal(TemporalType.TIMESTAMP)
        protected  Date updatedAt;



}
