package com.hloni.recipeManagement.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RecipeDto implements Serializable {
    private Long id;
    private String recipeTitle;
    private String mealType;
    private Integer numberItServes;
    private String difficultyLevel;
    private List<IngredientDto> ingredients;
}
