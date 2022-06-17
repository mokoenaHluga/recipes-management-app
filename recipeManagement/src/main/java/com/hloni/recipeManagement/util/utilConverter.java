package com.hloni.recipeManagement.util;

import com.hloni.recipeManagement.dto.IngredientDto;
import com.hloni.recipeManagement.dto.RecipeDto;
import com.hloni.recipeManagement.service.repo.model.Ingredient;
import com.hloni.recipeManagement.service.repo.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class utilConverter {

    public static RecipeDto mapRecipeDto(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(recipe.getId());
        recipeDto.setRecipeTitle(recipe.getRecipeTitle());
        recipeDto.setMealType(recipe.getMealType());
        recipeDto.setIngredients(mapIncredients(recipe.getIngredients()));
        recipeDto.setNumberItServes(recipe.getNumberItServes());
        recipeDto.setDifficultyLevel(recipe.getDifficultyLevel());

        return recipeDto;
    }

    private static List<IngredientDto> mapIncredients(List<Ingredient> ingredients) {
        List<IngredientDto> ingredientDtoList = new ArrayList<>();
        ingredients.forEach(i -> {
            ingredientDtoList.add(mapIngredientDto(i));
        });

        return ingredientDtoList;
    }

    public static Recipe mapRecipe(RecipeDto recipeDTO) {
        Recipe recipe = new Recipe();
        recipe.setId(recipeDTO.getId());
        recipe.setRecipeTitle(recipeDTO.getRecipeTitle());
        recipe.setMealType(recipeDTO.getMealType());
        recipe.setNumberItServes(recipeDTO.getNumberItServes());
        recipe.setDifficultyLevel(recipeDTO.getDifficultyLevel());
        recipe.setIngredients(recipe.getIngredients());

        return recipe;
    }

    public static List<RecipeDto> getAllRecipes(List<Recipe> recipes) {
        List<RecipeDto> recipeList = new ArrayList<>();
        recipes.forEach(r -> { recipeList.add(mapRecipeDto(r)); });

        return recipeList;
    }

    public static IngredientDto mapIngredientDto(Ingredient ingredient){
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setIngredientName(ingredient.getIngredientName());
        ingredientDto.setRecipeId(ingredient.getId());

        return ingredientDto;
    }
}
