package com.hloni.recipeManagement.Constants;

public enum DifficultyLevel {
    BEGINNER("beginner"), INTERMEDIATE("Intermediate"), ADVANCED("Advanced");

    public final String level;

    private DifficultyLevel(String level) {
        this.level = level;
    }
}
