package com.hloni.recipeManagement.service.impl;

import com.hloni.recipeManagement.Exeptions.NoRecipeFoundException;
import com.hloni.recipeManagement.dto.RecipeDto;
import com.hloni.recipeManagement.service.RecipeService;
import com.hloni.recipeManagement.service.repo.RecipeRepo;
import com.hloni.recipeManagement.service.repo.model.Recipe;
import com.hloni.recipeManagement.util.utilConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepo recipeRepo;

    @Autowired
    public RecipeServiceImpl(RecipeRepo recipeRepo) {
        this.recipeRepo = recipeRepo;
    }

    @Override
    public List<RecipeDto> getAllRecipes() {
        List<Recipe> recipe = recipeRepo.findAll();
        if (recipe.size() > 0) {
            return utilConverter.getAllRecipes(recipe);
        }
        return new ArrayList<>();
    }

    @Override
    public RecipeDto addRecipe(RecipeDto recipeDto) {
        Recipe recipe = recipeRepo.save(utilConverter.mapRecipe(recipeDto));
        return utilConverter.mapRecipeDto(recipe);
    }

    @Override
    public RecipeDto updateRecipe(RecipeDto recipeDto) {
        Recipe recipe = recipeRepo.save(utilConverter.mapRecipe(recipeDto));
        return utilConverter.mapRecipeDto(recipe);
    }

    @Override
    public void deleteRecite(Long id) {
        recipeRepo.deleteRecipeById(id);
    }

    public RecipeDto getRecipe(Long id) {
        Recipe recipe = recipeRepo.findRecipeById(id)
                .orElseThrow(() -> new NoRecipeFoundException("The Recipe is not found for:" + " ID= " + id));
        return utilConverter.mapRecipeDto(recipe);
    }

}
