package com.hloni.recipeManagement.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class IngredientDto implements Serializable {
    private Long recipeId;
    private String ingredientName;
}
