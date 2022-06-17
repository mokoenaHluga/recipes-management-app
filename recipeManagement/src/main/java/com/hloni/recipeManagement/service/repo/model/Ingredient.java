package com.hloni.recipeManagement.service.repo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "INGREDIENT")
public class Ingredient {
    @Id
    @Column(name = "INGREDIENT_ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "INGREDIENT_NAME")
    private String ingredientName;

    @ManyToOne
    @JoinColumn(name="RECIPE_ID", nullable=false)
    private Recipe recipe;
}
