package com.example.tacocloud.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity

public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date createdAt=new Date();
    @NotNull
    @Size(min=5,message = "Name must be at least 5 characters long")
    private String name;
    @NotNull
    @Size(min=1,message = "You must choose at least 1 ingredient")
    @ManyToMany()
    private List<Ingredient> ingredients=new ArrayList<>();
    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }
}
