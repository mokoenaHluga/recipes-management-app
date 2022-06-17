package com.hloni.recipeManagement.service;

import com.hloni.recipeManagement.dto.RecipeDto;

import java.util.List;

public interface RecipeService {
    List<RecipeDto> getAllRecipes();

    RecipeDto addRecipe(RecipeDto recipeDto);

    RecipeDto updateRecipe(RecipeDto recipeDto);

    void deleteRecite(Long id);

    RecipeDto getRecipe(Long id);
}
