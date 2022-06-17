package com.hloni.recipeManagement.service.repo.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "RECIPE")
public class Recipe {
    @Id
    @Column(name = "RECIPE_ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RECIPE_TITLE", nullable = false)
    private String recipeTitle;

    @Column(name = "MEAL_TYPE", nullable = false)
    private String mealType;

    @Column(name = "NUMBER_IT_SERVES", nullable = false)
    private Integer numberItServes;

    @Column(name = "DIFFICULTY_LEVEL", nullable = false)
    private String difficultyLevel;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredients;
}
