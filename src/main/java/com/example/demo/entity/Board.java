package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue
    int id;
    @NotNull
    String title;
    @NotNull
    String content;

    int hit;
    int auth;
    @CreationTimestamp
    Date created_at;
    @UpdateTimestamp
    Date updated_at;
}
