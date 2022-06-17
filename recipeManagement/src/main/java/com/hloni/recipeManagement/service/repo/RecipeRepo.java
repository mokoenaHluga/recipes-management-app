package com.hloni.recipeManagement.service.repo;

import com.hloni.recipeManagement.service.repo.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Long> {
    //Query method, due to naming method
    void deleteRecipeById(Long id);

    Optional<Recipe> findRecipeById(Long id);
}

