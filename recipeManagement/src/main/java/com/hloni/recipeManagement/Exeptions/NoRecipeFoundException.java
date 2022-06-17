package com.hloni.recipeManagement.Exeptions;

public class NoRecipeFoundException extends RuntimeException {
    public NoRecipeFoundException(String message) {
        super(message);
    }
}
