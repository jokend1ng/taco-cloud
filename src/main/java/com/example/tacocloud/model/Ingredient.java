package com.example.tacocloud.model;

import jakarta.persistence.Entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import jakarta.persistence.Id;


@Entity
@Data
@AllArgsConstructor


public class Ingredient {
    @Id
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;

    public Ingredient() {

    }


    public enum  Type {
        WRAP,PROTEIN,VEGGIES,CHEESE,SAUCE
    }

}
